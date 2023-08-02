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

import com.draconomicon.api.model.Commentaire;
import com.draconomicon.api.service.CommentaireService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/commentaire")
@AllArgsConstructor

public class CommentaireController {
	private CommentaireService commentaireService;
	
	@PostMapping()
	public Commentaire create(@RequestBody Commentaire commentaire) {
		return commentaireService.creer(commentaire);
	}
	
	@GetMapping()
	public List<Commentaire> read(){
		return commentaireService.lire();
	}
	
	@PutMapping("/{id_commentaire}")
	public Commentaire update(@PathVariable Long id_commentaire, @RequestBody Commentaire commentaire){
		return commentaireService.modifier(id_commentaire, commentaire);	
	}
	
	@DeleteMapping("/{id_commentaire}")
	public String delete(@PathVariable Long id_commentaire){
		return commentaireService.supprimer(id_commentaire);
	}
}