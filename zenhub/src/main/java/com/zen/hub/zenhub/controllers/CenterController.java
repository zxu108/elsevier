package com.zen.hub.zenhub.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zen.hub.zenhub.controllers.validators.ValidationException;
import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.dto.CenterEnrollDTO;
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

@PostMapping(path="/File")
@ApiOperation("Center creation")
public CenterDTO createCenter(@RequestParam("file") MultipartFile file, @RequestParam(value = "param1", required = false) String param1, @RequestParam(value = "CenterData", required = false) String CenterData) {

	CenterDTO ctDto = new CenterDTO();
	
	LOGGER.info("To upload center log info for");
	LOGGER.info("Test data is: {}", param1 );
	
	try {
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	
	byte[] bytes = file.getBytes();
	
	LOGGER.info("Filename is {}\n", fileName);
	LOGGER.info("CenterData is {}\n", CenterData);
	LOGGER.info("File size is {}\n", bytes.length);
	
	Gson gson = new Gson(); // Or use new GsonBuilder().create();
	CenterEnrollDTO target2 = gson.fromJson(CenterData, CenterEnrollDTO.class); // deserializes json into target2
	
	LOGGER.info("Field is {}\n", target2.getCenterAddress1());
	
	} catch (Exception e) {
		new ValidationException("You failed to upload " + file.getName() + ": " + e.getMessage());
    }
	 


			
//	Center center = centerService.selectCenter(id);
//	
//	CenterDTO centerDTO = modeToDTOTransformer.toCenterDTO(center);
//	
//	LOGGER.info("The result for {} is {}\n", id, centerDTO.toString());

	return ctDto;
}
}


//@RequestMapping(value = "/uploadAndSendEmail", method = RequestMethod.POST, consumes= "multipart/form-data")    
//public ResponseEntity<String> uploadAndSendEmail(@RequestParam("fileArray") MultipartFile[] fileArray, 
//        @RequestParam(value = "param1", required = false) String param1,
//        @RequestParam(value = "param2", required = false) String param2) {
//        //do your logic
//        }

