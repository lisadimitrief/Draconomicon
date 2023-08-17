package com.draconomicon.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.draconomicon.api.model.Blog;
import com.draconomicon.api.model.BlogRequest;
import com.draconomicon.api.model.BlogResponse;
import com.draconomicon.api.model.User;
import com.draconomicon.api.repository.BlogRepository;
import com.draconomicon.api.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService{

	private BlogRepository blogRepository;
	private UserRepository userRepository;
	
	@Override
	public Blog creer(BlogRequest request) {
		Blog blog = new Blog();
		blog.setTitre(request.getTitre());
		blog.setContenu(request.getContenu());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		blog.setIdUser(user.getIdUser());
		
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> rechercher(String username) {
		User myUser = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
		return blogRepository.findAllByIdUser(myUser.getIdUser());
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
					b.setIdUser(blog.getIdUser());
					return blogRepository.save(b); 			
				}).orElseThrow(() -> new RuntimeException("Blog not found"));
	}

	@Override
	public String supprimer(Long id_blog) {
		Blog blog = blogRepository.findById(id_blog).orElseThrow(() -> new RuntimeException("Blog not found"));
		User userCo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (blog.getIdUser()==userCo.getIdUser()) {
			blogRepository.deleteById(id_blog);
			return "Blog deleted";
		} else {
			return "Ce n'est pas TON POST";
		}
		
	}


	@Override
	public BlogResponse response(Blog b){
		User user = userRepository.findById(b.getIdUser()).orElseThrow();
		BlogResponse br = new BlogResponse(
			b.getIdBlog(),
			user.getAvatar(),
			user.getUsername(),
			b.getTitre(), 
			b.getContenu(),
			b.getDateBlog()
		);

		return br;
	}

	@Override
	public List<BlogResponse> responses(List<Blog> blogs){
		List<BlogResponse> blogResponses = new ArrayList();
		for (Blog blog : blogs) {
			blogResponses.add(response(blog));
		}
		Collections.sort(blogResponses, (b1, b2) -> b2.getDateBlog().compareTo(b1.getDateBlog()));
		return blogResponses;
	}
}
