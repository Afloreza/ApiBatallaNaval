package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;


import com.proyecbatallanaval.proyecbatallanaval.modelo.ListaDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.DistribucionBarcoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Juego {
    public int id;
    public Tablero tableroJugador1;
    public Tablero tableroJugador2;
    public int numeroBarcos;
    public byte turno;
    public int aciertosJug1;
    public int aciertosJug2;
    public ListaDE listaDE;
    public DistribucionBarcoDTO distribucionBarcoDTO;
    public CoordenadaDTO coordenadaDTO;
    

    public Juego(int id, Usuario jugador1, Usuario jugador2, ListaDE listaDE) {
        this.id = id;
        this.listaDE = listaDE;

    }

    public boolean disparar(int x, int y,ListaDE listaDE)
    {
        return false;
    }

    public void validarDisparo(int x, int y)
    {
        disparar(x,y,listaDE);
    }

    public Usuario validarGanador(Usuario jugador1, Usuario jugador2) {
        if (tableroJugador1 == null) {
            return jugador2;
        } else {
            return jugador1;
        }
    }
}