package com.zen.hub.zenhub.controllers;

import java.util.List;

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
import com.zen.hub.zenhub.controllers.validators.CenterValidator;
import com.zen.hub.zenhub.controllers.validators.ValidationException;
import com.zen.hub.zenhub.dto.CenterDTO;
import com.zen.hub.zenhub.dto.CenterEnrollDTO;
import com.zen.hub.zenhub.model.Center;
import com.zen.hub.zenhub.services.CenterService;
import com.zen.hub.zenhub.transformer.DTOToModelTransformer;
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
	private DTOToModelTransformer dtoToModelTransformer;
	
	@Autowired
	private CenterValidator centerValidator;
	
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

@RequestMapping(path="/Log/{centerId}", method = RequestMethod.GET )
@ApiOperation("Center detail infromation")
public byte[] getCenterLogo(@PathVariable("centerId") String centerId) {

	LOGGER.info("To get center info for {}\n", centerId);
	
	List<Center> centers = centerService.findCenterWithCenterId(centerId);
	
	CenterDTO centerDTO = modeToDTOTransformer.toCenterDTO(centers.get(0));
	
	LOGGER.info("The result for {} is name {} log is {}\n", centerId, centerDTO.getCenterName(), centerDTO.getCenterLogo());

	return centerDTO.getCenterLogo();
}

@PostMapping(path="/File", produces=MediaType.APPLICATION_JSON_VALUE)
@ApiOperation("Center creation")
public CenterDTO createCenter(@RequestParam("file") MultipartFile[] file, @RequestParam(value = "param1", required = false) String param1, @RequestParam(value = "CenterData", required = true) String CenterData) {
	String fileName;
	byte[] bytes;
	CenterDTO ctDto = new CenterDTO();
	
	LOGGER.info("To upload center log info for");
	LOGGER.info("Test data is: {}", param1 );
	
	try {
	 fileName = StringUtils.cleanPath(file[0].getOriginalFilename());
	
	bytes = file[0].getBytes();
	
	LOGGER.info("Filename is {}\n", fileName);
	LOGGER.info("CenterData is {}\n", CenterData);
	LOGGER.info("File size is {}\n", bytes.length);
	} catch (Exception e) {
		throw new ValidationException("You failed to upload tset : " + e.getMessage());
	}	
	Gson gson = new Gson(); // Or use new GsonBuilder().create();
	CenterEnrollDTO centerEnrollDTO = gson.fromJson(CenterData, CenterEnrollDTO.class); // deserializes json into target2
	
	LOGGER.info("Field is {} and {} \n", centerEnrollDTO.getCenterAddress1(), centerEnrollDTO.getCenterCloseStartDate());
	
	centerValidator.validateEnrollInsert(centerEnrollDTO);
	
	Center center = dtoToModelTransformer.toCenterEnroll(centerEnrollDTO);
	
	center.setCenterLogo(bytes);
	center.setId(10);
	
	Center centerResult = centerService.insertCenter(center);
	
	ctDto = modeToDTOTransformer.toCenterDTO(centerResult);	
	
	LOGGER.info("The result for {} is {}\n", ctDto.getId(), ctDto.toString());

	return ctDto;
}
}


//@RequestMapping(value = "/uploadAndSendEmail", method = RequestMethod.POST, consumes= "multipart/form-data")    
//public ResponseEntity<String> uploadAndSendEmail(@RequestParam("fileArray") MultipartFile[] fileArray, 
//        @RequestParam(value = "param1", required = false) String param1,
//        @RequestParam(value = "param2", required = false) String param2) {
//        //do your logic
//        }

