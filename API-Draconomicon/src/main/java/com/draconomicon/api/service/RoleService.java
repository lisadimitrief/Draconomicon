package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface RoleService {
	Role creer(Role role);
	
	List<Role> lire();
	
	Role modifier(Long id_role, Role role);
	
	String supprimer(Long id_role);
}