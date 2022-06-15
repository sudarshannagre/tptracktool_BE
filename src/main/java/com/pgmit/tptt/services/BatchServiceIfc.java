package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.pgmit.tptt.entity.Batch;

@Configuration
public interface BatchServiceIfc {

	List<Batch> listOfBatch();

}
