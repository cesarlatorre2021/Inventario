package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.Bodega;
import com.inventario.repositorio.BodegaRepositorio;

@Service
public class BodegaServicio {
	
	@Autowired
	private BodegaRepositorio bodegaRepositorio;
	
	public List<Bodega> getAll() {
        return bodegaRepositorio.getAll();
    }
	
	public Optional<Bodega> getBodegaId(String idBodega) {
        return bodegaRepositorio.getByIdBodega(idBodega);
    }
	
	public Bodega save(Bodega bodega) {
        return bodegaRepositorio.save(bodega);
    }

    public boolean delete(String idBodega) {
    	if (getBodegaId(idBodega).isPresent() == true) {
    		bodegaRepositorio.delete(idBodega);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Bodega modify(Bodega save) {
        return bodegaRepositorio.save(save);
    }

}
