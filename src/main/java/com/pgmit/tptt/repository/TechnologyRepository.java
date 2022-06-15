package com.pgmit.tptt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pgmit.tptt.entity.Technology;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Integer>{

}
