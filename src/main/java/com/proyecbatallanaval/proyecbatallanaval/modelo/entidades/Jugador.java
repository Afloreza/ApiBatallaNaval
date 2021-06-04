package com.proyecbatallanaval.proyecbatallanaval.modelo.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jugador
{
    private String apodo;
    private short edad;

    @Id
    @Column(name = "apodo")
    public String getApodo()
    {
        return apodo;
    }

    public void setApodo(String apodo)
    {
        this.apodo = apodo;
    }

    @Basic
    @Column(name = "edad")
    public short getEdad()
    {
        return edad;
    }

    public void setEdad(short edad)
    {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (edad != jugador.edad) return false;
        if (apodo != null ? !apodo.equals(jugador.apodo) : jugador.apodo != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = apodo != null ? apodo.hashCode() : 0;
        result = 31 * result + (int) edad;
        return result;
    }
}
