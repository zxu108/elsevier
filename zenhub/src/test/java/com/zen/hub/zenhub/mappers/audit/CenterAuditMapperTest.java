package com.zen.hub.zenhub.mappers.audit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zen.hub.zenhub.config.DatabaseConfig;
import com.zen.hub.zenhub.model.audit.CenterAudit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
@ActiveProfiles({"local", "UnitTest"})
public class CenterAuditMapperTest {

	@Autowired
	private CenterAuditMapper centerAuditMapper;
	
	@Test
	@Sql(scripts  = "./CenterAuditTestData.sql")
	public void insertCenter() {
		CenterAudit ct = getCenterAudit();
		
		int inserted = centerAuditMapper.insertAudit(ct);
		
		assertThat(inserted).isEqualTo(1);
		
//		int totalCenters = centerAuditMapper.getTotalCenterCount();
		
//		assertThat(totalCenters).isEqualTo(7);
//		
//		List<Center> centerList = centerMapper.getCenterList(CenterSorting.CENTER_NAME, SortingDirection.ASC);
		
//		assertThat(centerList.size()).isEqualTo(7);
//		assertThat(centerList.get(6).getId()).isEqualTo(7);
//		assertThat(centerList.get(6).getCenterAddress1()).isEqualTo("tset address 1");
//		assertThat(centerList.get(6).getCenterAddress2()).isEqualTo("test address 2");
//		assertThat(centerList.get(6).getCenterCity()).isEqualTo("Hockessin");	
//		assertThat(centerList.get(6).getCenterCloseStartDate().toString()).isEqualTo("Wed Jul 18 13:16:42 EDT 2018");		
//		assertThat(centerList.get(6).getCenterDescription()).isEqualTo("test center description");		
//		assertThat(centerList.get(6).getCenterLevel()).isEqualTo(88);				
//		assertThat(centerList.get(6).getCenterId()).isEqualTo("FirstCenter101");
//		assertThat(centerList.get(6).getCenterCountry()).isEqualTo("USA");
//    	assertThat(centerList.get(6).getCenterCloseEndDate().toString()).isEqualTo("Mon Mar 11 16:16:47 EDT 2019");	
//    	assertThat(centerList.get(6).getCenterName()).isEqualTo("Test center one");
//       	assertThat(centerList.get(6).getCenterPassword()).isEqualTo("testpw1");   
//       	assertThat(centerList.get(6).getCenterZipCode()).isEqualTo("19707");   
//      	assertThat(centerList.get(6).getCenterOwnerEmail()).isEqualTo("testmail@testside.com");   
//     	assertThat(centerList.get(6).getCenterOwnerLandPhone()).isEqualTo("6524314425");   
//    	assertThat(centerList.get(6).getCenterOwnerMobilePhone()).isEqualTo("3028761122");        			
	}

	private CenterAudit getCenterAudit() {
		CenterAudit centerAudit = new CenterAudit();

		centerAudit.setCenterAddress1("tset address 1");
		centerAudit.setCenterAddress2("test address 2");
		centerAudit.setCenterCity("Hockessin");

		Date centerCloseEndDate = new GregorianCalendar(2019, 2, 11, 16, 16, 47).getTime();		
		centerAudit.setCenterCloseEndDate(centerCloseEndDate);

		Date centerCloseStartDate = new GregorianCalendar(2018, 6, 18, 13, 16, 42).getTime();		
		centerAudit.setCenterCloseStartDate(centerCloseStartDate);
		
		centerAudit.setCenterCountry("USA");
		centerAudit.setCenterCustomerRating(12);
		centerAudit.setCenterDescription("test center description");
		centerAudit.setCenterId("FirstCenter101");
		centerAudit.setCenterLevel(88);
		
		byte[] centerlogo = new byte[100];
		for (int i=0; i< 100; i++) {
			centerlogo[i] = 2;
		}
		centerAudit.setCenterLogo(centerlogo);
		
		centerAudit.setCenterModifiedBy("ZXUtest");
		centerAudit.setCenterModifiedDate(new Date());
		centerAudit.setCenterName("Test center one");
		
		Date centerOpendDate = new GregorianCalendar(2019, 2, 16, 13, 16, 42).getTime();			
		centerAudit.setCenterOpendDate(centerOpendDate);
		
		centerAudit.setCenterOpenStatus(false);
		centerAudit.setCenterOwnerEmail("testmail@testside.com");
		centerAudit.setCenterOwnerFirstName("John");
		centerAudit.setCenterOwnerLandPhone("6524314425");
		centerAudit.setCenterOwnerLastName("Farry");
		centerAudit.setCenterOwnerMidName("MidIn");
		centerAudit.setCenterOwnerMobilePhone("3028761122");
		centerAudit.setCenterPassword("testpw1");
		centerAudit.setCenterState("DE");
		centerAudit.setCenterZipCode("19707");
		
		centerAudit.setCenterNameOld("NameOld");
		centerAudit.setCenterPasswordOld("Oldpw");
		centerAudit.setCenterDescriptionOld("test description Old");
		centerAudit.setCenterOpenStatusOld(false);

		return centerAudit;
	}

}
