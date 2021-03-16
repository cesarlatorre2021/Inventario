package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.InventarioBodega;
import com.inventario.repositorio.InventarioBodegaRepositorio;

@Service
public class InventarioBodegaServicio {
	
	@Autowired
	private InventarioBodegaRepositorio inventarioBodegaRepositorio;
	
	public List<InventarioBodega> getAll() {
        return inventarioBodegaRepositorio.getAll();
    }
	
	public Optional<InventarioBodega> getInventarioBodegaId(String idInventarioBodega) {
        return inventarioBodegaRepositorio.getByIdInventarioBodega(idInventarioBodega);
    }
	
	public InventarioBodega save(InventarioBodega inventarioBodega) {
        return inventarioBodegaRepositorio.save(inventarioBodega);
    }

    public boolean delete(String idInventarioBodega) {
    	if (getInventarioBodegaId(idInventarioBodega).isPresent() == true) {
    		inventarioBodegaRepositorio.delete(idInventarioBodega);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public InventarioBodega modify(InventarioBodega save) {
        return inventarioBodegaRepositorio.save(save);
    }

}
