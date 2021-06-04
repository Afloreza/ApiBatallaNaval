package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;


import javax.persistence.*;

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

}
