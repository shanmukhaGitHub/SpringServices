package com.shan.spring.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shan.spring.ms.exception.GeneratePhoneBusinessExpection;
import com.shan.spring.ms.model.AlphaNumericPojo;
import com.shan.spring.ms.service.GeneratePhoneService;


@RestController
public class GeneratePhoneNumbersController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GeneratePhoneNumbersController.class);

	
	@Autowired
	GeneratePhoneService service;
	
	@GetMapping("/generatePhoneCombinations/{phoneNumber}")
	public ResponseEntity <AlphaNumericPojo> getPhoneCombinations(@PathVariable String phoneNumber){
		
		try {
			log.info("call service to generate numbers");
			 ResponseEntity<AlphaNumericPojo> responseEntity = new ResponseEntity<>( service.getPhoneCombinationList(phoneNumber),HttpStatus.OK);
			 return responseEntity;
		}catch (GeneratePhoneBusinessExpection e) {
			log.info("Exception occured caused by {}"+e.getCause());
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
		}

}
