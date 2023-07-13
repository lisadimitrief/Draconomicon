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

import com.draconomicon.api.model.Blog;
import com.draconomicon.api.service.BlogService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/blog")
@AllArgsConstructor

public class BlogController {
	private BlogService blogService;
	
	@PostMapping()
	public Blog create(@RequestBody Blog blog) {
		return blogService.creer(blog);
	}
	
	@GetMapping()
	public List<Blog> read(){
		return blogService.lire();
	}
	
	@PutMapping("/{id_blog}")
	public Blog update(@PathVariable Long id_blog, @RequestBody Blog blog){
		return blogService.modifier(id_blog, blog);	
	}
	
	@DeleteMapping("/{id_blog}")
	public String delete(@PathVariable Long id_blog){
		return blogService.supprimer(id_blog);
	}
}