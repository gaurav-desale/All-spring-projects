package com.Project.Library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Library_Management_System.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity , Long>{

}
