package com.draconomicon.api.service;

import java.util.List;
import java.util.Optional;

import com.draconomicon.api.model.User;
import com.draconomicon.api.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Override
	public User creer(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> lire() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> userLecture(long id_user) {
		return userRepository.findById(id_user);
	}
	
	@Override
	public User modifier(Long id_user, User user) {
		return userRepository.findById(id_user)
				.map(u-> {
					u.setUsername(user.getUsername());
					u.setMail(user.getMail());
					u.setPassword(user.getPassword());
					u.setAge(user.getAge());
					u.setIdGenre(user.getIdGenre());
					u.setAvatar(user.getAvatar());
					u.setIdRole(user.getIdRole());
					return userRepository.save(u); 			
				}).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public String supprimer(Long id_user) {
		userRepository.deleteById(id_user);
		return "User deleted";
	}

}
