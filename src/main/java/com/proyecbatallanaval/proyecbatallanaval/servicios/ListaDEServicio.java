package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.ListaDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.NodoDE;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.DistribucionBarcoDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.RespuestaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaDEServicio {
    private ListaDE listaBarcos;

    public ListaDEServicio() {
        listaBarcos = new ListaDE();
    }

    public ResponseEntity<Object> adicionarDistribucionBarco(DistribucionBarcoDTO distribucion)
    {
        listaBarcos.adicionarNodo(distribucion);
        return new ResponseEntity<>(new RespuestaDTO("Exitoso","Barco adicionado"
                ,null), HttpStatus.OK);
    }

    public ResponseEntity<Object> visualizarListaDE()
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso", listarDatos()
                ,null), HttpStatus.OK);
    }

    private List<DistribucionBarcoDTO> listarDatos()
    {
        List<DistribucionBarcoDTO> listado = new ArrayList<>();
        //Ciclo para recorrer mi lista de de principio a fin
        NodoDE temp = listaBarcos.getCabeza();
        while(temp!=null)
        {
            listado.add((DistribucionBarcoDTO) temp.getDato());
            temp= temp.getSiguiente();
        }
        return listado;
    }

    public ResponseEntity<Object> validarExistenciaCoordenadas(CoordenadaDTO[] coordenadas)
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                listaBarcos.validarExistenciaCoordenadas(coordenadas),null), HttpStatus.OK);
    }

    public ResponseEntity<Object> contarNodos()
    {
        return new ResponseEntity<>(new RespuestaDTO("Exitoso",
                listaBarcos.getCont(),null), HttpStatus.OK);
    }

    public int obtenerContadorLista()
    {
        return listaBarcos.getCont();
    }

    public Barco encontrarBarcoxCodigo(String codigo)


    {
        return (Barco) this.listaBarcos.encontrarDatoxCodigo(codigo);
    }

    public ListaDE getListaBarcos()
    {
        return listaBarcos;
    }
}