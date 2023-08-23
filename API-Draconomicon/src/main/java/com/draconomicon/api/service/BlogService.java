package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface BlogService {
	Blog creer(BlogRequest request);
	
	List<Blog> rechercher(String username);
	List<Blog> lire();
	
	Blog modifier(Long id_blog, Blog blog);
	
	String supprimer(Long id_blog);
	// String supprimerTout(Long id_user);

	BlogResponse response(Blog b);
	List<BlogResponse> responses(List<Blog> blogs);
}