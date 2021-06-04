package com.proyecbatallanaval.proyecbatallanaval.modelo.dto;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DistribucionBarcoDTO implements Serializable {
    private CoordenadaDTO[] casillas;
    private Barco barco;
    private byte orientacion;
    private String estado;


    public DistribucionBarcoDTO(Barco barco) {
        this.casillas = casillas;
        this.barco = barco;
        this.orientacion = orientacion;
        this.estado = estado;
    }

    public boolean validarDisparo(int x, int y)
    {
        return true;
    }

    public boolean validarExistenciaCoordenada(CoordenadaDTO coordenada)
    {
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
