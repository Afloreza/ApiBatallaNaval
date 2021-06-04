package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaJuegoDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.servicios.JuegoServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.ListaDEServicio;
import com.proyecbatallanaval.proyecbatallanaval.servicios.UsuarioServicio;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.UsuarioRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/juego")
@Validated
public class JuegoControlador {

    // Inyecto los servicios
    private UsuarioServicio usuarioServicio;
    private ListaDEServicio listaDEServicio;
    private JuegoServicio juegoServicio;
    private UsuarioRepositorio usuarioRepositorio;

    public JuegoControlador(UsuarioServicio usuarioServicio, ListaDEServicio listaDEServicio,
                            JuegoServicio juegoServicio, UsuarioRepositorio usuarioRepositorio)
    {
        this.usuarioServicio = usuarioServicio;
        this.listaDEServicio = listaDEServicio;
        this.juegoServicio = juegoServicio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @PostMapping(path = "/crear")
    public @ResponseBody ResponseEntity<Object> crearJuego(@RequestBody RespuestaJuegoDTO juegoDTO) {

        // consulta para saber si usuarios existen
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
                        "Los usuarios digitados no se encuentran en BD"),
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