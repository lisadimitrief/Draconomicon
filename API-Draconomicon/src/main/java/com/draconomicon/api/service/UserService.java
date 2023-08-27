package com.draconomicon.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.draconomicon.api.model.User;
import com.draconomicon.api.repository.BlogRepository;
import com.draconomicon.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
		@Autowired
	private PasswordEncoder passwordEncoder;

	public Optional<User> getUser(final Long id) {
		return userRepository.findById(id);
	}

	public Iterable<User> getUser() {
		return userRepository.findAll();
	}

	public void deleteUser(final Long id) {
		User userCo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (id == userCo.getIdUser()) {
			// blogRepository.deleteAllByIdUser(id);
			userRepository.deleteById(id);
		} else {
			throw new RuntimeException("C'est pas ton compte...");
		}

	}
	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	public User updateUser(User currentUser, User user) {			
		int age = user.getAge();
		if(age != 0) {
			currentUser.setAge(age);
		}
		String username = user.getUsername();
		if(username != null) {
			currentUser.setUsername(username);
		}
		String mail = user.getMail();
		if(mail != null) {
			currentUser.setMail(mail);
		}
		String password = user.getPassword();
		if(password != null && !password.isEmpty()) {
			currentUser.setPassword(passwordEncoder.encode(password));
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
		saveUser(currentUser);
		return currentUser;
	}
}