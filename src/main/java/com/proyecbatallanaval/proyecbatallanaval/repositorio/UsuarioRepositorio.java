package com.proyecbatallanaval.proyecbatallanaval.repositorio;

import com.proyecbatallanaval.proyecbatallanaval.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio  extends CrudRepository<Usuario,Integer> {
    @Query("SELECT usuario FROM Usuario usuario where usuario.tipoUsuario.codigo=?1")
    List<Usuario> obtenerUsuariosPorRol(int codigoRol);

    @Query("SELECT usuario FROM Usuario usuario where usuario.correo=?1")
    Usuario obtenerUsuarioPorCorreo(String correo);
}