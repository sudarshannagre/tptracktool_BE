package com.pgmit.tptt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgmit.tptt.services.TechnologyServiceIfc;

@RestController
@CrossOrigin
public class TechnologyController {
	
	@Autowired
	private TechnologyServiceIfc technologyServiceIfc;
	
	@GetMapping("/v1/technology")
	public ResponseEntity<?> listOfTechnology(){
		return ResponseEntity.ok(technologyServiceIfc.listOfTechnology());
	}

}
