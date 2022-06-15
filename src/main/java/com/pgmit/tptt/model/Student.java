package com.pgmit.tptt.model;

import javax.persistence.Column;

public class Student {

	private String name;
	
	private String mobile;
	
	private String email;
	
	private String address;
	
	private String technology;
	
	private String bacthName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getBacthName() {
		return bacthName;
	}

	public void setBacthName(String bacthName) {
		this.bacthName = bacthName;
	}
	
}
