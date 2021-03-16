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

import com.inventario.entity.Producto;
import com.inventario.servicio.ProductoServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {
	
	@Autowired
    private ProductoServicio productoServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todos los productos")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Producto>> getAll(){
		return new ResponseEntity<> (productoServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{productoId}")
    @ApiOperation("Busca un producto con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "Productos not found")
    })
	public Optional<Producto> getProveedor(@ApiParam(value = "El id del producto", required = true, example ="7") @PathVariable("productoId") String productoId){
		return productoServicio.getProductoId(productoId);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Producto> save(@RequestBody Producto producto) {
		return new ResponseEntity<> (productoServicio.save(producto), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String proveedorId) {
   		if(productoServicio.delete(proveedorId) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Producto> modify(@RequestBody Producto producto) {
		return new ResponseEntity<> (productoServicio.modify(producto), HttpStatus.OK);
	}

}
