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

import com.inventario.entity.Proveedor;
import com.inventario.servicio.ProveedorServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/proveedor")
public class ProveedorControlador {
	
	@Autowired
    private ProveedorServicio proveedorServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todos los proveedores")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Proveedor>> getAll(){
		return new ResponseEntity<> (proveedorServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{proveedorId}")
    @ApiOperation("Search a product with and ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "Products not found")
    })
	public Optional<Proveedor> getProveedor(@ApiParam(value = "the id of the product", required = true, example ="7") @PathVariable("proveedorId") String proveedorId){
		return proveedorServicio.getProveedorId(proveedorId);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor) {
		return new ResponseEntity<> (proveedorServicio.save(proveedor), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String proveedorId) {
    	System.out.println("Esto es lo que retorna el metodo: ");
   		if(proveedorServicio.delete(proveedorId) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Proveedor> modify(@RequestBody Proveedor proveedor) {
		return new ResponseEntity<> (proveedorServicio.modify(proveedor), HttpStatus.OK);
	}

}
