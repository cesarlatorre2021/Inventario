package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.entity.Bodega;
import com.inventario.persistencia.crud.BodegaCrudRepositorio;
import com.inventario.repositorio.BodegaRepositorio;

@Repository
public class BodegaRepositorioImpl implements BodegaRepositorio {
	
	@Autowired
    private BodegaCrudRepositorio bodegaCrudRepositorio;

	@Override
	public List<Bodega> getAll() {
		return (List<Bodega>) bodegaCrudRepositorio.findAll();
	}

	@Override
	public Optional<Bodega> getByIdBodega(String idBodega) {
		return bodegaCrudRepositorio.listarBodegaID(idBodega);
	}

	@Override
	public Bodega save(Bodega bodega) {
		return bodegaCrudRepositorio.save(bodega);
	}

	@Override
	public void delete(String idBodega) {
		bodegaCrudRepositorio.deleteForId(idBodega);	
	}

	@Override
	public void modify(Bodega bodega) {
		bodegaCrudRepositorio.modificarProducto(bodega.getNombrebodega(), 
				                                bodega.getDireccion(), 
				                                bodega.getCiudad(), 
				                                bodega.getDepartamento(), 
				                                bodega.getPais());
	}

}
