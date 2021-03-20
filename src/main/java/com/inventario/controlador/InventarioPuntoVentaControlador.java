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

import com.inventario.entity.InventarioPuntoVenta;
import com.inventario.servicio.InventarioPuntoVentaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/inventariopuntoventa")
public class InventarioPuntoVentaControlador {
	
	@Autowired
	private InventarioPuntoVentaServicio inventarioPuntoVentaServicio;
	
	@GetMapping("/All")
    @ApiOperation("Enlista toda la informacion de los productos en el punto de venta")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<InventarioPuntoVenta>> getAll(){
		return new ResponseEntity<> (inventarioPuntoVentaServicio.getAll(), HttpStatus.OK);
    }
	
    @GetMapping("/All/{idInventarioPuntoVenta}")
    @ApiOperation("busca los datos del inventario del punto de venta con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "Inventario punto de venta not found")
    })
	public Optional<InventarioPuntoVenta> getProveedor(@ApiParam(value = "El id del inventario del punto de venta", required = true, example ="7") @PathVariable("idInventarioPuntoVenta") String idInventarioPuntoVenta){
		return inventarioPuntoVentaServicio.getInventarioBodegaId(idInventarioPuntoVenta);
	}
    
    @PostMapping("/save")
   	public ResponseEntity<InventarioPuntoVenta> save(@RequestBody InventarioPuntoVenta inventarioPuntoVenta) {
   		return new ResponseEntity<> (inventarioPuntoVentaServicio.save(inventarioPuntoVenta), HttpStatus.CREATED);
   	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String idInventarioPuntoVenta) {
   		if(inventarioPuntoVentaServicio.delete(idInventarioPuntoVenta) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<InventarioPuntoVenta> modify(@RequestBody InventarioPuntoVenta inventarioPuntoVenta) {
		return new ResponseEntity<> (inventarioPuntoVentaServicio.modify(inventarioPuntoVenta), HttpStatus.OK);
	}

}
