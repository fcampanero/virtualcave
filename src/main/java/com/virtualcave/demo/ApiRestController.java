package com.virtualcave.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtualcave.demo.entities.Tarifa;
import com.virtualcave.demo.model.TarifaRequest;
import com.virtualcave.demo.services.TarifaService;

import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiRestController.COUNTRIES_RESOURCE)
public class ApiRestController {

    public static final String COUNTRIES_RESOURCE = "/api/countries";

    private final TarifaService tarifaService;

    public ApiRestController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    //Permitir recuperar todas las tarifas 
    @GetMapping
    public List<Tarifa> getAll() {
        return tarifaService.findAll();
    }
    
    //Permitir recuperar una tarifa por id, con los precios debidamente formateados y mostrando el código y símbolo de la moneda.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarifa> getById(@PathVariable Long id) {
        return tarifaService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Permitir crear una tarifa nueva
    @PostMapping
    public ResponseEntity<Map<String, Object>> add(@RequestBody @Valid TarifaRequest tarifa) {
        Long id = tarifaService.create(tarifa);
        return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
    }

    //Permitir modificar el precio de una tarifa
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,  @RequestBody @Valid TarifaRequest tarifaRequest) {
        boolean wasUpdated = tarifaService.update(id, tarifaRequest);
        return wasUpdated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    //Permitir borrar una tarifa por id
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    	tarifaService.delete(id);
    }

}
