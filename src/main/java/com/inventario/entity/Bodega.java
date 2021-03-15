package com.inventario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega {
	
	@Id
	private String idbodega;
	
	private String nombrebodega;
	private String direccion;
	private String ciudad;
	private String departamento;
	private String pais;
	private LocalDateTime fechacreacion;
	private LocalDateTime fechamodificacion;
	
	public String getIdbodega() {
		return idbodega;
	}
	
	public void setIdbodega(String idbodega) {
		this.idbodega = idbodega;
	}
	
	public String getNombrebodega() {
		return nombrebodega;
	}
	
	public void setNombrebodega(String nombrebodega) {
		this.nombrebodega = nombrebodega;
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
