package com.Blog_Managment_System.Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_Managment_System.Entity.commentEntity;

public interface CommentRepository extends JpaRepository<commentEntity , Long> {

}
