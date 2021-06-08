package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.BarcosRepositorio;
import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BarcosServicio {
    private BarcosRepositorio barcosRepositorio;

    @Autowired
    public BarcosServicio(BarcosRepositorio barcosRepositorio) {
        this.barcosRepositorio = barcosRepositorio;
    }

    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                barcosRepositorio.findAll(), null), HttpStatus.OK);
    }

    public ResponseEntity<Object> create(Barco barco) {
        try {

            int cantidadBarcos= barcosRepositorio.encontrarBarcoPorNumeroCasillas(-1,barco.getNumeroCasillas());
            if (cantidadBarcos == 0) {
                Barco barcoGuardado = barcosRepositorio.save(barco);
                return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                        barcoGuardado, null), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                        null, Constants.ERROR_DUPLICATE_BOX),
                        HttpStatus.CONFLICT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null, Constants.ERROR_PERSISTENCE_SAVE),
                    HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteBarcoById(int id)
    {
        if(barcosRepositorio.existsById(id))
        {
            barcosRepositorio.deleteById(id);
            return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                    Constants.MESSAGE_SUCCESSFUL, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                null, Constants.ERROR_PERSISTENCE_DELETE),
                HttpStatus.CONFLICT);
    }

    public ResponseEntity<Object> updateBarco(Barco barco) {

        int cantidadBarcos = barcosRepositorio.encontrarBarcoPorNumeroCasillas(barco.getId(),barco.getNumeroCasillas());
        if (cantidadBarcos == 0) {
            if (barcosRepositorio.existsById(barco.getId())) {
                try {
                    Barco barcoGuardado = barcosRepositorio.save(barco);
                    return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                            barcoGuardado, null), HttpStatus.OK);
                } catch (Exception ex) {
                    return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR_PERSISTENCE_SAVE,
                            null, Constants.ERROR_PERSISTENCE_SAVE),
                            HttpStatus.UNAUTHORIZED);
                }
            } else {
                return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR_PERSISTENCE_SAVE,
                        null, Constants.MESSAGE_ROWS_COLS_POSITIVE),
                        HttpStatus.CONFLICT);
            }
        }
        else
        {
            return new ResponseEntity<>(new RespuestaDTO(Constants.ERROR,
                    null, Constants.ERROR_DUPLICATE_BOX),
                    HttpStatus.CONFLICT);
        }
    }
}