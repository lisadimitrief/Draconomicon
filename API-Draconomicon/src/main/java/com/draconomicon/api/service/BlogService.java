package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface BlogService {
	Blog creer(Blog blog);
	
	List<Blog> lire();
	
	Blog modifier(Long id_blog, Blog blog);
	
	String supprimer(Long id_blog);
}