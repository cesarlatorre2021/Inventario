package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.entity.Proveedor;

public interface ProveedorCrudRepositorio extends CrudRepository <Proveedor, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM PROVEEDOR "
			+ "      WHERE IDPROVEEDOR = :idproveedor", nativeQuery = true)
	Optional<Proveedor> listarProveedorID(@Param("idproveedor") String idProveedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM PROVEEDOR "
			+ "      WHERE IDPROVEEDOR = ?", nativeQuery = true)
	void deleteForId(String idProveedor);
	
	@Modifying
	@Query(value = "UPDATE PROVEEDOR "
			+ "        SET RAZONSOCIAL = :razonsocial"
			+ "           ,DIRECCION = :direccion"
			+ "           ,TELEFONO  = :telefono"
			+ "           ,SNACTIVO  = :snactivo"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDPROVEEDOR = :idproveedor", nativeQuery = true)
	void modificarProveedor(@Param("razonsocial") String razonsocial,
			                @Param("idproveedor") String idproveedor,
			                @Param("direccion") String direccion,
			                @Param("telefono") Long telefono,
			                @Param("snactivo") boolean snactivo);
}
