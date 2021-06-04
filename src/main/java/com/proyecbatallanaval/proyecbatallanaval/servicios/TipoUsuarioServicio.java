package com.proyecbatallanaval.proyecbatallanaval.servicios;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.TipoUsuario;
import com.proyecbatallanaval.proyecbatallanaval.repositorio.TipoUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TipoUsuarioServicio
{
    private TipoUsuarioRepositorio tipoUsuarioRepositorio;

    @Autowired
    public TipoUsuarioServicio(TipoUsuarioRepositorio tipoUsuarioRepositorio)
    {
        this.tipoUsuarioRepositorio = tipoUsuarioRepositorio;
    }

    public Iterable<TipoUsuario> getAllTipoUsuarios()
    {
        return tipoUsuarioRepositorio.findAll();
    }

    public TipoUsuario createTipoUsuario(TipoUsuario tipoUsuario)
    {
        return tipoUsuarioRepositorio.save(tipoUsuario);
    }
}
