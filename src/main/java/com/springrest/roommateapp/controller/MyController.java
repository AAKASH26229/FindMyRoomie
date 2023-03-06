package com.springrest.roommateapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.services.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home";
	}

	// get the list of users
	@GetMapping("/users")
	public List<User> getUsers()
	{
		 return this.userService.getUsers();
	}
	
	// get single user through id
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId)
	{
		return this.userService.getUser(Long.parseLong(userId));
	}
	
	
	// add new user
	@PostMapping("/users")
	public User addUser(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}
	
	// update existing user
	@PutMapping("/users")
	public User updateUser(@RequestBody User user)
	{
		return this.userService.updateUser(user);
	}
	
	
	// deleting the existing user
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
		try {
			this.userService.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
