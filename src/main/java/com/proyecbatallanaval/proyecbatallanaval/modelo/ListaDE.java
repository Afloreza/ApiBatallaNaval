package com.proyecbatallanaval.proyecbatallanaval.modelo;

import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.CoordenadaDTO;
import com.proyecbatallanaval.proyecbatallanaval.modelo.dto.DistribucionBarcoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListaDE implements Serializable {

    private NodoDE cabeza;
    private int cont;

    public void adicionarNodo(Object dato){

        if (cabeza == null){

            cabeza = new NodoDE(dato);

        }
        else {
            //Llamar a mi ayudante y colocarme en el ultimo
            NodoDE temp = cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp= temp.getSiguiente();
            }
            ///Parado en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
    }

    public void adicionarNodoAlInicio(Object dato){

        if (cabeza == null) {

        }

    }

    public List<Object> listarBarcos(){
        return null;
    }

    //Permite clonar la listaDE para que se diferente tanto para el Jugador 1, como para el Jugador 2
    public ListaDE clonarlist(){
        ListaDE listaCopia = new ListaDE();
        NodoDE temp = cabeza;

        while (temp != null){

            listaCopia.adicionarNodo(temp);
            temp= temp.getSiguiente();

        }
        return listaCopia;
    }

    //Permite validar la existencia de un listado de coordenas
    public boolean validarExistenciaCoordenadas(CoordenadaDTO[] coordenas){
        NodoDE temp = cabeza;
        if (cabeza != null){
            while (temp != null){
                for (CoordenadaDTO coord: coordenas){
                if (((DistribucionBarcoDTO)temp.getDato()).validarExistenciaCoordenada(coord)){
                    return true;
                    }
                }
                temp= temp.getSiguiente();
            }
        }
        return false;
    }
    public Object encontrarDatoxCodigo(String codigo)
    {
        if(cabeza !=null)
        {
            NodoDE temp=cabeza;
            while(temp !=null)
            {
                if(temp.getDato().equals(codigo))
                {
                    return temp.getDato();
                }
                temp = temp.getSiguiente();
            }
        }
        return null;
    }
}
