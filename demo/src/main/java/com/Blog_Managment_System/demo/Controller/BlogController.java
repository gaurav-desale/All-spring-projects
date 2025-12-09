package com.Blog_Managment_System.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_Managment_System.Entity.BlogEntity;
import com.Blog_Managment_System.Entity.Repository.BlogRepository;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	
	private final BlogRepository blogRepository;
	
	public BlogController(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	@PostMapping
	public BlogEntity createBlog(@RequestBody BlogEntity blog) {
		return blogRepository.save(blog);
	}
	
	@GetMapping
	public List<BlogEntity> getAllBlogs(){
		return blogRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<BlogEntity> getBlogById(@PathVariable Long id){
		return blogRepository.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBlog(@PathVariable Long id) {
		blogRepository.deleteById(id);
	}
}
