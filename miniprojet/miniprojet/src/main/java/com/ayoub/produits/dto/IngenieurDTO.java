package com.ayoub.produits.dto;
import java.util.Date;

import com.ayoub.produits.entities.Projet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngenieurDTO {
	private Long idIngenieur;
	private String nomIngenieur;
	private String expertise;
	private Projet projet;
	private String nomProj;

}
