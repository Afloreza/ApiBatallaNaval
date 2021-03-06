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
public class UsuarioServicio {
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                usuarioRepositorio.findAll(),null), HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Usuario usuario)
    {
        try
        {
            Usuario usuarioGuardado= usuarioRepositorio.save(usuario);
            return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                    usuarioGuardado,null), HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null,Constants.ERROR_PERSISTENCE_SAVE),
                    HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> findUsersByRol(short codeRol)
    {
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                usuarioRepositorio.obtenerUsuariosPorRol(codeRol),null), HttpStatus.OK);
    }
}
