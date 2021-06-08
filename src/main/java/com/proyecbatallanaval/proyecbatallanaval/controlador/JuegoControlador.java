package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaJuegoDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Tablero;
import com.proyecbatallanaval.proyecbatallanaval.servicios.JuegoServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.ListaDEServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.TableroServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.UsuarioServicio;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/juego")
@Validated
public class JuegoControlador {

    private UsuarioServicio usuarioServicio;
    private ListaDEServicio listaDEServicio;
    private JuegoServicio juegoServicio;
    private TableroServicio tableroServicio;
    private UsuarioRepositorio usuarioRepositorio;

    public JuegoControlador(UsuarioServicio usuarioServicio, ListaDEServicio listaDEServicio,
                            JuegoServicio juegoServicio, TableroServicio tableroServicio, UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioServicio = usuarioServicio;
        this.listaDEServicio = listaDEServicio;
        this.juegoServicio = juegoServicio;
        this.tableroServicio = tableroServicio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @PostMapping(path = "/Crear Juego")
    public @ResponseBody ResponseEntity<Object> crearJuego(@RequestBody RespuestaJuegoDTO juegoDTO) {

        // consulta para los dos usuarios
        String usuario1 = juegoDTO.getUsuario1();
        String usuario2 = juegoDTO.getUsuario2();
        try {
            Usuario jugador1 = usuarioRepositorio.obtenerUsuarioPorCorreo(usuario1);
            Usuario jugador2 = usuarioRepositorio.obtenerUsuarioPorCorreo(usuario2);

            if (jugador1 != null && jugador2 != null) {
                return juegoServicio.crearJuego(jugador1, jugador2);
            } else {
                return new ResponseEntity<>(new RespuestaDTO("Error",
                        null,
                        "Los usuarios no registran"),
                        HttpStatus.CONFLICT);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null, "El usuario no esta en la base de datos"),
                    HttpStatus.CONFLICT);
        }
    }

    @PostMapping(path = "/validar")
    public @ResponseBody ResponseEntity<Object> validarCoordenadas(
            @RequestBody CoordenadaDTO[] coordenadas)
    {
        return listaDEServicio.validarExistenciaCoordenadas(coordenadas);
    }

    @GetMapping(path = "/visualizar")
    public @ResponseBody ResponseEntity<Object> visualizarLista()
    {
        return listaDEServicio.visualizarListaDE();
    }

}