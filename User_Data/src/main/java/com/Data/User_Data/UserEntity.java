package com.Data.User_Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class UserEntity {

	@Id
	private Long userId;
	private String name;
	private double salary;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
	
}
