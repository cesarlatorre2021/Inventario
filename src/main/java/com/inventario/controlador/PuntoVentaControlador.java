package com.inventario.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.entity.PuntoVenta;
import com.inventario.servicio.PuntoVentaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/puntoventa")
public class PuntoVentaControlador {
	
	@Autowired
    private PuntoVentaServicio puntoVentaServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todos los puntos de venta")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<PuntoVenta>> getAll(){
		return new ResponseEntity<> (puntoVentaServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{idPuntoVenta}")
    @ApiOperation("Busca a punto de venta con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "Punto de venta not found")
    })
	public Optional<PuntoVenta> getProveedor(@ApiParam(value = "El id del punto de venta", required = true, example ="7") @PathVariable("idPuntoVenta") String idPuntoVenta){
		return puntoVentaServicio.getPuntoVentaId(idPuntoVenta);
	}
    
    @PostMapping("/save")
	public ResponseEntity<PuntoVenta> save(@RequestBody PuntoVenta puntoventa) {
		return new ResponseEntity<> (puntoVentaServicio.save(puntoventa), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String proveedorId) {
   		if(puntoVentaServicio.delete(proveedorId) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<PuntoVenta> modify(@RequestBody PuntoVenta puntoVenta) {
		return new ResponseEntity<> (puntoVentaServicio.modify(puntoVenta), HttpStatus.OK);
	}

}
