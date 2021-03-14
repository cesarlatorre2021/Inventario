package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inventario.entity.Proveedor;

public interface ProveedorCrudRepositorio extends CrudRepository <Proveedor, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM PROVEEDOR "
			+ "      WHERE IDPROVEEDOR = ?", nativeQuery = true)
	Optional<Proveedor> listarProveedorID(String idProveedor);
	
	@Modifying
	@Query(value = "DELETE "
			+ "       FROM PROVEEDOR "
			+ "      WHERE IDPROVEEDOR = ?", nativeQuery = true)
	void deleteForId(String idProveedor);
	
	@Modifying
	@Query(value = "UPDATE PROVEEDOR "
			+ "        SET RAZONSOCIAL = :razonsocial"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDPROVEEDOR = :idproveedor", nativeQuery = true)
	void modificarProveedor(@Param("razonsocial") String razonsocial,
			                @Param("idproveedor") String idproveedor);
}
