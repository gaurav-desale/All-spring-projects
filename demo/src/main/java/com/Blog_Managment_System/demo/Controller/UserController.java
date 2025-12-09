package com.Blog_Managment_System.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_Managment_System.Entity.UserEntity;
import com.Blog_Managment_System.Entity.Repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserRepository Userrepository;
	
	public UserController(UserRepository userRepository) {
		this.Userrepository = userRepository;
	}
	
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
		return Userrepository.save(user);
	}
	
	@GetMapping
	public List<UserEntity> getAllUsers(){
		return Userrepository.findAll();	
	}
	
	@GetMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		Userrepository.deleteById(id);
		return "data deleted successfully";
	}
}
