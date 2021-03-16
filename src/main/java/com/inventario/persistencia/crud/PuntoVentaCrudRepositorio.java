package com.inventario.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inventario.entity.PuntoVenta;

public interface PuntoVentaCrudRepositorio extends CrudRepository <PuntoVenta, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM PUNTOVENTA "
			+ "      WHERE IDPUNTOVENTA = :idpuntoventa", nativeQuery = true)
	Optional<PuntoVenta> listarPuntoVentaID(@Param("idpuntoventa") String idPuntoVenta);
	
	@Modifying
	@Query(value = "DELETE "
			+ "       FROM PUNTOVENTA "
			+ "      WHERE IDPUNTOVENTA = ?", nativeQuery = true)
	void deleteForId(String idPuntoVenta);
	
	@Modifying
	@Query(value = "UPDATE PUNTOVENTA "
			+ "        SET RAZONSOCIAL = :razonsocial"
			+ "           ,DIRECCION = :direccion"
			+ "           ,CIUDAD = :ciudad"
			+ "           ,DEPARTAMENTO = :departamento"
			+ "           ,PAIS = :pais"
			+ "           ,TELEFONO = :telefono"
			+ "           ,FECHAMODIFICACION = DATE"
			+ "      WHERE IDPUNTOVENTA = :idpuntoventa", nativeQuery = true)
	void modificarPuntoVenta(@Param("razonsocial") String razonsocial,
			                @Param("direccion") String direccion,
			                @Param("ciudad") String ciudad,
			                @Param("departamento") String string,
			                @Param("pais") String pais,
			                @Param("telefono") Long telefono,
			                @Param("idpuntoventa") String idpuntoventa);

}
