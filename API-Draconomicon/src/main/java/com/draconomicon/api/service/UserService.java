package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;
import java.util.Optional;

public interface UserService {
	User creer(User user);
	
	List<User> lire();

	Optional<User> userLecture(long id_user);
	
	User modifier(Long id_user, User user);
	
	String supprimer(Long id_user);
}