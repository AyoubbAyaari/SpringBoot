package com.ayoub.produits.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayoub.produits.dto.IngenieurDTO;
import com.ayoub.produits.entities.Ingenieur;
import com.ayoub.produits.entities.Projet;
import com.ayoub.produits.repos.IngenieurRepository;

@Service
public class IngenieurServiceImpl implements IngenieurService {

	@Autowired
	IngenieurRepository produitRepository;

	@Override
	public IngenieurDTO saveIngenieur(IngenieurDTO p) {
		// TODO Auto-generated method stub
		return convertEntityToDto (produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public IngenieurDTO updateIngenieur(IngenieurDTO p) {
		// TODO Auto-generated method stub
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));


	}

	@Override
	public void deleteIngenieur(Ingenieur p) {
		// TODO Auto-generated method stub
		produitRepository.delete(p);

	}

	@Override
	public void deleteIngenieurById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);

	}

	@Override
	public IngenieurDTO getIngenieur(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto (produitRepository.findById(id).get());
	}

	@Override
	public List<IngenieurDTO> getAllIngenieur() {
		// TODO Auto-generated method stub
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Ingenieur> findByNomIngenieur(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomIngenieur(nom);
	}

	@Override
	public List<Ingenieur> findByNomIngenieurContains(String nom) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomIngenieurContains(nom);
	}

	@Override
	public List<Ingenieur> findByNomExpertise(String nom, String expertise) {
		// TODO Auto-generated method stub
		return produitRepository.findByNomExpertise(nom, expertise);
	}

	@Override
	public List<Ingenieur> findByProjet(Projet projet) {
		// TODO Auto-generated method stub
		return produitRepository.findByProjet(projet);

	}

	@Override
	public List<Ingenieur> findByProjetIdProj(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findByProjetIdProj(id);
	}

	@Override
	public List<Ingenieur> findByOrderByNomIngenieurAsc() {
		// TODO Auto-generated method stub
		return produitRepository.findByOrderByNomIngenieurAsc();		
	}
	
	
	@Autowired
	ModelMapper modelMapper;
	@Override
	public IngenieurDTO convertEntityToDto(Ingenieur ingenieur) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		IngenieurDTO ingenieurDTO =modelMapper.map(ingenieur, IngenieurDTO.class);;
	 return ingenieurDTO; 
	 
	 /*return ProduitDTO.builder()
	.idProduit(produit.getIdProduit())
	.nomProduit(produit.getNomProduit())
	.prixProduit(produit.getPrixProduit())
	.dateCreation(p.getDateCreation())
	.categorie(produit.getCategorie())
	.build();*/
	}
	@Override
	public Ingenieur convertDtoToEntity(IngenieurDTO ingenieurDTO) {
	Ingenieur ingenieur = new Ingenieur();
	ingenieur = modelMapper.map(ingenieurDTO, Ingenieur.class);
	ingenieur.setIdIngenieur(ingenieurDTO.getIdIngenieur());
	ingenieur.setNomIngenieur(ingenieurDTO.getNomIngenieur());
	ingenieur.setExpertise(ingenieurDTO.getExpertise());
	ingenieur.setProjet(ingenieurDTO.getProjet()); 
	 return ingenieur; 
	}


}
