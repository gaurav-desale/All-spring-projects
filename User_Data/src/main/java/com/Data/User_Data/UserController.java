package com.Data.User_Data;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Users")
public class UserController {
	
	private final UserRepository userRepository; 

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping
	public String createUser(@RequestBody UserEntity user) {
		userRepository.save(user);
		return "Data inserted successfully!";
	}
	
	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{userId}")
	public Optional<UserEntity> getUserById(@PathVariable Long userId) {
		return userRepository.findById(userId);
	}
	
	@PutMapping("/{userId}")
	public String updateUser(@RequestBody UserEntity user, @PathVariable Long userId) {
		user.setUserId(userId);
		userRepository.save(user);
		return "Data updated successfully!";
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		userRepository.deleteById(userId);
		return "Data deleted successfully!";
	}
}