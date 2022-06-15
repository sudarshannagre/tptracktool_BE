package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmit.tptt.entity.Technology;
import com.pgmit.tptt.repository.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyServiceIfc{
	
	@Autowired
	private TechnologyRepository technologyRepository;

	@Override
	public List<Technology> listOfTechnology() {
		return (List<Technology>)technologyRepository.findAll();
	}

}
