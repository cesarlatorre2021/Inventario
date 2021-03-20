package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.InventarioPuntoVenta;
import com.inventario.repositorio.InventarioPuntoVentaRepositorio;

@Service
public class InventarioPuntoVentaServicio {
	
	@Autowired
	private InventarioPuntoVentaRepositorio inventarioPuntoVentaRepositorio;
	
	public List<InventarioPuntoVenta> getAll() {
        return inventarioPuntoVentaRepositorio.getAll();
    }
	
	public Optional<InventarioPuntoVenta> getInventarioBodegaId(String idInventarioPuntoVenta) {
        return inventarioPuntoVentaRepositorio.getByIdInventarioPuntoVenta(idInventarioPuntoVenta);
    }
	
	public InventarioPuntoVenta save(InventarioPuntoVenta inventarioPuntoVenta) {
        return inventarioPuntoVentaRepositorio.save(inventarioPuntoVenta);
    }

    public boolean delete(String idInventarioPuntoVenta) {
    	if (getInventarioBodegaId(idInventarioPuntoVenta).isPresent() == true) {
    		inventarioPuntoVentaRepositorio.delete(idInventarioPuntoVenta);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public InventarioPuntoVenta modify(InventarioPuntoVenta save) {
        return inventarioPuntoVentaRepositorio.save(save);
    }
    
}
