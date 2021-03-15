package com.inventario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	private String idproducto;
	
	private String nombreproducto;
	private Long preciounidad;
	private Long valormayor;
	private LocalDateTime fechacreacion;
	private LocalDateTime fechamodificacion;
	
    @ManyToOne
    @JoinColumn(name = "idproveedor", insertable = false, updatable = false)
    private Proveedor proveedor;
	
	public String getIdProducto() {
		return idproducto;
	}
	
	public void setIdProducto(String idProducto) {
		this.idproducto = idProducto;
	}
	
	public String getNombreProducto() {
		return nombreproducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreproducto = nombreProducto;
	}
	
	public Long getPrecioUnidad() {
		return preciounidad;
	}
	
	public void setPrecioUnidad(Long precioUnidad) {
		this.preciounidad = precioUnidad;
	}
	
	public Long getValorMayor() {
		return valormayor;
	}
	
	public void setValorMayor(Long valorMayor) {
		this.valormayor = valorMayor;
	}
	
	public LocalDateTime getFechaCreacion() {
		return fechacreacion;
	}
	
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechacreacion = fechaCreacion;
	}
	
	public LocalDateTime getFechaModificacion() {
		return fechamodificacion;
	}
	
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechamodificacion = fechaModificacion;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
