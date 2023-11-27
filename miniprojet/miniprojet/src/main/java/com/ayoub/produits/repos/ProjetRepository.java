package com.ayoub.produits.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ayoub.produits.entities.Projet;


@RepositoryRestResource(path = "proj")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface ProjetRepository extends JpaRepository <Projet, Long>{

}
