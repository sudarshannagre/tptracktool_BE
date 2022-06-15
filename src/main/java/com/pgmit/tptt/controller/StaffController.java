package com.pgmit.tptt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgmit.tptt.model.Auth;
import com.pgmit.tptt.model.Staff;
import com.pgmit.tptt.model.User;
import com.pgmit.tptt.services.StaffServiceIfc;

@RestController
@CrossOrigin
public class StaffController {

	@Autowired
	private StaffServiceIfc staffServiceIfc;

	@PostMapping("/v1/staff")
	public ResponseEntity<String> saveStaff(@RequestBody Staff staff) {

		return ResponseEntity.ok(staffServiceIfc.saveStaff(staff));
	}

	@DeleteMapping("/v1/staff")
	public ResponseEntity<String> deleteStaff(@RequestParam String id) {

		return ResponseEntity.ok(staffServiceIfc.deleteStaff(id));
	}

	@GetMapping("/v1/staff")
	public ResponseEntity<?> listOfStaff() {

		return ResponseEntity.ok(staffServiceIfc.listOfStaff());
	}
	
	@PostMapping("/v1/staff/auth")
	public ResponseEntity<User> staffAuth(@RequestBody Auth auth) {

		return ResponseEntity.ok(staffServiceIfc.staffAuth(auth));
	}
}
