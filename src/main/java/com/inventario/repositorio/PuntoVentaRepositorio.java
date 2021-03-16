package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import com.inventario.entity.PuntoVenta;

public interface PuntoVentaRepositorio {
	List<PuntoVenta> getAll();
	Optional<PuntoVenta> getByIdPuntoVenta(String idPuntoVenta);
	PuntoVenta save(PuntoVenta puntoVenta);
	void delete(String idPuntoVenta);
	void modify(PuntoVenta puntoVenta);
}
