package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.entity.InventarioPuntoVenta;
import com.inventario.persistencia.crud.InventarioPuntoVentaCrudRepositorio;
import com.inventario.repositorio.InventarioPuntoVentaRepositorio;

@Repository
public class InventarioPuntoVentaRepositorioImpl implements InventarioPuntoVentaRepositorio {
	
	@Autowired
    private InventarioPuntoVentaCrudRepositorio inventarioPuntoVentaCrudRepositorio;

	@Override
	public List<InventarioPuntoVenta> getAll() {
		return (List<InventarioPuntoVenta>) inventarioPuntoVentaCrudRepositorio.findAll();
	}

	@Override
	public Optional<InventarioPuntoVenta> getByIdInventarioPuntoVenta(String idInventarioPuntoVenta) {
		return inventarioPuntoVentaCrudRepositorio.listarInventarioPuntoVentaID(idInventarioPuntoVenta);
	}

	@Override
	public InventarioPuntoVenta save(InventarioPuntoVenta inventarioPuntoVenta) {
		return inventarioPuntoVentaCrudRepositorio.save(inventarioPuntoVenta);
	}

	@Override
	public void delete(String idInventarioPuntoVenta) {
		inventarioPuntoVentaCrudRepositorio.deleteForId(idInventarioPuntoVenta);	
	}

	@Override
	public void modify(InventarioPuntoVenta idInventarioPuntoVenta) {
		inventarioPuntoVentaCrudRepositorio.modificarProducto(idInventarioPuntoVenta.getCantproductoent(), 
				                                              idInventarioPuntoVenta.getCantproductosal(), 
				                                              idInventarioPuntoVenta.getIdinventariopuntoventa());
	}

}
