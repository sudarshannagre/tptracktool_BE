package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.pgmit.tptt.model.Auth;
import com.pgmit.tptt.model.Staff;
import com.pgmit.tptt.model.User;

@Configuration
public interface StaffServiceIfc {

	String saveStaff(Staff staff);

	String deleteStaff(String id);

	List<com.pgmit.tptt.entity.Staff> listOfStaff();

	User staffAuth(Auth auth);
	
}
