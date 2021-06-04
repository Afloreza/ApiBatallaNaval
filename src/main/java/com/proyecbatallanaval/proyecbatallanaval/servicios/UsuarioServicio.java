package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//Clase que controla los servicios de los usuarios
public class UsuarioServicio {
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                usuarioRepositorio.findAll(),null), HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Usuario usuario)
    {
        try
        {
            Usuario usuarioGuardado= usuarioRepositorio.save(usuario);
            return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                    usuarioGuardado,null), HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Ocurrió un error almacenando el usuario"),
                    HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> findUsersByRol(short codeRol)
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                usuarioRepositorio.obtenerUsuariosPorRol(codeRol),null), HttpStatus.OK);
    }
}
