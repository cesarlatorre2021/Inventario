package com.inventario.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "inventario_bodega")
public class InventarioBodega {
	

	@EmbeddedId
	private InventarioBodegaPK id;
	
	private String idproductobodega;
	private Long cantproductosent;
	private Long cantproductossal;
	private LocalDateTime fechacreacion;
	private LocalDateTime fechamodificacion;

	@ManyToOne
	@MapsId("idbodega")
	@JoinColumn(name = "idbodega", insertable = true, updatable = false)
	private Bodega bodega;
	
    @ManyToOne
    @MapsId("idproducto")
	@JoinColumn(name = "idproducto", insertable = true, updatable = false)
	private Producto producto;

	public InventarioBodegaPK getId() {
		return id;
	}

	public void setid(InventarioBodegaPK id) {
		this.id = id;
	}
	
	public String getIdproductobodega() {
		return idproductobodega;
	}

	public void setIdproductobodega(String idproductobodega) {
		this.idproductobodega = idproductobodega;
	}

	public Long getCantproductosent() {
		return cantproductosent;
	}

	public void setCantproductosent(Long cantproductosent) {
		this.cantproductosent = cantproductosent;
	}

	public Long getCantproductossal() {
		return cantproductossal;
	}

	public void setCantproductossal(Long cantproductossal) {
		this.cantproductossal = cantproductossal;
	}

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public LocalDateTime getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(LocalDateTime fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
