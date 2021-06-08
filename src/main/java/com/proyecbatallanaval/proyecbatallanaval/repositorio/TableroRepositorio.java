package com.proyecbatallanaval.proyecbatallanaval.repositorio;


import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Tablero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableroRepositorio extends CrudRepository<Tablero,Integer> {

    @Query("SELECT tablero FROM Tablero tablero where tablero.juegoId=?1")
    //Obtener una lista de los tableros actuales
    List<Tablero> obtenerTablerosPorJuego(int juegoId);
    @Query("SELECT tablero FROM Tablero tablero where tablero.id=?1")
        //Obtener una lista de los tableros actuales
    Tablero getTableroPorId(int id);
}
