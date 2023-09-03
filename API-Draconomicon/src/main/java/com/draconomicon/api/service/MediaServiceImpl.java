package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Media;
import com.draconomicon.api.repository.MediaRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MediaServiceImpl implements MediaService{

	private MediaRepository mediaRepository;
	
	@Override
	public Media creer(Media media) {
		return mediaRepository.save(media);
	}

	@Override
	public List<Media> lire() {
		return mediaRepository.findAll();
	}

	@Override
	public Media modifier(Long id_media, Media media) {
		return mediaRepository.findById(id_media)
				.map(m-> {
					m.setMediaText(media.getMediaText());
					m.setMediaImage(media.getMediaImage());
					m.setIdEncyclopedie(media.getIdEncyclopedie());
					return mediaRepository.save(m); 			
				}).orElseThrow(() -> new RuntimeException("Media not found"));
	}

	@Override
	public String supprimer(Long id_media) {
		mediaRepository.deleteById(id_media);
		return "Media deleted";
	}

}
