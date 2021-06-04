package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Tablero;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.TipoUsuario;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.TableroRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TableroServicio {
    private UsuarioRepositorio usuarioRepositorio;
    private TableroRepositorio tableroRepositorio;

    @Autowired
    public TableroServicio(UsuarioRepositorio usuarioRepositorio, TableroRepositorio tableroRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.tableroRepositorio  = tableroRepositorio;
    }
    public ResponseEntity<Object> create(Tablero tablero)
    {
        try
        {
            Usuario usuario = this.usuarioRepositorio.obtenerUsuariosPorCorreoRol(tablero.getJugado(), TipoUsuario.TIPO_ADMINISTRADOR);
            if(usuario != null){
                tableroRepositorio.save(tablero);
                return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                        tablero,null), HttpStatus.OK);
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
