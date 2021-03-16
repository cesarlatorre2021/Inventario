package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.PuntoVenta;
import com.inventario.repositorio.PuntoVentaRepositorio;

@Service
public class PuntoVentaServicio {

	@Autowired
	private PuntoVentaRepositorio puntoVentaRepositorio;
	
	public List<PuntoVenta> getAll() {
        return puntoVentaRepositorio.getAll();
    }
	
	public Optional<PuntoVenta> getPuntoVentaId(String idPuntoVenta) {
        return puntoVentaRepositorio.getByIdPuntoVenta(idPuntoVenta);
    }
	
	public PuntoVenta save(PuntoVenta puntoVenta) {
        return puntoVentaRepositorio.save(puntoVenta);
    }

    public boolean delete(String idPuntoVenta) {
    	if (getPuntoVentaId(idPuntoVenta).isPresent() == true) {
    		puntoVentaRepositorio.delete(idPuntoVenta);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public PuntoVenta modify(PuntoVenta puntoVenta) {
        return puntoVentaRepositorio.save(puntoVenta);
    }
    
}
