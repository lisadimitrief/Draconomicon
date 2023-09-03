package com.draconomicon.api.service;

import com.draconomicon.api.model.*;
import java.util.List;

public interface MediaService {
	Media creer(Media media);
	
	List<Media> lire();
	
	Media modifier(Long id_media, Media media);
	
	String supprimer(Long id_media);
}