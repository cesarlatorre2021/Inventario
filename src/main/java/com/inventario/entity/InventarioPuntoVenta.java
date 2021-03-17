package com.inventario.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "inventario_puntoventa")
public class InventarioPuntoVenta {

	@EmbeddedId
    private InventarioPuntoVentaPK id;
	
	private String idinventariopuntoventa;
	private Long cantproductoent;
	private Long cantproductosal;
	private LocalDateTime fechacreacion;
	private LocalDateTime fechamodificacion;
	
	@ManyToOne
    @MapsId("idpuntosventa")
    @JoinColumn(name = "idpuntosventa", insertable = true, updatable = false)
    private PuntoVenta puntoVenta;

    @ManyToOne
    @MapsId("idproducto")
    @JoinColumn(name = "idproducto", insertable = true, updatable = false)
    private Producto producto;

	public InventarioPuntoVentaPK getId() {
		return id;
	}

	public void setId(InventarioPuntoVentaPK id) {
		this.id = id;
	}
	
	public String getIdinventariopuntoventa() {
		return idinventariopuntoventa;
	}

	public void setIdinventariopuntoventa(String idinventariopuntoventa) {
		this.idinventariopuntoventa = idinventariopuntoventa;
	}

	public Long getCantproductoent() {
		return cantproductoent;
	}

	public void setCantproductoent(Long cantproductoent) {
		this.cantproductoent = cantproductoent;
	}

	public Long getCantproductosal() {
		return cantproductosal;
	}

	public void setCantproductosal(Long cantproductosal) {
		this.cantproductosal = cantproductosal;
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

	public PuntoVenta getPuntoVenta() {
		return puntoVenta;
	}

	public void setPuntoVenta(PuntoVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
}

