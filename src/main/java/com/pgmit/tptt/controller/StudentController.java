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
import com.pgmit.tptt.model.Student;
import com.pgmit.tptt.services.StudentServiceIfc;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentServiceIfc studentServiceIfc;
	
	@PostMapping("/v1/student")
	public ResponseEntity<?> saveStudent(@RequestBody Student st){
		return ResponseEntity.ok(studentServiceIfc.saveStudent(st));
	}
	
	@GetMapping("/v1/student")
	public ResponseEntity<?> listOfStudent(){
		return ResponseEntity.ok(studentServiceIfc.listOfStudent());
	}
	
	@GetMapping("/v1/student/search")
	public ResponseEntity<?> search(@RequestParam String search){
		return ResponseEntity.ok(studentServiceIfc.search(search));
	}
	
	@DeleteMapping("/v1/student")
	public ResponseEntity<?> deleteStudent(@RequestParam String id){
		return ResponseEntity.ok(studentServiceIfc.deleteStudent(id));
	}
	
	@PostMapping("/v1/student/auth")
	public ResponseEntity<?> authStudent(@RequestBody Auth auth){
		return ResponseEntity.ok(studentServiceIfc.authStudent(auth.getEmailORMobile(),auth.getPassword()));
	}
}
