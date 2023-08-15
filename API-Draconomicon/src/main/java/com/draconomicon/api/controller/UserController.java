package com.draconomicon.api.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.draconomicon.api.model.User;
import com.draconomicon.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	public User updateProfil(@PathVariable("id") final Long id, @RequestBody User user) {
		//profil.setPassword(passwordEncoder.encode(profil.getPassword()));
		Optional<User> e = userService.getUser(id);
		if(e.isPresent()) {
			User currentUser = e.get();
			
			String username = user.getUsername();
			if(username != null) {
				currentUser.setUsername(username);
			}
			String mail = user.getMail();
			if(mail != null) {
				currentUser.setMail(mail);;
			}

			String password = user.getPassword();
			if(password != null) {
				currentUser.setPassword(password);
			}
			int age = user.getAge();
			if(age != 0) {
				currentUser.setAge(age);
			}
			int idGenre = user.getIdGenre();
			if(age != 0) {
				currentUser.setIdGenre(idGenre);
			}
			int idRole = user.getIdRole();
			if(idRole != 0) {
				currentUser.setIdRole(idRole);
			}
			String avatar = user.getAvatar();
			if(avatar != null) {
				currentUser.setAvatar(avatar);
			}
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}
	// @PatchMapping("/user/{id}")
	// public User patchUser(@PathVariable("id") final Long id, @RequestBody User user){
	// 	//profil.setPassword(passwordEncoder.encode(profil.getPassword()));		
	// 	Optional<User> e = userService.getUser(id);
	// 	if(e.isPresent()) {
	// 		User currentUser = e.get();
			
	// 		String username = user.getUsername();
	// 		String mail = user.getMail();
	// 		String password = user.getPassword();
	// 		int age = user.getAge();
	// 		int idRole = user.getIdRole();
	// 		String avatar = user.getAvatar();
	// 		int idGenre = user.getIdGenre();
	// 		if(username != null && mail != null && password != null && age != 0 && idRole != 0 && avatar != null) {
	// 			currentUser.setUsername(username);
	// 			currentUser.setMail(mail);
	// 			currentUser.setAvatar(avatar);
	// 			currentUser.setPassword(password);
	// 			currentUser.setAge(age);
	// 			currentUser.setIdGenre(idGenre);
	// 			userService.saveUser(currentUser);
	// 		return currentUser;
	// 		} else {
	// 			return null;
	// 		}
	// 	} else {
	// 		return null;
	// 	}
	// }
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
	}
}