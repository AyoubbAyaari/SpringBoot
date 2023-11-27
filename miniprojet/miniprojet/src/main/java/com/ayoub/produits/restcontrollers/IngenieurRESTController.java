package com.ayoub.produits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayoub.produits.dto.IngenieurDTO;
import com.ayoub.produits.entities.Ingenieur;
import com.ayoub.produits.service.IngenieurService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class IngenieurRESTController {

	@Autowired
	IngenieurService produitService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<IngenieurDTO> getAllIngenieur() {
	return produitService.getAllIngenieur();
	}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public IngenieurDTO getIngenieurById(@PathVariable("id") Long id) {
	return produitService.getIngenieur(id);
	 }
	
	@RequestMapping(path="/addprod",method = RequestMethod.POST)
	public IngenieurDTO createIngenieur(@RequestBody IngenieurDTO ingenieurDTO) {
	return produitService.saveIngenieur(ingenieurDTO);
	}
	@RequestMapping(path="/updateprod",method = RequestMethod.PUT)
	public IngenieurDTO updateIngenieur(@RequestBody IngenieurDTO ingenieurDTO) {
	return produitService.updateIngenieur(ingenieurDTO);
	}

	@RequestMapping(value="/delprod/{id}",method = RequestMethod.DELETE)
	public void deleteIngenieur(@PathVariable("id") Long id)
	{
	produitService.deleteIngenieurById(id);
	}
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Ingenieur> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
	return produitService.findByProjetIdProj(idCat);
	}
	@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
	public List<Ingenieur> findByNomProduitContains(@PathVariable("nom") String nom) {
	return produitService.findByNomIngenieurContains(nom);
	}
}
