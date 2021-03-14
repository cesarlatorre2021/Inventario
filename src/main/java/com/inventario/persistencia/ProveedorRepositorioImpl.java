package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.Proveedor;
import com.inventario.persistencia.crud.ProveedorCrudRepositorio;
import com.inventario.repositorio.ProveedorRepositorio;

@Repository
public class ProveedorRepositorioImpl implements ProveedorRepositorio {

	@Autowired
    private ProveedorCrudRepositorio proveedorCrudRepositorio;
	
	@Override
	public List<Proveedor> getAll() {
		return (List<Proveedor>) proveedorCrudRepositorio.findAll();
	}

	@Override
	public Optional<Proveedor> getByIdProveedor(String idProveedor) {
		// TODO Auto-generated method stub
		return proveedorCrudRepositorio.listarProveedorID(idProveedor);
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		return proveedorCrudRepositorio.save(proveedor);
	}

	@Transactional
	@Override
	public void delete(String idProveedor) {
		proveedorCrudRepositorio.deleteForId(idProveedor);
	}
	
	@Override
	public void modify(Proveedor proveedor) {
		proveedorCrudRepositorio.modificarProveedor(proveedor.getRazonsocial(), proveedor.getIdproveedor());
	}

}
