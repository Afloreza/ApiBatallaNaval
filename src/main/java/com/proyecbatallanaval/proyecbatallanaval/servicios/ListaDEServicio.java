package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.ListaDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.NodoDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.DistribucionBarcoDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//Clase para implementar el servicio de la ListaDE
public class ListaDEServicio {
    private ListaDE listaBarcos;

    public ListaDEServicio() {
        listaBarcos = new ListaDE();
    }

    public ResponseEntity<Object> adicionarDistribucionBarco(DistribucionBarcoDTO distribucion)
    {
        listaBarcos.adicionarNodoDE(distribucion);
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,Constants.MESSAGE_SUCCESSFUL
                ,null), HttpStatus.OK);
    }

    public ResponseEntity<Object> visualizarListaDE()
    {
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL, listarDatos()
                ,null), HttpStatus.OK);
    }

    private List<DistribucionBarcoDTO> listarDatos()
    {
        List<DistribucionBarcoDTO> listado = new ArrayList<>();
        NodoDE temp = listaBarcos.getCabeza();
        while(temp!=null)
        {
            listado.add((DistribucionBarcoDTO) temp.getDato());
            temp= temp.getSiguiente();
        }
        return listado;
    }

    public Barco encontrarBarcoxCodigo(String codigo)
    {
        return (Barco) this.listaBarcos.encontrarDatoxCodigo(codigo);
    }

    public int contarNodos()
    {
        return listaBarcos.getCont();
    }

    public int obtenerContadorLista()
    {
        return listaBarcos.getCont();
    }

    public ResponseEntity<Object> validarExistenciaCoordenadas(CoordenadaDTO[] coordenadas)
    {
        return new ResponseEntity<>(new RespuestaDTO(Constants.SUCCESSFUL,
                listaBarcos.validarExistenciaCoordenadas(coordenadas),null), HttpStatus.OK);
    }

    public ListaDE getListaBarcos()
    {
        return listaBarcos;
    }
}

