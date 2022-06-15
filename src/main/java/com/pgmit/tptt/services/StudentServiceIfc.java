package com.pgmit.tptt.services;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.pgmit.tptt.entity.Student;

@Configuration
public interface StudentServiceIfc {

	String saveStudent(com.pgmit.tptt.model.Student student);

	String deleteStudent(String id);

	List<Student> listOfStudent();

	String authStudent(String emailORMobile, String password);

	List<Student> search(String search);
}
