package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import com.inventario.entity.InventarioPuntoVenta;

public interface InventarioPuntoVentaRepositorio {
	List<InventarioPuntoVenta> getAll();
	Optional<InventarioPuntoVenta> getByIdInventarioPuntoVenta(String idInventarioPuntoVenta);
	InventarioPuntoVenta save(InventarioPuntoVenta inventarioPuntoVenta);
	void delete(String idInventarioPuntoVenta);
	void modify(InventarioPuntoVenta idInventarioPuntoVenta);
}
