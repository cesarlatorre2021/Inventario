package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.Bodega;

public interface BodegaCrudRepositorio extends CrudRepository <Bodega, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM BODEGA"
			+ "      WHERE IDBODEGA = :idbodega", nativeQuery = true)
	Optional<Bodega> listarBodegaID(@Param("idbodega") String idBodega);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM BODEGA "
			+ "      WHERE IDBODEGA = ?", nativeQuery = true)
	void deleteForId(String idBodega);
	
	@Modifying
	@Query(value = "UPDATE BODEGA "
			+ "        SET NOMBREBODEGA = :nombrebodega"
			+ "           ,DIRECCION = :direccion"
			+ "           ,CIUDAD  = :ciudad"
			+ "           ,DEPARTAMENTO = :departamento"
			+ "           ,PAIS = :pais"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDBODEGA = :idbodega", nativeQuery = true)
	void modificarProducto(@Param("nombrebodega") String nombreBodega,
			               @Param("direccion") String direccion,
			               @Param("ciudad") String ciudad,
			               @Param("departamento") String departamento,
			               @Param("pais") String pais);

}
