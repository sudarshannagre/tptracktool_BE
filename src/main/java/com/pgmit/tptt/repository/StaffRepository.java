package com.pgmit.tptt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pgmit.tptt.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
	
	@Query(value = "SELECT * FROM staff where (email=?1 or mobile=?1) and password=?2", nativeQuery = true)
	Staff authStaff(String emailORMobile, String password);
}
