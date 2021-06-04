package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;


import com.proyecbatallanaval.proyecbatallanaval.modelo.ListaDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class Tablero {
    public int id;
    public int cols;
    public int filas;
    public Usuario jugador;
    public ListaDE listaBarco;
    public boolean estadoTablero;
    public List<CoordenadaDTO> disparosRecibidos;



    public Tablero(int id, int cols, int filas, Usuario jugador, ListaDE listaBarco) {
        this.id = id;
        this.cols = cols;
        this.filas = filas;
        this.jugador = jugador;
        this.listaBarco = listaBarco;

    }

    public String validarDisparo(int x, int y)
    {
        return null;
    }
}