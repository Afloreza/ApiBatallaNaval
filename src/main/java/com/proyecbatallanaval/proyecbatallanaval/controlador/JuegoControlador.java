
package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.BarcosServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.JuegoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "juegos")
@Validated
//Clase para controlar el barco
public class JuegoControlador {
    private JuegoServicio juegoServicio;

    @Autowired
    public JuegoControlador(JuegoServicio juegoServicio) {
        this.juegoServicio = juegoServicio;
    }

    /**
    @GetMapping
    public @ResponseBody
    ResponseEntity<Object> findAll() {
        UsuarioRepository usuarioRepository=new U
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                usuarioRepository.obtenerUsuariosPorRol(codeRol),null), HttpStatus.OK);
    }*/

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Juego juego){
        return juegoServicio.create(juego);
    }
}