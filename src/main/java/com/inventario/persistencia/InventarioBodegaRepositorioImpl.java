package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.entity.InventarioBodega;
import com.inventario.persistencia.crud.InventarioBodegaCrudRepositorio;
import com.inventario.repositorio.InventarioBodegaRepositorio;

@Repository
public class InventarioBodegaRepositorioImpl implements InventarioBodegaRepositorio{
	
	@Autowired
    private InventarioBodegaCrudRepositorio inventarioBodegaCrudRepositorio;

	@Override
	public List<InventarioBodega> getAll() {
		return (List<InventarioBodega>) inventarioBodegaCrudRepositorio.findAll();
	}

	@Override
	public Optional<InventarioBodega> getByIdInventarioBodega(String idInventarioBodega) {
		return inventarioBodegaCrudRepositorio.listarInventarioBodegaID(idInventarioBodega);
	}

	@Override
	public InventarioBodega save(InventarioBodega inventarioBodega) {
		return inventarioBodegaCrudRepositorio.save(inventarioBodega);
	}

	@Override
	public void delete(String idInventarioBodega) {
		inventarioBodegaCrudRepositorio.deleteForId(idInventarioBodega);	
	}

	@Override
	public void modify(InventarioBodega inventarioBodega) {
		inventarioBodegaCrudRepositorio.modificarProducto(inventarioBodega.getCantproductosent(), 
				                                          inventarioBodega.getCantproductossal(), 
				                                          inventarioBodega.getIdproductobodega());
	}

}
