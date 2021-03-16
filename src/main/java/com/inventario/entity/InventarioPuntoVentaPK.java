package com.inventario.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InventarioPuntoVentaPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -680095783116605538L;
	
	private String idproducto;
	private String idpuntosventa;
	
	public String getIdproducto() {
		return idproducto;
	}
	
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	public String getIdpuntosventa() {
		return idpuntosventa;
	}
	
	public void setIdpuntosventa(String idpuntosventa) {
		this.idpuntosventa = idpuntosventa;
	}
	
}
