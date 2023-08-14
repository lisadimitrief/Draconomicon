package com.draconomicon.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.draconomicon.api.model.Role;
import com.draconomicon.api.service.RoleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class RoleController {
	private RoleService roleService;
	
	@PostMapping()
	public Role create(@RequestBody Role role) {
		return roleService.creer(role);
	}
	
	@GetMapping()
	public List<Role> read(){
		return roleService.lire();
	}
	
	@PutMapping("/{id_role}")
	public Role update(@PathVariable Long id_role, @RequestBody Role role){
		return roleService.modifier(id_role, role);	
	}
	
	@DeleteMapping("/{id_role}")
	public String delete(@PathVariable Long id_role){
		return roleService.supprimer(id_role);
	}
}