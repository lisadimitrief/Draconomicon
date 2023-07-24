package com.draconomicon.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draconomicon.api.model.User;
import com.draconomicon.api.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin


public class UserController {
	private UserService userService;
	
	@PostMapping()
	public User create(@RequestBody User user) {
		return userService.creer(user);
	}
	
	@GetMapping()
	public List<User> read(){
		return userService.lire();
	}
	
	@GetMapping("/{id_user}")
	public Optional<User> read(@PathVariable long id_user){
		return userService.userLecture(id_user);	
	}
	@PutMapping("/{id_user}")
	public User update(@PathVariable Long id_user, @RequestBody User user){
		return userService.modifier(id_user, user);	
	}
	
	@DeleteMapping("/{id_user}")
	public String delete(@PathVariable Long id_user){
		return userService.supprimer(id_user);
	}
}