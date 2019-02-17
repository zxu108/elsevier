package com.zen.hub.zenhub.transformers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.transformer.DTOToModelTransformer;

public class DTOToModelTransformerTest {

	private DTOToModelTransformer testee = new DTOToModelTransformer();
	

	@Test
	public void toCenter() {
		CenterDTO centerDto = getCenterDTO();
		
		Center center = testee.toCenter(centerDto);
		
		assertThat(center.getCenterAddress1()).isEqualTo(centerDto.getCenterAddress1());
		assertThat(center.getCenterAddress2()).isEqualTo(centerDto.getCenterAddress2());
		assertThat(center.getCenterCity()).isEqualTo(centerDto.getCenterCity());
		assertThat(center.getCenterName()).isEqualTo(centerDto.getCenterName());
		assertThat(center.getCenterCountry()).isEqualTo(centerDto.getCenterCountry());
		assertThat(center.getCenterZipCode()).isEqualTo(centerDto.getCenterZipCode());
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
