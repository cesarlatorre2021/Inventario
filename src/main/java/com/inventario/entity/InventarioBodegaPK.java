package com.inventario.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InventarioBodegaPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6166307916073757460L;
	
	private String idproducto;
	private String idbodega;
	
	public String getIdproducto() {
		return idproducto;
	}
	
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	
	public String getIdbodega() {
		return idbodega;
	}
	
	public void setIdbodega(String idbodega) {
		this.idbodega = idbodega;
	}
	
}
