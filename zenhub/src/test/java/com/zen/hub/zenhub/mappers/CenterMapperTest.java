package com.zen.hub.zenhub.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.zen.hub.zenhub.config.DatabaseConfig;
import com.zen.hub.zenhub.model.Center;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
@ActiveProfiles({"local", "UnitTest"})
public class CenterMapperTest {

	@Autowired
	private CenterMapper centerMapper;
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void testSelectCust() {
		
		Center ct = centerMapper.selectCenter(2);
		
		assertThat(ct).isNotNull();
		assertThat(ct.getCenterName()).isEqualTo("Test Center 2");
		assertThat(ct.getCenterId()).isEqualTo("TEST2");
		assertThat(ct.getCenterCountry()).isEqualTo("USA");
    	assertThat(ct.getCenterCloseStartDate().toString()).isEqualTo("Sat Oct 06 00:00:00 EDT 2018");		
	
	}

}
