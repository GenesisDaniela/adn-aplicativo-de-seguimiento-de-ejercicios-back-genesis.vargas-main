package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ConsultaSolicitudIniciarSesion;

public class ComandoSolicitudIniciarSesionUsuarioTestDataBuilder {
    String email;
    String contrasenia;

    public ComandoSolicitudIniciarSesionUsuarioTestDataBuilder crearPorDefecto()   {
        this.email="genesis@gmail.com";
        this.contrasenia="2342233332223";
        return this;
    }

    public ComandoSolicitudIniciarSesionUsuarioTestDataBuilder conEmail(String email)   {
        this.email=email;
        return this;
    }

    public ComandoSolicitudIniciarSesionUsuarioTestDataBuilder conContrasenia(String contrasenia)   {
        this.contrasenia=contrasenia;
        return this;
    }

    public ConsultaSolicitudIniciarSesion build() {
        return new ConsultaSolicitudIniciarSesion(email,contrasenia);
    }
}
