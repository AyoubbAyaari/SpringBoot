package com.ayoub.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomIng", types = { Ingenieur.class })
public interface IngenieurProjection {
	
	public String getNomIngenieur();

}
