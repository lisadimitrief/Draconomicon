package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface UserService {
	User creer(User user);
	
	List<User> lire();
	
	User modifier(Long id_user, User user);
	
	String supprimer(Long id_user);
}