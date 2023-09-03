package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Commentaire;
import com.draconomicon.api.repository.CommentaireRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentaireServiceImpl implements CommentaireService{

	private CommentaireRepository commentaireRepository;
	
	@Override
	public Commentaire creer(Commentaire commentaire) {
		return commentaireRepository.save(commentaire);
	}

	@Override
	public List<Commentaire> lire() {
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire modifier(Long id_commentaire, Commentaire commentaire) {
		return commentaireRepository.findById(id_commentaire)
				.map(c-> {
					c.setComment(commentaire.getComment());
					c.setIdUser(commentaire.getIdUser());
					c.setIdBlog(commentaire.getIdBlog());
					return commentaireRepository.save(c); 			
				}).orElseThrow(() -> new RuntimeException("Comment not found"));
	}

	@Override
	public String supprimer(Long id_commentaire) {
		commentaireRepository.deleteById(id_commentaire);
		return "comment deleted";
	}

}
