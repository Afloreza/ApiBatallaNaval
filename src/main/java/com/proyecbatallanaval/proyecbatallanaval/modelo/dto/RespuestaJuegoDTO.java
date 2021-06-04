package com.proyecbatallanaval.proyecbatallanaval.modelo.dto;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RespuestaJuegoDTO implements Serializable {
    private String usuario1;
    private String usuario2;
}
