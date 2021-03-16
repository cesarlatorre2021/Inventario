package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventario.entity.Proveedor;
import com.inventario.repositorio.ProveedorRepositorio;

@Service
public class ProveedorServicio {
	
	@Autowired
	private ProveedorRepositorio proveedorRepositorio;
	
	public List<Proveedor> getAll() {
        return proveedorRepositorio.getAll();
    }
	
	public Optional<Proveedor> getProveedorId(String idProveedor) {
        return proveedorRepositorio.getByIdProveedor(idProveedor);
    }
	
	public Proveedor save(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    public boolean delete(String idProveedor) {
    	if (getProveedorId(idProveedor).isPresent() == true) {
    		proveedorRepositorio.delete(idProveedor);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Proveedor modify(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

}


