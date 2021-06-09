package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;


import com.proyecbatallanaval.proyecbatallanaval.modelo.ListaDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tablero", schema = "public", catalog = "batalla_naval")
public class Tablero {
    private int id;
    private int cols;
    private int filas;
    private int juegoId;
    private int creadoPor;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id =id;
    }

    @Column(name = "juego_id", nullable = true)
    public int getJuegoId() {
        return this.juegoId;
    }
    public void setJuegoId(int juegoId){
        this.juegoId = juegoId;
    }
    @Column(name = "creado_por", nullable = true)
    public int getCreadoPor() {
        return this.creadoPor;
    }
    public void setCreadoPor(int creadoPor){
        this.creadoPor = creadoPor;
    }
    public int getCols() {
        return cols;
    }
    public void setCols(int cols) {
        this.cols = cols;
    }
    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void iniciarTablero(int cantidadBarcos){
        if(cantidadBarcos<=9){
            this.filas = 10;
            this.cols = 10;
        }else if(cantidadBarcos>=10 && cantidadBarcos<=20){
            this.filas=20;
            this.cols =20;
        }else{
            this.filas=30;
            this.cols=30;
        }
    }
}