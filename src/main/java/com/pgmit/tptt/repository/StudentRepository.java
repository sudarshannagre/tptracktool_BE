package com.pgmit.tptt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pgmit.tptt.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query(value = "SELECT * FROM student where (email=?1 or mobile=?1) and paswword=?2", nativeQuery = true)
	Student authStudent(String emailORMobile, String password);

	@Query(value = "SELECT * FROM student where (email like ?1% or mobile like ?1% or name like ?1% or technology like ?1% or address like ?1% or bacth_name like ?1%)", nativeQuery = true)
	List<Student> search(String search);
}
