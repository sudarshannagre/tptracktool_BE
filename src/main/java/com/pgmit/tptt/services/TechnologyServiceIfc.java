package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.pgmit.tptt.entity.Technology;

@Configuration
public interface TechnologyServiceIfc {

	List<Technology> listOfTechnology();

}
