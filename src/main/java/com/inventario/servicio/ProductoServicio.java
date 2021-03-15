package com.inventario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.entity.Producto;
import com.inventario.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<Producto> getAll() {
        return productoRepositorio.getAll();
    }
	
	public Optional<Producto> getProductoId(String idProducto) {
        return productoRepositorio.getByIdProducto(idProducto);
    }
	
	public Producto save(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public boolean delete(String idProducto) {
    	if (getProductoId(idProducto).isPresent() == true) {
    		productoRepositorio.delete(idProducto);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Producto modify(Producto producto) {
        return productoRepositorio.save(producto);
    }

}
