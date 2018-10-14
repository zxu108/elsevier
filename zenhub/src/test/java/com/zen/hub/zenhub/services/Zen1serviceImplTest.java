package com.zen.hub.zenhub.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import com.zen.hub.zenhub.model.Zenmodel1;
import com.zen.hub.zenhub.transformer.Zenconverter;

@RunWith(MockitoJUnitRunner.class)
public class Zen1serviceImplTest {

	@Mock
	private Zenconverter zztt;
	
@InjectMocks
private Zen1serviceImpl testee;
	
	@Test
	public void testGetMode1() {

//		when(zztt.gettestDTO(null)).thenReturn(0);
		
		Zenmodel1 zmodel = testee.getMode1(1, "Test String");
		
		assertThat(zmodel.getId1()).isEqualTo(1);
		
	}

}
