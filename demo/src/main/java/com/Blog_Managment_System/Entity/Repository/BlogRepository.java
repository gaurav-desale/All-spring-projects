package com.Blog_Managment_System.Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_Managment_System.Entity.BlogEntity;

public interface BlogRepository extends JpaRepository<BlogEntity , Long> {

}
