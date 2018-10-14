package com.zen.hub.zenhub.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.hub.zenhub.dto.CustInfoDTO;
import com.zen.hub.zenhub.dto.ZenDTO;
import com.zen.hub.zenhub.model.CustomerInfo;
import com.zen.hub.zenhub.model.Zenmodel1;
import com.zen.hub.zenhub.services.Zen1service;
import com.zen.hub.zenhub.transformer.ModeToDTOTransformer;
import com.zen.hub.zenhub.transformer.Zenconverter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value=MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/v1/test")
public class Zen1Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Zen1Controller.class);

	@Autowired
	private ModeToDTOTransformer modeToDTOTransformer;
	
	@Autowired
	private Zen1service zen1service;
	
	@Autowired
	private Zenconverter zenconverter;
		
@ResponseBody
@RequestMapping(path="/{Zid}")
@ApiOperation("This is the first service")

public ZenDTO getResult(@PathVariable("Zid") Integer Zid) {
	Zenmodel1 tttm = new Zenmodel1();
	tttm.setId1(Zid);
	tttm.setSt1("Test");
	ZenDTO tdo = zenconverter.gettestDTO(tttm);
	return tdo;
}

@ResponseBody
@RequestMapping(path="/CustInfo/{custId}")
@ApiOperation("This is the first service")

public List<CustInfoDTO> getCustInfo(@PathVariable("custId") Integer custId) {

	LOGGER.info("To get info for {}\n", custId);
	
	List<CustomerInfo> cinfo = zen1service.selectCust(custId);

	return cinfo.stream().map(modeToDTOTransformer::toCustInfoDTO).collect(Collectors.toList());
}
}
