package com.inventario.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inventario.entity.Proveedor;

public interface ProveedorRepositorio {
	List<Proveedor> getAll();
	Optional<Proveedor> getByIdProveedor(String idProveedor);
	Proveedor save(Proveedor proveedor);
	void delete(String idProveedor);
	void modify(Proveedor proveedor);
	Page<Proveedor> findAll(Pageable pageable);
}
