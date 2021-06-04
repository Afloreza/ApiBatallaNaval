package com.proyecbatallanaval.proyecbatallanaval.repositorio;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//Entrega los metodos genericos de los barcos
public interface BarcosRepositorio extends CrudRepository<Barco,Integer> {

    //Para realizar una consulta, es para dar el orden de los paramatros, como lo va llamando
    @Query("SELECT barquito FROM Barco barquito WHERE barquito.numeroCasillas=?1")
    Barco encontrarBarcoPorNumeroCasillas(short numeroCasillas);

}
