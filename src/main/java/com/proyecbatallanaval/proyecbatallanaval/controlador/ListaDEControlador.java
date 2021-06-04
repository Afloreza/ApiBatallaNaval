package com.proyecbatallanaval.proyecbatallanaval.controlador;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.DistribucionBarcoDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.servicios.ListaDEServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "listabarcos")
public class ListaDEControlador {
    private ListaDEServicio listaDEServicio;
    @Autowired
    public ListaDEControlador(ListaDEServicio listaDEServicio) {
        this.listaDEServicio = listaDEServicio;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> visualizarLista()
    {
        return listaDEServicio.visualizarListaDE();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> adicionarDistribucionBarco(@RequestBody Barco barco)
    {
        DistribucionBarcoDTO distribucion = new DistribucionBarcoDTO(barco);
        return listaDEServicio.adicionarDistribucionBarco(distribucion);
    }

    @GetMapping("cont")
    public @ResponseBody ResponseEntity<Object> contarNodos()
    {
        return listaDEServicio.contarNodos();
    }
}
