package com.ayoub.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ayoub.produits.entities.Ingenieur;
import com.ayoub.produits.entities.Projet;


@RepositoryRestResource(path ="rest")
public interface IngenieurRepository extends JpaRepository<Ingenieur, Long>{

	List<Ingenieur> findByNomIngenieur(String nom);
	 List<Ingenieur> findByNomIngenieurContains(String nom);
	 
	 @Query("select p from Ingenieur p where p.nomIngenieur like %:nom and p.expertise = :expertise")
	 List<Ingenieur> findByNomExpertise (@Param("nom") String nom,@Param("expertise") String expertise);
	 
	 @Query("select p from Ingenieur p where p.projet = ?1")
	 List<Ingenieur> findByProjet (Projet projet);
	 List<Ingenieur> findByProjetIdProj(Long id);
	 
	 List<Ingenieur> findByOrderByNomIngenieurAsc();
	 
	


}
