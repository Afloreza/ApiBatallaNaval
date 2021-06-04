package com.proyecbatallanaval.proyecbatallanaval.modelo.dto;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor

public class CasillaBarco implements Serializable
{
    private Barco barco;
    private boolean marcada;
}
