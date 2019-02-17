package com.zen.hub.zenhub.controllers.validators;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.zen.hub.zenhub.dto.CenterDTO;

@RunWith(MockitoJUnitRunner.class)
public class CenterValidatorTest {

	@InjectMocks 
	CenterValidator testee;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void insertCenterNullCenter() {
		
		//given 
		thrown.expect(ValidationException.class);
		thrown.expectMessage("No Valid Center Data");
		
		//when
		testee.validateInsert(null);
	}
	
	@Test
	public void insertCenterNullId() {
		
		CenterDTO cDto = getCenterDTO();
		cDto.setCenterId(null);
		//given 
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Please enter a valid center Id");
		
		//when
		testee.validateInsert(cDto);
	}
	
	@Test
	public void insertCenterNullName() {
		
		CenterDTO cDto = getCenterDTO();
		cDto.setCenterName(null);
		//given 
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Please enter a valid center Name");
		
		//when
		testee.validateInsert(cDto);
	}
	
	
	private CenterDTO getCenterDTO() {
		CenterDTO centerDto = new CenterDTO();

		centerDto.setCenterAddress1("tset address 1");
		centerDto.setCenterAddress2("test address 2");
		centerDto.setCenterCity("Hockessin");

		Date centerCloseEndDate = new GregorianCalendar(2019, 2, 11, 16, 16, 47).getTime();		
		centerDto.setCenterCloseEndDate(centerCloseEndDate);

		Date centerCloseStartDate = new GregorianCalendar(2018, 6, 18, 13, 16, 42).getTime();		
		centerDto.setCenterCloseStartDate(centerCloseStartDate);
		
		centerDto.setCenterCountry("USA");
		centerDto.setCenterCustomerRating(12);
		centerDto.setCenterDescription("test center description");
		centerDto.setCenterId("FirstCenter101");
		centerDto.setCenterLevel(88);
		
		byte[] centerlogo = new byte[100];
		for (int i=0; i< 100; i++) {
			centerlogo[i] = 2;
		}
		centerDto.setCenterLogo(centerlogo);
		
		centerDto.setCenterModifiedBy("ZXUtest");
		centerDto.setCenterModifiedDate(new Date());
		centerDto.setCenterName("Test center one");
		
		Date centerOpendDate = new GregorianCalendar(2019, 2, 16, 13, 16, 42).getTime();			
		centerDto.setCenterOpendDate(centerOpendDate);
		
		centerDto.setCenterOpenStatus(false);
		centerDto.setCenterOwnerEmail("testmail@testside.com");
		centerDto.setCenterOwnerFirstName("John");
		centerDto.setCenterOwnerLandPhone("6524314425");
		centerDto.setCenterOwnerLastName("Farry");
		centerDto.setCenterOwnerMidName("MidIn");
		centerDto.setCenterOwnerMobilePhone("3028761122");
		centerDto.setCenterPassword("testpw1");
		centerDto.setCenterState("DE");
		centerDto.setCenterZipCode("19707");

		return centerDto;
	}
}
