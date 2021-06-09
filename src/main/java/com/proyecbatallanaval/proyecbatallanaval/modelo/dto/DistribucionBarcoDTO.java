package com.proyecbatallanaval.proyecbatallanaval.modelo.dto;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Barco;
import com.proyecbatallanaval.proyecbatallanaval.utilidades.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.lang.invoke.ConstantCallSite;


@Getter
@Setter
public class DistribucionBarcoDTO implements Serializable {
    private Barco barco;
    private byte orientacion;
    private String estado;//Tocado, Hundido, Intacto
    private CoordenadaDTO[] casillas;

    public DistribucionBarcoDTO(Barco barco) {
        this.barco = barco;
        this.estado="INTACTO";

    }

    public void definirUbicacion(int x, int y, byte orientacion)
    {
        this.casillas = new CoordenadaDTO[barco.getNumeroCasillas()];
        for(int i=0; i < casillas.length;i++)
        {
            //TODO Verificar que la coordenada este libre
            casillas[i]= new CoordenadaDTO(x,y,false);
            if(orientacion==1)
            {
                x++;
            }
            else
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

    public Object validarEstadoCoordenada(CoordenadaDTO coordenada)
    {
        if (casillas != null)
        {
            for (CoordenadaDTO coord : casillas)
            {
                if(coord.equals(coordenada))
                {
                    return estado;
                }
            }
        }
        return new ResponseEntity<RespuestaDTO>(new RespuestaDTO(Constants.ERROR,
                null,Constants.MESSAGE_COORD_NOT_VALIDATE), HttpStatus.CONFLICT);
    }
}