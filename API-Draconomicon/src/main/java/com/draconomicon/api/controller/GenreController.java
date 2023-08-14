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

import com.draconomicon.api.model.Genre;
import com.draconomicon.api.service.GenreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/genre")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class GenreController {
	private GenreService genreService;
	
	@PostMapping()
	public Genre create(@RequestBody Genre genre) {
		return genreService.creer(genre);
	}
	
	@GetMapping()
	public List<Genre> read(){
		return genreService.lire();
	}
	
	@PutMapping("/{id_genre}")
	public Genre update(@PathVariable Long id_genre, @RequestBody Genre genre){
		return genreService.modifier(id_genre, genre);	
	}
	
	@DeleteMapping("/{id_genre}")
	public String delete(@PathVariable Long id_genre){
		return genreService.supprimer(id_genre);
	}
}