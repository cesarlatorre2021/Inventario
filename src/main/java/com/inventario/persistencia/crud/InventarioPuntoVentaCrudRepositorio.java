package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.InventarioPuntoVenta;

public interface InventarioPuntoVentaCrudRepositorio extends CrudRepository <InventarioPuntoVenta, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM INVENTARIO_PUNTOVENTA "
			+ "      WHERE IDINVENTARIOPUNTOVENTA = :idinventariopuntoventa", nativeQuery = true)
	Optional<InventarioPuntoVenta> listarInventarioPuntoVentaID(@Param("idinventariopuntoventa") String idInventarioPuntoVenta);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM INVENTARIO_PUNTOVENTA "
			+ "      WHERE IDINVENTARIOPUNTOVENTA = ?", nativeQuery = true)
	void deleteForId(@Param("idproductobodega") String idProductoBodega);
	
	@Modifying
	@Query(value = "UPDATE INVENTARIO_PUNTOVENTA "
			+ "        SET CANTPRODUCTOENT = :cantproductosent"
			+ "           ,CANTPRODUCTOSAL = :cantproductossal"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDINVENTARIOPUNTOVENTA = :idinventariopuntoventa", nativeQuery = true)
	void modificarProducto(@Param("cantproductosent") Long cantproductosent,
			               @Param("cantproductossal") Long cantproductossal,
			               @Param("idinventariopuntoventa") String idInventarioPuntoVenta);

}
