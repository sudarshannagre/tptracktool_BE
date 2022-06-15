package com.pgmit.tptt.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgmit.tptt.constant.APIConstant;
import com.pgmit.tptt.entity.Student;
import com.pgmit.tptt.model.Mail;
import com.pgmit.tptt.repository.StudentRepository;
import com.pgmit.tptt.util.AutoGenerate;

@Service
public class StudentServiceImpl implements StudentServiceIfc {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AutoGenerate autoGenerate;
	
	@Autowired
	private MailServiceIfc mailServiceIfc;

	@Override
	public String saveStudent(com.pgmit.tptt.model.Student student) {
		Student st = new Student();
		st.setName(student.getName());
		st.setEmail(student.getEmail());
		st.setMobile(student.getMobile());
		st.setAddress(student.getAddress());
		st.setBacthName(student.getBacthName());
		st.setTechnology(student.getTechnology());
		st.setJoiningDate(new Date());
		
		String pwd = autoGenerate.generatePassword(APIConstant.PASSWORD_LENGTH);
		System.out.println("password : "+pwd);
		st.setPaswword(autoGenerate.encodePassword(pwd));
		st = studentRepository.save(st);
		
		if(st.getId() > 0) {
			
			String body = "Hello "+student.getName()+",\nThis is your autogenarated password for login.\nPassword : "+pwd+"\n\n\nThanks,Sudarshan";
			
			Mail mail = new Mail();
			mail.setSubject(APIConstant.STUDENT_PWD_MAIL_SUBJECT);
			mail.setFrom(APIConstant.STUDENT_PWD_MAIL_FROM);
			mail.setTo(student.getEmail());
			mail.setBody(body);
			
			try {
				mailServiceIfc.sendMail(mail);
			}catch(Exception e) {
				studentRepository.delete(st);
				return APIConstant.STUDENT_REGISTRATION_FAIL;
			}
		}
		return APIConstant.STUDENT_REGISTRATION_SUCCESS;
	}

	@Override
	public String deleteStudent(String id) {
		try {
			Student st = new Student();
			st.setId(Integer.parseInt(id));

			studentRepository.delete(st);

			return APIConstant.DELETE_SUCCESS;
		} catch (Exception e) {
			return APIConstant.DELETE_FAIL;
		}
	}

	@Override
	public List<Student> listOfStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public String authStudent(String emailORMobile, String password) {
		String encPwd = autoGenerate.encodePassword(password);
		Student st = studentRepository.authStudent(emailORMobile, encPwd);
		return "userName : "+st.getName();
	}

	@Override
	public List<Student> search(String search) {
		
		return studentRepository.search(search);
	}

}
