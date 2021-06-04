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
public class UsuarioControlador {
    private UsuarioServicio usuarioServicio;
    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> findAll()
    {
        return usuarioServicio.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody Usuario usuario)
    {
        return usuarioServicio.create(usuario);
    }

    @GetMapping(path = "userbymail/{mail}")
    public @ResponseBody ResponseEntity<Object> findUsersByMail(@PathVariable("mail") String mail)
    {
        return usuarioServicio.findUsersByMail(mail);
    }

}