package com.proyecbatallanaval.proyecbatallanaval.controlador;


import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.servicios.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/juegos/{idJuego}/tableros")
@Validated
public class TableroControlador {
    private JuegoServicio juegoServicio;

    @Autowired
    public TableroControlador(JuegoServicio juegoServicio) {
        this.juegoServicio = juegoServicio;
    }
    @PostMapping
    public @ResponseBody
    ResponseEntity<Object> create(@PathVariable("idJuego") long idJuego,@RequestBody Juego juego){
        System.out.println(idJuego);
        return juegoServicio.create(juego);
    }
}
