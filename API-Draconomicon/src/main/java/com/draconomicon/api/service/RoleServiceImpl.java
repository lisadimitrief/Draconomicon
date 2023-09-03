package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Role;
import com.draconomicon.api.repository.RoleRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	@Override
	public Role creer(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> lire() {
		return roleRepository.findAll();
	}

	@Override
	public Role modifier(Long id_role, Role role) {
		return roleRepository.findById(id_role)
				.map(r-> {
					r.setRole(role.getRole());
					return roleRepository.save(r); 			
				}).orElseThrow(() -> new RuntimeException("role not found"));
	}

	@Override
	public String supprimer(Long id_role) {
		roleRepository.deleteById(id_role);
		return "role deleted";
	}

}
