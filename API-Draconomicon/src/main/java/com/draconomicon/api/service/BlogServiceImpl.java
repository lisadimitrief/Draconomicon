package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Blog;
import com.draconomicon.api.repository.BlogRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService{

	private BlogRepository blogRepository;
	
	@Override
	public Blog creer(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> lire() {
		return blogRepository.findAll();
	}

	@Override
	public Blog modifier(Long id_blog, Blog blog) {
		return blogRepository.findById(id_blog)
				.map(b-> {
					b.setTitre(blog.getTitre());
					b.setContenu(blog.getContenu());
					b.setImage(blog.getImage());
					b.setIdUser(blog.getIdUser());
					return blogRepository.save(b); 			
				}).orElseThrow(() -> new RuntimeException("Blog not found"));
	}

	@Override
	public String supprimer(Long id_blog) {
		blogRepository.deleteById(id_blog);
		return "Blog deleted";
	}

}
