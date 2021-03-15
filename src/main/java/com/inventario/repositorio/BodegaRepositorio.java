package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import com.inventario.entity.Bodega;

public interface BodegaRepositorio {
	List<Bodega> getAll();
	Optional<Bodega> getByIdBodega(String idBodega);
	Bodega save(Bodega bodega);
	void delete(String idBodega);
	void modify(Bodega bodega);
}
