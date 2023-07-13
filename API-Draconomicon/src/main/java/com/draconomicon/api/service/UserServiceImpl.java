package com.draconomicon.api.service;

import java.util.List;


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
	public User modifier(Long id_user, User user) {
		return userRepository.findById(id_user)
				.map(p-> {
					p.setUsername(user.getUsername());
					p.setMail(user.getMail());
					p.setPassword(user.getPassword());
					p.setAge(user.getAge());
					p.setIdGenre(user.getIdGenre());
					p.setAvatar(user.getAvatar());
					p.setIdRole(user.getIdRole());
					return userRepository.save(p); 			
				}).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public String supprimer(Long id_user) {
		userRepository.deleteById(id_user);
		return "User deleted";
	}

}
