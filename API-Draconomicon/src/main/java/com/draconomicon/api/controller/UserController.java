package com.draconomicon.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.draconomicon.api.model.AuthenticationResponse;
import com.draconomicon.api.model.User;
import com.draconomicon.api.repository.UserRepository;
import com.draconomicon.api.service.JwtService;
import com.draconomicon.api.service.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user")
	public Iterable<User> getUser() { 
		return userService.getUser();
	}
	@GetMapping("/usercurrent")
	public User currentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}

	@GetMapping("/user/{id}")
	public User getProfil(@PathVariable("id") final Long id){
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	@PatchMapping("/user/{id}")
	public com.draconomicon.api.model.AuthenticationResponse updateProfil(@PathVariable("id") final Long id, @RequestBody User user) {
		Optional<User> e = userService.getUser(id);
		if(e.isPresent()) {
			User currentUser = e.get();
			userService.updateUser(currentUser, user);
			var jwtToken = jwtService.generateToken(currentUser);
			return AuthenticationResponse.builder()
					.token(jwtToken)
					.build();
		} else {
			return null;
		}
	}

	// @Transactional
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
	}
}