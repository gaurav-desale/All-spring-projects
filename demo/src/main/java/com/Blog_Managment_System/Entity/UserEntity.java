package com.Blog_Managment_System.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String username;
	
	private String email;
	
	@OneToMany(mappedBy = "author" , cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonIgnore
	
	private List<BlogEntity> blogs = new ArrayList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<BlogEntity> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogEntity> blogs) {
		this.blogs = blogs;
	}
	
	

}
