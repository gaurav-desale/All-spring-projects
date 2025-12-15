package com.Project.Library_Management_System.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Library_Management_System.Entity.BookEntity;
import com.Project.Library_Management_System.Repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookRepository bookRepo;
	
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@PostMapping
	public BookEntity addBook(@RequestBody BookEntity book) {
		return bookRepo.save(book);
	}
	
	@GetMapping
	public List<BookEntity>getAllBooks(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public BookEntity getBookById(@PathVariable Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public BookEntity updateBook(@PathVariable Long id , @RequestBody BookEntity book) {
		book.setId(id);
		return bookRepo.save(book);
	}

}
