package com.ayoub.produits.service;

import java.util.List;

import com.ayoub.produits.dto.IngenieurDTO;
import com.ayoub.produits.entities.Ingenieur;
import com.ayoub.produits.entities.Projet;


public interface IngenieurService {
	IngenieurDTO saveIngenieur(IngenieurDTO p);
	IngenieurDTO updateIngenieur(IngenieurDTO p);
	IngenieurDTO getIngenieur(Long id);
	void deleteIngenieur(Ingenieur p);
	 void deleteIngenieurById(Long id);
	List<IngenieurDTO> getAllIngenieur();
	List<Ingenieur> findByNomIngenieur(String nom);
	List<Ingenieur> findByNomIngenieurContains(String nom);
	List<Ingenieur> findByNomExpertise (String nom, String expertise);
	List<Ingenieur> findByProjet (Projet projet);
	List<Ingenieur> findByProjetIdProj(Long id);
	List<Ingenieur> findByOrderByNomIngenieurAsc();
	IngenieurDTO convertEntityToDto (Ingenieur ingenieur);
	Ingenieur convertDtoToEntity(IngenieurDTO ingenieurDto);
}
