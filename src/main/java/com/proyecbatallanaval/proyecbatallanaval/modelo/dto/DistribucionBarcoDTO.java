package com.proyecbatallanaval.proyecbatallanaval.modelo.dto;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DistribucionBarcoDTO implements Serializable {
    private Barco barco;
    private byte orientacion;
    private String estado;
    private CoordenadaDTO[] casillas;

    public DistribucionBarcoDTO(Barco barco) {
        this.barco = barco;
        this.estado="AGUA";

    }

    public void definirUbicacion(int x, int y, byte orientacion)
    {
        this.casillas = new CoordenadaDTO[barco.getNumeroCasillas()];
        for(int i=0; i < casillas.length;i++)
        {
            //TODO Verificar que la coordenada este libre
            casillas[i]= new CoordenadaDTO(x,y,false);
            if(orientacion==1)//Horizontal
            {
                x++;
            }
            else //Vetical
            {
                y++;
            }
        }
    }

    public void definirUbicacion(CoordenadaDTO[] coordenadas)
    {
        this.casillas= coordenadas;
    }

    public boolean validarExistenciaCoordenada(CoordenadaDTO coordenada){
        if(casillas!=null) {
            for (CoordenadaDTO coord : casillas) {
                if(coord.equals(coordenada))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public CoordenadaDTO[] sugerirUbicacion(int x, int y, byte orientacion)
    {
        CoordenadaDTO[] casillasSugeridas = new CoordenadaDTO[barco.getNumeroCasillas()];

        for(int i=0; i < casillasSugeridas.length;i++)
        {
            //TODO Verificar que la coordenada este libre
            casillasSugeridas[i]= new CoordenadaDTO(x,y,false);
            if(orientacion==1)//Horizontal
            {
                x++;
            }
            else //Vertical
            {
                y++;
            }
        }
        return casillasSugeridas;
    }
}
