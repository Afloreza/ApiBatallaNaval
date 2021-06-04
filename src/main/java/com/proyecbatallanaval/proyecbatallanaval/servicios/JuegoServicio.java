package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Tablero;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JuegoServicio {
    private ListaDEServicio listaDEServicio; //inyecto el servicio de ListaDE
    private Tablero tablero;


    // TERMINAR ESTE CONSTRUCTOR!!!
    @Autowired
    public JuegoServicio(ListaDEServicio listaDEServicio) {
        this.listaDEServicio = listaDEServicio;
    }

    //private List<Juego> juego;
    private Juego juego;

    public ResponseEntity<Object> crearJuego(Usuario jugador1, Usuario jugador2)
    {
        // validar y crear juego con los 2 tableros

        if (listaDEServicio.obtenerContadorLista()>0)
        {
            // crear el tablero 1 y el tablero 2
            // crear el juego
            // retorno el juego creado
            juego = new Juego(1,jugador1,jugador2,listaDEServicio.getListaBarcos());
            return new ResponseEntity<>(new RespuestaDTO("Juego creado",
                    juego,null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Aun no ha distribuido la lista DE"),
                    HttpStatus.CONFLICT);
        }
    }
}