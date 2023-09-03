package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface GenreService {
	Genre creer(Genre genre);
	
	List<Genre> lire();
	
	Genre modifier(Long id_genre, Genre genre);
	
	String supprimer(Long id_genre);
}