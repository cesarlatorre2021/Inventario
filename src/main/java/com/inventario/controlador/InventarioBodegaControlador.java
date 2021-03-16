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

import com.inventario.entity.InventarioBodega;
import com.inventario.servicio.InventarioBodegaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/inventariobodega")
public class InventarioBodegaControlador {
	
	@Autowired
    private InventarioBodegaServicio inventarioBodegaServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas las bodegas")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<InventarioBodega>> getAll(){
		return new ResponseEntity<> (inventarioBodegaServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{idInventarioBodega}")
    @ApiOperation("busca los datos del inventario de la bodega con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "inventario de la bodega not found")
    })
	public Optional<InventarioBodega> getProveedor(@ApiParam(value = "El id del inventario de la bodega", required = true, example ="7") @PathVariable("idInventarioBodega") String idInventarioBodega){
		return inventarioBodegaServicio.getInventarioBodegaId(idInventarioBodega);
	}
    
    @PostMapping("/save")
	public ResponseEntity<InventarioBodega> save(@RequestBody InventarioBodega inventarioBodega) {
		return new ResponseEntity<> (inventarioBodegaServicio.save(inventarioBodega), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String inventarioBodegaId) {
   		if(inventarioBodegaServicio.delete(inventarioBodegaId) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<InventarioBodega> modify(@RequestBody InventarioBodega inventarioBodega) {
		return new ResponseEntity<> (inventarioBodegaServicio.modify(inventarioBodega), HttpStatus.OK);
	}

}
