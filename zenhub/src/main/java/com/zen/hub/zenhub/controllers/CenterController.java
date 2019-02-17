package com.zen.hub.zenhub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.services.CenterService;
import com.zen.hub.zenhub.transformer.ModelToDTOTransformer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value=MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/v1/center")
public class CenterController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CenterController.class);

	@Autowired
	private ModelToDTOTransformer modeToDTOTransformer;
	
	@Autowired
	private CenterService centerService;
	
@RequestMapping(path="/{id}", method = RequestMethod.GET )
@ApiOperation("Center detail infromation")

public CenterDTO getCenter(@PathVariable("id") Integer id) {

	LOGGER.info("To get center info for {}\n", id);
	
	Center center = centerService.selectCenter(id);
	
	CenterDTO centerDTO = modeToDTOTransformer.toCenterDTO(center);
	
	LOGGER.info("The result for {} is {}\n", id, centerDTO.toString());

	return centerDTO;
}
}
