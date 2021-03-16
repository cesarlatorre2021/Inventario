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

import com.inventario.entity.Bodega;
import com.inventario.servicio.BodegaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/bodega")
public class BodegaControlador {
	
	@Autowired
    private BodegaServicio bodegaServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas las bodegas")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Bodega>> getAll(){
		return new ResponseEntity<> (bodegaServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{bodegaId}")
    @ApiOperation("busca una bodega con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "bodega not found")
    })
	public Optional<Bodega> getProveedor(@ApiParam(value = "El id de la bodega", required = true, example ="7") @PathVariable("bodegaId") String bodegaId){
		return bodegaServicio.getBodegaId(bodegaId);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Bodega> save(@RequestBody Bodega bodega) {
		return new ResponseEntity<> (bodegaServicio.save(bodega), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String bodegaId) {
   		if(bodegaServicio.delete(bodegaId) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Bodega> modify(@RequestBody Bodega bodega) {
		return new ResponseEntity<> (bodegaServicio.modify(bodega), HttpStatus.OK);
	}

}
