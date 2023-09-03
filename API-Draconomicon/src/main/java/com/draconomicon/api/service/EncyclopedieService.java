package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface EncyclopedieService {
	Encyclopedie creer(Encyclopedie encyclopedie);
	
	List<Encyclopedie> lire();
	
	Encyclopedie modifier(Long id_encyclopedie, Encyclopedie encyclopedie);
	
	String supprimer(Long id_encyclopedie);
}