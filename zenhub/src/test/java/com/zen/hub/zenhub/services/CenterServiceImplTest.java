package com.zen.hub.zenhub.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.zen.hub.zenhub.controllers.validators.ValidationException;
import com.zen.hub.zenhub.mappers.CenterMapper;
import com.zen.hub.zenhub.mappers.sorting.CenterSorting;
import com.zen.hub.zenhub.mappers.sorting.SortingDirection;
import com.zen.hub.zenhub.model.Center;

import com.google.common.collect.Lists;

@RunWith(MockitoJUnitRunner.class)
public class CenterServiceImplTest {

	@Mock
	private CenterMapper centerMapper;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
@InjectMocks
private CenterServiceImpl testee;
	
	@Test
	public void selectCenter() {

		Center ct = new Center();
		
		ct.setCenterId("Test Center");
		
		when(centerMapper.selectCenter(1)).thenReturn(ct);
		
		Center center = testee.selectCenter(1);
		
		verify(centerMapper, times(1)).selectCenter(1);
		
		assertThat(center.getCenterId()).isEqualTo(ct.getCenterId());
		
	}
	
	@Test
	public void getCenterList() {

		Center ct1 = new Center();		
		ct1.setCenterId("Test Center1");
		ct1.setCenterName("center name1");
		
		Center ct2 = new Center();		
		ct2.setCenterId("Test Center2");
		ct2.setCenterName("center name2");
		
		when(centerMapper.getCenterList(eq(CenterSorting.CENTER_NAME), eq(SortingDirection.ASC))).thenReturn(Lists.newArrayList(ct1, ct2));
		
		List<Center> centers = testee.getCenterList(CenterSorting.CENTER_NAME, SortingDirection.ASC);
		
		verify(centerMapper, times(1)).getCenterList(eq(CenterSorting.CENTER_NAME), eq(SortingDirection.ASC));
		
		assertThat(centers.size()).isEqualTo(2);
		assertThat(centers.get(0).getCenterId()).isEqualTo(ct1.getCenterId());
		assertThat(centers.get(0).getCenterName()).isEqualTo(ct1.getCenterName());		
	}
	
	@Test
	public void findCenterWithCenterId() {

		Center ct1 = new Center();		
		ct1.setCenterId("Test Center1");
		ct1.setCenterName("center name1");

		when(centerMapper.findCenterWithCenterId("testId1")).thenReturn(Lists.newArrayList(ct1));
		
		List<Center> centers = testee.findCenterWithCenterId("testId1");
		
		verify(centerMapper, times(1)).findCenterWithCenterId("testId1");
		
		assertThat(centers.size()).isEqualTo(1);
		assertThat(centers.get(0).getCenterId()).isEqualTo(ct1.getCenterId());
		assertThat(centers.get(0).getCenterName()).isEqualTo(ct1.getCenterName());		
	}

	@Test
	public void getTotalCenterCount() {

		when(centerMapper.getTotalCenterCount()).thenReturn(10);
		
		int totalCount= testee.getTotalCenterCount();
		
		verify(centerMapper, times(1)).getTotalCenterCount();
		
		assertThat(totalCount).isEqualTo(10);

	}
	
	@Test
	public void insertCenterAlreadyExist() {		
		Center ct = new Center();		
		ct.setCenterId("Test Center1");
		ct.setCenterName("center name1");
		ct.setCenterAddress1("test address 1");

		when(centerMapper.findCenterWithCenterId(any())).thenReturn(Lists.newArrayList(ct));
		
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Center Alreay Exists");
		
		testee.insertCenter(ct);
		
		verify(centerMapper, times(1)).findCenterWithCenterId(any());
		verify(centerMapper, times(1)).insertCenter(ct);
	}
	
	@Test
	public void insertCenter() {		
		Center ct = new Center();		
		ct.setCenterId("Test Center1");
		ct.setCenterName("center name1");
		ct.setCenterAddress1("test address 1");

		when(centerMapper.findCenterWithCenterId(any())).thenReturn(null);
		when(centerMapper.insertCenter(eq(ct))).thenReturn(1);
		
		Center center = testee.insertCenter(ct);
		
		verify(centerMapper, times(1)).findCenterWithCenterId(any());
		verify(centerMapper, times(1)).insertCenter(ct);
		
		assertThat(center.getCenterId()).isEqualTo(ct.getCenterId());
		assertThat(center.getCenterName()).isEqualTo(ct.getCenterName());
		assertThat(center.getCenterAddress1()).isEqualTo(ct.getCenterAddress1());
	}
}
