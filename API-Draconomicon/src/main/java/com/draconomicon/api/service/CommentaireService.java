package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface CommentaireService {
	Commentaire creer(Commentaire commentaire);
	
	List<Commentaire> lire();
	
	Commentaire modifier(Long id_commentaire, Commentaire commentaire);
	
	String supprimer(Long id_commentaire);
}