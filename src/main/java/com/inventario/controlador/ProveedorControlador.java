package com.inventario.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiOperation("busca un proveedor con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 484, message = "Products not found")
    })
	public Optional<Proveedor> getProveedor(@ApiParam(value = "El id del proveedor", required = true, example ="7") @PathVariable("proveedorId") String proveedorId){
		return proveedorServicio.getProveedorId(proveedorId);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor) {
		return new ResponseEntity<> (proveedorServicio.save(proveedor), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") String proveedorId) {
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
    
    @GetMapping("/All/paginado")
    public ResponseEntity<Map<String, Object>> findAll(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "2") int size
        ) {
      try {      
        List<Proveedor> proveedores = new ArrayList<Proveedor>();
        Pageable paging = PageRequest.of(page, size);
        
        Page<Proveedor> pageTuts = proveedorServicio.findAll(paging);
        proveedores = pageTuts.getContent();
              
        Map<String, Object> response = new HashMap<>();
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        response.put("proveedores", proveedores);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

}
