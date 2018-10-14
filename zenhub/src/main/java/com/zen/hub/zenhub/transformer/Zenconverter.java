package com.zen.hub.zenhub.transformer;

import org.springframework.stereotype.Component;

import com.zen.hub.zenhub.dto.ZenDTO;
import com.zen.hub.zenhub.model.Zenmodel1;

@Component
public class Zenconverter {

	public ZenDTO gettestDTO(Zenmodel1 tm) {
		ZenDTO td = new ZenDTO();
		td.setId1(tm.getId1());
		td.setSt1(tm.getSt1());	

		return td;
}
}
