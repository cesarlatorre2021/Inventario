package com.inventario.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	private String idproveedor;
	
	private String razonsocial;
	private String direccion;
	private long telefono;
	private boolean snactivo;
	private LocalDateTime fechadesvinculacion;
	private LocalDateTime fechamodificacion;
	private LocalDateTime fechacreacion;
	
	public String getIdproveedor() {
		return idproveedor;
	}
	
	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}
	
	public String getRazonsocial() {
		return razonsocial;
	}
	
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public boolean isSnactivo() {
		return snactivo;
	}
	
	public void setSnactivo(boolean snactivo) {
		this.snactivo = snactivo;
	}
	
	public LocalDateTime getFechadesvinculacion() {
		return fechadesvinculacion;
	}
	
	public void setFechadesvinculacion(LocalDateTime fechadesvinculacion) {
		this.fechadesvinculacion = fechadesvinculacion;
	}
	
	public LocalDateTime getFechamodificacion() {
		return fechamodificacion;
	}
	
	public void setFechamodificacion(LocalDateTime fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	
	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}
	
	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
}
