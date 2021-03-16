package com.inventario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "puntoventa")
public class PuntoVenta {
	
	@Id
	private String idpuntosventa;
	
	private String razonsocial;
	private String direccion;
	private String ciudad;
	private String departamento;
	private String pais;
	private Long telefono;
	private LocalDateTime fechacreacion;
	private LocalDateTime fechamodificacion;
	
	public String getidpuntosventa() {
		return idpuntosventa;
	}
	
	public void setidpuntosventa(String idpuntosventa) {
		this.idpuntosventa = idpuntosventa;
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
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
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
	
}
