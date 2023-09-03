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

import com.draconomicon.api.model.Media;
import com.draconomicon.api.service.MediaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/media")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class MediaController {
	private MediaService mediaService;
	
	@PostMapping()
	public Media create(@RequestBody Media media) {
		return mediaService.creer(media);
	}
	
	@GetMapping()
	public List<Media> read(){
		return mediaService.lire();
	}
	
	@PutMapping("/{id_media}")
	public Media update(@PathVariable Long id_media, @RequestBody Media media){
		return mediaService.modifier(id_media, media);	
	}
	
	@DeleteMapping("/{id_media}")
	public String delete(@PathVariable Long id_media){
		return mediaService.supprimer(id_media);
	}
}