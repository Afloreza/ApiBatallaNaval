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

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cols", nullable = false)
    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    @Basic
    @Column(name = "filas", nullable = false)
    public int getFilas() {
        return filas;
    }

    public void setFilas(short filas) {
        this.filas = filas;
    }


    public String validarDisparo(int x, int y)
    {
        return null;
    }
}