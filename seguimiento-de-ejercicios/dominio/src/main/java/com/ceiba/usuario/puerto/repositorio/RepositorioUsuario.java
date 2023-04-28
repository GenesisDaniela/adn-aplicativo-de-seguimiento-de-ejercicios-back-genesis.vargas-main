package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {
    Long guardarUsuario(Usuario usuario);
    Usuario obtenerUsuario(Integer idUsuario);
    Usuario obtenerUsuarioPorCorreo(String correo);

}
