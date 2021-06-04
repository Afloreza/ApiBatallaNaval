package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.TipoUsuario;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.JuegoRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JuegoServicio {
    private UsuarioRepositorio usuarioRepositorio;
    private JuegoRepositorio juegoRepositorio;
    @Autowired
    public JuegoServicio(UsuarioRepositorio usuarioRepositorio, JuegoRepositorio juegoRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.juegoRepositorio  = juegoRepositorio;
    }
    public ResponseEntity<Object> create(Juego juego)
    {
        try
        {
            Usuario usuario = this.usuarioRepositorio.obtenerUsuariosPorCorreoRol(juego.getCreadoPor(), TipoUsuario.TIPO_ADMINISTRADOR);
            if(usuario != null){
                juegoRepositorio.save(juego);
                return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                        juego,null), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new RespuestaDTO("Error",
                        null,"El usuario no es de tipo administrador"),
                        HttpStatus.UNAUTHORIZED);
            }
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Ocurrió un error almacenando el juego"),
                    HttpStatus.CONFLICT);
        }
    }
}