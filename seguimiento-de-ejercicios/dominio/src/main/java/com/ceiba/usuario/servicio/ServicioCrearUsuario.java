package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRepetido;
import com.ceiba.usuario.modelo.entidad.SolicitudCrearUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearUsuario {
    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(SolicitudCrearUsuario solicitudCrearUsuario){

        Usuario usuarioEncontrado = repositorioUsuario.obtenerUsuarioPorCorreo(solicitudCrearUsuario.getCorreo());

        if(usuarioEncontrado!= null)
            throw new ExcepcionRepetido("Ya existe un usuario con ese email");

        return repositorioUsuario.guardarUsuario( Usuario.crear(solicitudCrearUsuario));
    }
}
