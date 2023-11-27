package com.ayoub.produits.restcontrollers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ayoub.produits.entities.Projet;
import com.ayoub.produits.repos.ProjetRepository;
@RestController
@RequestMapping("/api/proj")
@CrossOrigin("*")
public class ProjetRESTController {
	@Autowired
	ProjetRepository categorieRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Projet> getAllProjet()
	{
	return categorieRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Projet getProjetById(@PathVariable("id") Long id) {
	return categorieRepository.findById(id).get();
	}	


}
