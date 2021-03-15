package com.inventario.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.entity.Producto;
import com.inventario.persistencia.crud.ProductoCrudRepositorio;
import com.inventario.repositorio.ProductoRepositorio;

@Repository
public class ProductoRepositorioImpl implements ProductoRepositorio {
	
	@Autowired
    private ProductoCrudRepositorio productoCrudRepositorio;

	@Override
	public List<Producto> getAll() {
		return (List<Producto>) productoCrudRepositorio.findAll();
	}

	@Override
	public Optional<Producto> getByIdProducto(String idProducto) {
		return productoCrudRepositorio.listarProductoID(idProducto);
	}

	@Override
	public Producto save(Producto producto) {
		return productoCrudRepositorio.save(producto);
	}

	@Override
	public void delete(String idProducto) {
		productoCrudRepositorio.deleteForId(idProducto);	
	}

	@Override
	public void modify(Producto producto) {
		productoCrudRepositorio.modificarProducto(producto.getNombreProducto(), 
				                                  producto.getPrecioUnidad(), 
				                                  producto.getValorMayor(), 
				                                  producto.getIdProducto());
	}

}
