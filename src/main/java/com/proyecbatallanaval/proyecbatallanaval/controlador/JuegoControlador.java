
package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.servicios.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "juego")
@Validated
//Clase para adminsitrar el barco
    public class JuegoControlador {
    private JuegoServicio juegoServicio;

    @Autowired
    public JuegoControlador(JuegoServicio juegoServicio) {
        this.juegoServicio = juegoServicio;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Juego juego){
        return juegoServicio.create(juego);
    }
}