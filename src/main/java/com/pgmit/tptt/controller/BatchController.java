package com.pgmit.tptt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgmit.tptt.entity.Batch;
import com.pgmit.tptt.services.BatchServiceIfc;

@RestController
@CrossOrigin
public class BatchController {
	
	@Autowired
	private BatchServiceIfc batchServiceIfc;
	
	@GetMapping("/v1/batch")
	public ResponseEntity<?> listOfBatch(){
		List<Batch> list =  batchServiceIfc.listOfBatch();
		return ResponseEntity.ok(list);
	}

}
