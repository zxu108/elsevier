package com.zen.hub.zenhub.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zen.hub.zenhub.config.DatabaseConfig;
import com.zen.hub.zenhub.mappers.sorting.CenterSorting;
import com.zen.hub.zenhub.mappers.sorting.SortingDirection;
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
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void getCenterList() {
		
		List<Center> centerList = centerMapper.getCenterList(CenterSorting.CENTER_NAME, SortingDirection.ASC);
		
		assertThat(centerList).isNotNull();
		assertThat(centerList.size()).isEqualTo(6);
		assertThat(centerList.get(0).getCenterId()).isEqualTo("TEST1");
		assertThat(centerList.get(0).getCenterCountry()).isEqualTo("USA");
    	assertThat(centerList.get(0).getCenterCloseStartDate().toString()).isEqualTo("Tue Nov 06 00:00:00 EST 2018");			
	}
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void findCenterWithCenterId() {
		
		List<Center> centerList = centerMapper.findCenterWithCenterId("test1");
		
		assertThat(centerList).isNotNull();
		assertThat(centerList.size()).isEqualTo(1);
		assertThat(centerList.get(0).getCenterId()).isEqualTo("TEST1");
		assertThat(centerList.get(0).getCenterCountry()).isEqualTo("USA");
    	assertThat(centerList.get(0).getCenterCloseStartDate().toString()).isEqualTo("Tue Nov 06 00:00:00 EST 2018");			
	}
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void findCenterWithCenterIdNoMatch() {
		
		List<Center> centerList = centerMapper.findCenterWithCenterId("nomatchtest1");
		
		assertThat(centerList).isEmpty();
	}
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void getTotalCenterCount() {
		
		int totalCenters = centerMapper.getTotalCenterCount();
		
		assertThat(totalCenters).isEqualTo(6);
	}
	
	@Test
	@Sql(scripts  = "./CenterTestData.sql")
	public void insertCenter() {
		Center ct = getCenter();
		
		int inserted = centerMapper.insertCenter(ct);
		
		assertThat(inserted).isEqualTo(1);
		
		int totalCenters = centerMapper.getTotalCenterCount();
		
		assertThat(totalCenters).isEqualTo(7);
		
		List<Center> centerList = centerMapper.getCenterList(CenterSorting.CENTER_NAME, SortingDirection.ASC);
		
		assertThat(centerList.size()).isEqualTo(7);
		assertThat(centerList.get(6).getId()).isEqualTo(7);
		assertThat(centerList.get(6).getCenterAddress1()).isEqualTo("tset address 1");
		assertThat(centerList.get(6).getCenterAddress2()).isEqualTo("test address 2");
		assertThat(centerList.get(6).getCenterCity()).isEqualTo("Hockessin");	
		assertThat(centerList.get(6).getCenterCloseStartDate().toString()).isEqualTo("Wed Jul 18 13:16:42 EDT 2018");		
		assertThat(centerList.get(6).getCenterDescription()).isEqualTo("test center description");		
		assertThat(centerList.get(6).getCenterLevel()).isEqualTo(88);				
		assertThat(centerList.get(6).getCenterId()).isEqualTo("FirstCenter101");
		assertThat(centerList.get(6).getCenterCountry()).isEqualTo("USA");
    	assertThat(centerList.get(6).getCenterCloseEndDate().toString()).isEqualTo("Mon Mar 11 16:16:47 EDT 2019");	
    	assertThat(centerList.get(6).getCenterName()).isEqualTo("Test center one");
       	assertThat(centerList.get(6).getCenterPassword()).isEqualTo("testpw1");   
       	assertThat(centerList.get(6).getCenterZipCode()).isEqualTo("19707");   
      	assertThat(centerList.get(6).getCenterOwnerEmail()).isEqualTo("testmail@testside.com");   
     	assertThat(centerList.get(6).getCenterOwnerLandPhone()).isEqualTo("6524314425");   
    	assertThat(centerList.get(6).getCenterOwnerMobilePhone()).isEqualTo("3028761122");        			
	}

	private Center getCenter() {
		Center center = new Center();

		center.setCenterAddress1("tset address 1");
		center.setCenterAddress2("test address 2");
		center.setCenterCity("Hockessin");

		Date centerCloseEndDate = new GregorianCalendar(2019, 2, 11, 16, 16, 47).getTime();		
		center.setCenterCloseEndDate(centerCloseEndDate);

		Date centerCloseStartDate = new GregorianCalendar(2018, 6, 18, 13, 16, 42).getTime();		
		center.setCenterCloseStartDate(centerCloseStartDate);
		
		center.setCenterCountry("USA");
		center.setCenterCustomerRating(12);
		center.setCenterDescription("test center description");
		center.setCenterId("FirstCenter101");
		center.setCenterLevel(88);
		
		byte[] centerlogo = new byte[100];
		for (int i=0; i< 100; i++) {
			centerlogo[i] = 2;
		}
		center.setCenterLogo(centerlogo);
		
		center.setCenterModifiedBy("ZXUtest");
		center.setCenterModifiedDate(new Date());
		center.setCenterName("Test center one");
		
		Date centerOpendDate = new GregorianCalendar(2019, 2, 16, 13, 16, 42).getTime();			
		center.setCenterOpendDate(centerOpendDate);
		
		center.setCenterOpenStatus(false);
		center.setCenterOwnerEmail("testmail@testside.com");
		center.setCenterOwnerFirstName("John");
		center.setCenterOwnerLandPhone("6524314425");
		center.setCenterOwnerLastName("Farry");
		center.setCenterOwnerMidName("MidIn");
		center.setCenterOwnerMobilePhone("3028761122");
		center.setCenterPassword("testpw1");
		center.setCenterState("DE");
		center.setCenterZipCode("19707");

		return center;
	}

}
