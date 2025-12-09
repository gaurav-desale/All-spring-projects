package com.Blog_Managment_System.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_Managment_System.Entity.commentEntity;
import com.Blog_Managment_System.Entity.Repository.CommentRepository;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    public commentEntity createComment(@RequestBody commentEntity comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/{id}")
    public commentEntity getCommentById(@PathVariable Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<commentEntity> getAllComments() {
        return commentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
