package com.zen.hub.zenhub.transformers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.transformer.ModelToDTOTransformer;

@Component
public class ModelToDTOTransformerTest {

	private ModelToDTOTransformer testee = new ModelToDTOTransformer();
	
	@Test
	public void toCenterDTO() {
		Center center = getCenter();
		
		CenterDTO cDto = testee.toCenterDTO(center);
		
		assertThat(cDto.getCenterCloseStartDate()).isEqualTo(center.getCenterCloseStartDate());
		assertThat(cDto.getCenterDescription()).isEqualTo(center.getCenterDescription());
		assertThat(cDto.getCenterLevel()).isEqualTo(center.getCenterLevel());		
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
