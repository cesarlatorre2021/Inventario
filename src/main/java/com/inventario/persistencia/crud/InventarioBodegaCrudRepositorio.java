package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.InventarioBodega;

public interface InventarioBodegaCrudRepositorio extends CrudRepository <InventarioBodega, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM INVENTARIO_BODEGA "
			+ "      WHERE IDPRODUCTOBODEGA = :idproductobodega", nativeQuery = true)
	Optional<InventarioBodega> listarInventarioBodegaID(@Param("idproductobodega") String idProductoBodega);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM INVENTARIO_BODEGA "
			+ "      WHERE IDPRODUCTOBODEGA = ?", nativeQuery = true)
	void deleteForId(@Param("idproductobodega") String idProductoBodega);
	
	@Modifying
	@Query(value = "UPDATE INVENTARIO_BODEGA "
			+ "        SET CANTPRODUCTOSENT = :cantproductosent"
			+ "           ,CANTPRODUCTOSSAL = :cantproductossal"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDPRODUCTOBODEGA = :idproductobodega", nativeQuery = true)
	void modificarProducto(@Param("cantproductosent") Long cantproductosent,
			               @Param("cantproductossal") Long cantproductossal,
			               @Param("idproductobodega") String idProductoBodega);

}
