package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmit.tptt.entity.Batch;
import com.pgmit.tptt.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchServiceIfc{
	
	@Autowired
	private BatchRepository batchRepository;

	@Override
	public List<Batch> listOfBatch() {
		return (List<Batch>)batchRepository.findAll();
	}

}
