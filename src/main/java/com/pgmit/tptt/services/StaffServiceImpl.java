package com.pgmit.tptt.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmit.tptt.constant.APIConstant;
import com.pgmit.tptt.model.Auth;
import com.pgmit.tptt.model.Staff;
import com.pgmit.tptt.model.User;
import com.pgmit.tptt.repository.StaffRepository;
import com.pgmit.tptt.util.AutoGenerate;

@Service
public class StaffServiceImpl implements StaffServiceIfc {

	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private AutoGenerate autoGenerate;

	@Override
	public String saveStaff(Staff staff) {

		com.pgmit.tptt.entity.Staff entityStaff = new com.pgmit.tptt.entity.Staff();
		entityStaff.setName(staff.getName());
		entityStaff.setEmail(staff.getEmail());
		entityStaff.setMobile(staff.getMobile());
		entityStaff.setRole(staff.getRole());
		entityStaff.setJoiningDate(new Date());
		entityStaff.setPassword(autoGenerate.encodePassword(staff.getPassword()));

		entityStaff = staffRepository.save(entityStaff);
		return "Staff Id : " + entityStaff.getId();
	}

	@Override
	public String deleteStaff(String id) {
		try {
			com.pgmit.tptt.entity.Staff staff = new com.pgmit.tptt.entity.Staff();
			staff.setId(Integer.parseInt(id));

			staffRepository.delete(staff);

			return APIConstant.DELETE_SUCCESS;
		} catch (Exception e) {
			return APIConstant.DELETE_FAIL;
		}
	}

	@Override
	public List<com.pgmit.tptt.entity.Staff> listOfStaff() {
		return (List<com.pgmit.tptt.entity.Staff>) staffRepository.findAll();
	}

	@Override
	public User staffAuth(Auth auth) {
		com.pgmit.tptt.entity.Staff staff = staffRepository.authStaff(auth.getEmailORMobile(), autoGenerate.encodePassword(auth.getPassword()));
		
		if(null != staff) {
			User user = new User();
			user.setName(staff.getName());
			user.setEmail(staff.getEmail());
			user.setRole(staff.getRole());
			return user;
		}
		
		return null;
	}
}
