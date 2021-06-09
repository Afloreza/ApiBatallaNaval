package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Juego;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Tablero;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class JuegoServicio {
    private ListaDEServicio listaDEServicio;

    @Autowired
    public JuegoServicio(ListaDEServicio listaDEServicio) {
        this.listaDEServicio = listaDEServicio;
    }

    //private List<Juego> juego;
    private Juego juego;

    public ResponseEntity<Object> crearJuego(Usuario jugador1, Usuario jugador2)
    {
        // creo el juego

        if (listaDEServicio.obtenerContadorLista()>0)
        {

            juego = new Juego(1,jugador1,jugador2,listaDEServicio.getListaBarcos());
            return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                    juego,null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null,Constants.ERROR_SAVE_GAME),
                    HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> validarExistenciaJuego(Tablero tablerojugador1, Tablero tablerojugador2)
    {
        tablerojugador1 = juego.tableroJugador1;
        tablerojugador2 = juego.tableroJugador2;
        if(tablerojugador1 != null && tablerojugador2 != null)
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null,null), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null,Constants.ERROR_STATE_GAME_INACTIVE), HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> validarGanador(Usuario jugador1, Usuario jugador2)
    {
        try{
            return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                    juego.validarGanador(jugador1,jugador2),null), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null,"Aun no hay un ganador"), HttpStatus.CONFLICT);
        }
    }
}