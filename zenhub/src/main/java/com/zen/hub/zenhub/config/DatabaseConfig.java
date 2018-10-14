package com.zen.hub.zenhub.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;	



@Configuration
@MapperScan("com.zen.hub.zenhub.mappers")
public class DatabaseConfig {

@Autowired
private DataSource dataSource;

@Bean
public SqlSessionFactory sqlSessionFactory() throws Exception {
	SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	sqlSessionFactory.setDataSource(dataSource);
	sqlSessionFactory.setTypeAliasesPackage("com.zen.hub.zenhub.model");
	sqlSessionFactory.setDatabaseIdProvider(databaseIdProvider());
	
	return sqlSessionFactory.getObject();
}

private DatabaseIdProvider databaseIdProvider() {
	Properties properties = new Properties();
	properties.setProperty("Oracle", "oracle");
	properties.setProperty("HSQL Database Engine", "hsqldb");
	properties.setProperty("Mysql", "mysql");
	DatabaseIdProvider provider = new VendorDatabaseIdProvider();
	provider.setProperties(properties);
	
	return provider;
}

@Bean 
	public DataSourceTransactionManager transactionManager () {
	return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "dataScript") 
	@Profile({ "unitTest" })
	public String getDataScriptTest() {
		return null;
	}

	@Bean(name = "dataScript") 
	@Profile({ "!unitTest" })
	public String getDataScriptLocal() {
		return "classpath:local/data.sql";
	}

	@Configuration
	@Profile({ "local", "unitTest" })
	public class LocalDatabase {	

	@Autowired
	@Qualifier("dataScript")
	private String dataScript;
	
	@Bean
	@Profile({"!nonEmbedded"})
	public DataSource dataSourceEmbedded() {
		EmbeddedDatabaseBuilder dBBuilder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).setSeparator(";;").addScript("classpath:local/schema.sql");
		
		if (dataScript != null) {
			dBBuilder.addScript("classpath:local/data.sql");
		}
		
		return dBBuilder.build();
	}
	
	@Bean
	@Profile({ "nonEmbedded" })
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setUsername("jxu");
		config.setPassword("SmartBoy1");
		config.setJdbcUrl("jdbc:mariadb://localhost:3306/zenhub");
		config.setDriverClassName("org.mariadb.jdbc.Driver");
		return new HikariDataSource(config);
	}
	
}
}

