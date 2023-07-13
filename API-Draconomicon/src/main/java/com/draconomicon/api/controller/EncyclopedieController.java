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

import com.draconomicon.api.model.Encyclopedie;
import com.draconomicon.api.service.EncyclopedieService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/encyclopedie")
@AllArgsConstructor

public class EncyclopedieController {
	private EncyclopedieService encyclopedieService;
	
	@PostMapping()
	public Encyclopedie create(@RequestBody Encyclopedie encyclopedie) {
		return encyclopedieService.creer(encyclopedie);
	}
	
	@GetMapping()
	public List<Encyclopedie> read(){
		return encyclopedieService.lire();
	}
	
	@PutMapping("/{id_encyclopedie}")
	public Encyclopedie update(@PathVariable Long id_encyclopedie, @RequestBody Encyclopedie encyclopedie){
		return encyclopedieService.modifier(id_encyclopedie, encyclopedie);	
	}
	
	@DeleteMapping("/{id_encyclopedie}")
	public String delete(@PathVariable Long id_encyclopedie){
		return encyclopedieService.supprimer(id_encyclopedie);
	}
}