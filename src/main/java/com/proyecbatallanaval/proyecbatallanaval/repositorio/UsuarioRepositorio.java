package com.proyecbatallanaval.proyecbatallanaval.repositorio;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio  extends CrudRepository<Usuario,Integer> {

    //Traera todos los usuarios por el rol que se de por parametro
    @Query("SELECT usuario FROM Usuario usuario where usuario.tipoUsuario.codigo=?1")
    //Para obtener por tipo de usuario , 1 - Administrador, 2 - Jugador
    List<Usuario> obtenerUsuariosPorRol(short codigoRol);


    //Traera todos los usuarios por el rol que se de por parametro
    @Query("SELECT usuario FROM Usuario usuario where usuario.id=?1 AND usuario.tipoUsuario.codigo=?2")
    //Para obtener por tipo de usuario , 1 - Administrador, 2 - Jugador
    Usuario obtenerUsuariosPorCorreoRol(int id, short codigoRol);
}