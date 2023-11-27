package com.ayoub.produits;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ayoub.produits.entities.Ingenieur;
import com.ayoub.produits.entities.Projet;
import com.ayoub.produits.repos.IngenieurRepository;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniprojetApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private IngenieurRepository produitRepository;

	@Test
	public void testCreateIngenieur() {
	Ingenieur prod = new Ingenieur("Houssem","3ans");
	produitRepository.save(prod);
	}
	
	@Test
	public void testFindIngenieur()
	{
	Ingenieur p = produitRepository.findById(1L).get(); 
	System.out.println(p);
	}
	@Test
	public void testUpdateIngenieur()
	{
	Ingenieur p = produitRepository.findById(1L).get();
	p.setExpertise("1ans");
	produitRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(2L);;
	}
	@Test
	public void testListerTousIngenieurs()
	{
	List<Ingenieur> prods = produitRepository.findAll();
	for (Ingenieur p : prods)
	{
	System.out.println(p);
	}
	}
	 @Test
	 public void testFindByNomIngenieur()
	 {
	 List<Ingenieur> prods = produitRepository.findByNomIngenieur("Ayoub");
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testFindByNomIngenieurContains ()
	 {
	 List<Ingenieur> prods=produitRepository.findByNomIngenieurContains("m");
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 } }

	 @Test
	 public void testfindByNomExpertise()
	 {
	 List<Ingenieur> prods = produitRepository.findByNomExpertise("Houssem","1ans");
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void testfindByProjet()
	 {
	 Projet cat = new Projet();
	 cat.setIdProj(1L);
	 List<Ingenieur> prods = produitRepository.findByProjet(cat);
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	 @Test
	 public void findByProjetIdCat()
	 {
	 List<Ingenieur> prods = produitRepository.findByProjetIdProj(1L);
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 }
	  }
	 @Test
	 public void testfindByOrderByNomIngenieurAsc()
	 {
	 List<Ingenieur> prods = 
	 produitRepository.findByOrderByNomIngenieurAsc();
	 for (Ingenieur p : prods)
	 {
	 System.out.println(p);
	 }
	 }

}
