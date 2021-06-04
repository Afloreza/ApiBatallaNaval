package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.BarcosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//Clase para implementar el servicio del Barco
public class BarcosServicio {
    private BarcosRepositorio barcosRepositorio;
    @Autowired
    public BarcosServicio(BarcosRepositorio barcosRepositorio) {
        this.barcosRepositorio = barcosRepositorio;
    }

    public ResponseEntity<Object> findAll()
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                barcosRepositorio.findAll(),null), HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Barco barco)
    {
        try
        {
            //Consultar si ya existe un barco con ese número de casilla
            Barco barcoConsulta = barcosRepositorio.encontrarBarcoPorNumeroCasillas(barco.getNumeroCasillas());
            if(barcoConsulta==null)
            {
                Barco barcoGuardado= barcosRepositorio.save(barco);
                return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                        barcoGuardado,null), HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(new RespuestaDTO("Error",
                        null,"Ya existe un barco con ese número de casillas"),
                        HttpStatus.CONFLICT);
            }
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("Error",
                    null,"Ocurrió un error almacenando el Barco"),
                    HttpStatus.CONFLICT);
        }
    }
}
