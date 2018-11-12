package com.zen.hub.zenhub.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.zen.hub.zenhub.mappers.CenterMapper;
import com.zen.hub.zenhub.model.Center;

@RunWith(MockitoJUnitRunner.class)
public class CenterServiceImplTest {

	@Mock
	private CenterMapper centerMapper;
	
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

}
