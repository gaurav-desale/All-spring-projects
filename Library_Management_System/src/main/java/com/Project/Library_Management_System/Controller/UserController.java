package com.Project.Library_Management_System.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Library_Management_System.Entity.BookEntity;
import com.Project.Library_Management_System.Entity.UserEntity;
import com.Project.Library_Management_System.Repository.BookRepository;
import com.Project.Library_Management_System.Repository.UserRepository;

@RestController
@RequestMapping("/api/users") 
public class UserController {
	
	private final UserRepository userRepo;
	private final BookRepository bookRepo;
	
	public UserController(UserRepository userRepo, BookRepository bookRepo) {
		this.userRepo = userRepo;
		this.bookRepo = bookRepo;
	}
	
	@PostMapping
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userRepo.save(user);
	}
	
	@GetMapping
	public List<UserEntity> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userRepo.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		user.setId(id);
		return userRepo.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepo.deleteById(id);
	}
	
	@PostMapping("/{userId}/{borrow}/{bookId}")
	public String borrowBook(@PathVariable Long userId, @PathVariable Long bookId) {
		UserEntity user = userRepo.findById(userId).orElseThrow(); 
		BookEntity book = bookRepo.findById(bookId).orElseThrow(); 
		
		if (!book.isAvailable()) {
			return "Book not available!";
		}
		
		book.setAvailable(false); 
		user.getBorrowedBooks().add(book);
		
		bookRepo.save(book);
		userRepo.save(user);
		
		return "Book borrowed successfully!";
	}
}
