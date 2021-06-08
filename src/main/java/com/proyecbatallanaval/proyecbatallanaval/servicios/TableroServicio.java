package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.*;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;

import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

@Service
public class TableroServicio {
    private UsuarioRepositorio usuarioRepositorio;
    private CasillaBarco[][] tablero;

    @Autowired
    public TableroServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;

    }
    public ResponseEntity<Object> inicializarTablero(int filas, int cols)
    {
        if(filas <0 || cols <0)
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Constants.MESSAGE_ROWS_COLS_POSITIVE,null,
                            Constants.ERROR_ROWS_COLS_POSITIVE)
                    , HttpStatus.CONFLICT);
        }
        tablero = new CasillaBarco[filas][cols];
        return new ResponseEntity<>(
                new RespuestaDTO(Constants.SUCCESSFUL,null,null),HttpStatus.CREATED
        );
    }
}
