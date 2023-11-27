package com.ayoub.produits.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingenieur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngenieur;
	private String nomIngenieur;
	private String expertise;
	@ManyToOne
	private Projet projet;
	
	public Ingenieur() {
		super();
		}
		public Ingenieur(String nomIngenieur, String expertise) {
		super();
		this.nomIngenieur = nomIngenieur;
		this.expertise = expertise;
		
		}
		public Long getIdIngenieur() {
			return idIngenieur;
		}
		public void setIdIngenieur(Long idIngenieur) {
			this.idIngenieur = idIngenieur;
		}
		public String getNomIngenieur() {
			return nomIngenieur;
		}
		public void setNomIngenieur(String nomIngenieur) {
			this.nomIngenieur = nomIngenieur;
		}
		public String getExpertise() {
			return expertise;
		}
		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}
		@Override
		public String toString() {
			return "Ingenieur [idIngenieur=" + idIngenieur + ", nomIngenieur=" + nomIngenieur + ", expertise="
					+ expertise + "]";
		}

		

		public Projet getProjet() {
			return projet;
		}
		public void setProjet(Projet projet) {
			this.projet = projet;
		}
}
