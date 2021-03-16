package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.entity.PuntoVenta;
import com.inventario.persistencia.crud.PuntoVentaCrudRepositorio;
import com.inventario.repositorio.PuntoVentaRepositorio;

@Repository
public class PuntoVentaRepositorioImpl implements PuntoVentaRepositorio {
	
	@Autowired
    private PuntoVentaCrudRepositorio puntoVentaCrudRepositorio;

	@Override
	public List<PuntoVenta> getAll() {
		return (List<PuntoVenta>) puntoVentaCrudRepositorio.findAll();
	}

	@Override
	public Optional<PuntoVenta> getByIdPuntoVenta(String idPuntoVenta) {
		return puntoVentaCrudRepositorio.listarPuntoVentaID(idPuntoVenta);
	}

	@Override
	public PuntoVenta save(PuntoVenta puntoVenta) {
		return puntoVentaCrudRepositorio.save(puntoVenta);
	}

	@Override
	public void delete(String idPuntoVenta) {
		puntoVentaCrudRepositorio.deleteForId(idPuntoVenta);
	}

	@Override
	public void modify(PuntoVenta puntoVenta) {
		puntoVentaCrudRepositorio.modificarPuntoVenta(puntoVenta.getRazonsocial(), 
				                                      puntoVenta.getDireccion(), 
				                                      puntoVenta.getCiudad(), 
				                                      puntoVenta.getDireccion(), 
				                                      puntoVenta.getPais(), 
				                                      puntoVenta.getTelefono(), 
				                                      puntoVenta.getidpuntosventa());
	}

}
