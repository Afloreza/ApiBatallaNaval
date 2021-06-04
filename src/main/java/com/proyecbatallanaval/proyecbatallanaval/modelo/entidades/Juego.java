package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;


import javax.persistence.*;

@Entity
@Table(name = "juego", schema = "public", catalog = "batalla_naval")
public class Juego {
    private int id;
    private int creadoPor;
    private Tablero tableroJugador1;
    private Tablero tableroJugador2;
    private byte turno;
    private int aciertosJug1;
    private int aciertosJug2;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id =id;
    }
    @Column(name = "creado_por", nullable = true)
    public int getCreadoPor() {
        return this.creadoPor;
    }
    public void setCreadoPor(int creadoPor){
        this.creadoPor = creadoPor;
    }
}


