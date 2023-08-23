package com.draconomicon.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
}