package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Genre;
import com.draconomicon.api.repository.GenreRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService{

	private GenreRepository genreRepository;
	
	@Override
	public Genre creer(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public List<Genre> lire() {
		return genreRepository.findAll();
	}

	@Override
	public Genre modifier(Long id_genre, Genre genre) {
		return genreRepository.findById(id_genre)
				.map(g-> {
					g.setGenre(genre.getGenre());
					return genreRepository.save(g); 			
				}).orElseThrow(() -> new RuntimeException("genre not found"));
	}

	@Override
	public String supprimer(Long id_genre) {
		genreRepository.deleteById(id_genre);
		return "genre deleted";
	}

}
