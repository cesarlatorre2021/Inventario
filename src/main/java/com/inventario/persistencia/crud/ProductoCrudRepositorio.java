package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.Producto;

public interface ProductoCrudRepositorio extends CrudRepository <Producto, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM PRODUCTO "
			+ "      WHERE IDPRODUCTO = :idproducto", nativeQuery = true)
	Optional<Producto> listarProductoID(@Param("idproducto") String idProducto);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM PRODUCTO "
			+ "      WHERE IDPRODUCTO = ?", nativeQuery = true)
	void deleteForId(@Param("idproducto") String idProducto);
	
	@Modifying
	@Query(value = "UPDATE PRODUCTO "
			+ "        SET NOMBREPRODUCTO = :nombreproducto"
			+ "           ,PRECIOUNIDAD = :preciounidad"
			+ "           ,VALORMAYOR  = :valormayor"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDPRODUCTO = :idproducto", nativeQuery = true)
	void modificarProducto(@Param("nombreproducto") String nombreProducto,
			               @Param("preciounidad") Long precioUnidad,
			               @Param("valormayor") Long valorMayor,
			               @Param("idproducto") String idProducto);

}
