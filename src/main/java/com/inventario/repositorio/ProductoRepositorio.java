package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import com.inventario.entity.Producto;

public interface ProductoRepositorio {
	List<Producto> getAll();
	Optional<Producto> getByIdProducto(String idProducto);
	Producto save(Producto producto);
	void delete(String idProducto);
	void modify(Producto idProducto);
}
