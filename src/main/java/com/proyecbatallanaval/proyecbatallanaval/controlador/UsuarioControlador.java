package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "usuario")
@Validated
//Clase para controlar los usuarios del Juego, 1 - Administrador, 2 - Jugador
public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll() {

        return usuarioServicio.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Usuario usuario){
        return usuarioServicio.create(usuario);
    }

    @GetMapping(path = "{codeRol}")
    public @ResponseBody ResponseEntity<Object> findUsersByCodeRol(@PathVariable("codeRol") short codeRol)
    {
        return usuarioServicio.findUsersByRol(codeRol);
    }

}