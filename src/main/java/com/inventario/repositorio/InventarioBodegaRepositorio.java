package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import com.inventario.entity.InventarioBodega;

public interface InventarioBodegaRepositorio {
	List<InventarioBodega> getAll();
	Optional<InventarioBodega> getByIdInventarioBodega(String idInventarioBodega);
	InventarioBodega save(InventarioBodega inventarioBodega);
	void delete(String idInventarioBodega);
	void modify(InventarioBodega inventarioBodega);
}
