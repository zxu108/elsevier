package com.zen.hub.zenhub.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zen.hub.zenhub.config.DatabaseConfig;
import com.zen.hub.zenhub.model.CustomerInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
@ActiveProfiles({"local", "UnitTest"})
public class CustMapperTest {

	@Autowired
	private CustMapper custMapper;
	
	@Test
	@Sql(scripts  = "./CustomerInfoTestData.sql")
	public void testSelectCust() {
		
		List<CustomerInfo> llst = custMapper.selectCust(1);
		
		assertThat(llst).isNotNull();
		assertThat(llst.size()).isEqualTo(1);
		assertThat(llst.get(0).getCustName()).isEqualTo("John Charner");
		assertThat(llst.get(0).getCustProj()).isEqualTo("lawn mower");
	
	}

}
