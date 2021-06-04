package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jugador
{
    private String nombre;
    private int id;

    @Id
    @Column(name = "nombre")
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (id != jugador.id) return false;
        if (nombre != null ? !nombre.equals(jugador.nombre) : jugador.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (int) id;
        return result;
    }
}
