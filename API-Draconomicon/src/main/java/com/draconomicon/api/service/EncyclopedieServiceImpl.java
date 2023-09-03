package com.draconomicon.api.service;

import java.util.List;


import com.draconomicon.api.model.Encyclopedie;
import com.draconomicon.api.repository.EncyclopedieRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EncyclopedieServiceImpl implements EncyclopedieService{

	private EncyclopedieRepository encyclopedieRepository;
	
	@Override
	public Encyclopedie creer(Encyclopedie encyclopedie) {
		return encyclopedieRepository.save(encyclopedie);
	}

	@Override
	public List<Encyclopedie> lire() {
		return encyclopedieRepository.findAll();
	}

	@Override
	public Encyclopedie modifier(Long id_encyclopedie, Encyclopedie encyclopedie) {
		return encyclopedieRepository.findById(id_encyclopedie)
				.map(e-> {
					e.setEspece(encyclopedie.getEspece());
					e.setCaracText(encyclopedie.getCaracText());
					e.setCaracImage(encyclopedie.getCaracImage());
					e.setMythsText(encyclopedie.getMythsText());
					e.setMythsImage(encyclopedie.getMythsImage());
					return encyclopedieRepository.save(e); 			
				}).orElseThrow(() -> new RuntimeException("encyclopedia not found"));
	}

	@Override
	public String supprimer(Long id_encyclopedie) {
		encyclopedieRepository.deleteById(id_encyclopedie);
		return "encyclopedia deleted";
	}

}
