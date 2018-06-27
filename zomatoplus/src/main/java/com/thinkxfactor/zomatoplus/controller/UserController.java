package com.thinkxfactor.zomatoplus.controller;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.zomatoplus.models.User;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		User persistedUser=userRepository.save(user);
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		
		List<User> users=userRepository.findAll();
		return users;
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		
		User loggedUser=userRepository.findByNameAndPassword(user.getName(), user.getPassword());
		return loggedUser;
	}
	/*@GetMapping("/create")
	public User create(@RequestParam(value="username") String username,@RequestParam(value="password")String password) 
	{
			User user1=new User(username,password);
			return user1;
		}

	@PostMapping("/create")
	public User create(@RequestBody User user) 
	{
		System.out.println(user.toString());
			return user;
		}*/

	

}
