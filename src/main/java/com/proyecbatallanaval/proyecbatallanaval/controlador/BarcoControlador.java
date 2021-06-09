package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.servicios.BarcosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "barco")
@Validated
//Clase para controlar el barco
public class BarcoControlador {
    private BarcosServicio barcosServicio;

    @Autowired
    public BarcoControlador (BarcosServicio barcosServicio) {
        this.barcosServicio = barcosServicio;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> findAll() {

        return barcosServicio.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Barco barco){
        return barcosServicio.create(barco);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<Object> updateBarco(@PathVariable("id") int id,@RequestBody Barco barco)
    {
        barco.setId(id);
        return barcosServicio.updateBarco(barco);
    }

    @DeleteMapping
    public @ResponseBody ResponseEntity<Object> deleteBarco(@PathVariable("id") int id)
    {
        return barcosServicio.deleteBarcoById(id);
    }

}