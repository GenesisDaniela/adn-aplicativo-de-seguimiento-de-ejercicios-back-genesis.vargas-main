package com.ceiba.usuario.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

public class ServicioObtenerUsuario {
    private final DaoUsuario daoUsuario;

    public ServicioObtenerUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Usuario ejecutar(Long idUsuario){
        ValidadorArgumento.validarObligatorio(idUsuario,"Debe proporcionar el id del usuario");
        var usuario = daoUsuario.obtenerUsuario(idUsuario);
        ValidadorArgumento.validarObligatorio(usuario,"Usuario no encontrado");
        return usuario;
    }

    }
