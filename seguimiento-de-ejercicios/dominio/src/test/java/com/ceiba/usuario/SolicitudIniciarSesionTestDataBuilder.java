package com.ceiba.usuario;

import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;

public class SolicitudIniciarSesionTestDataBuilder {
    private String correo;
    private String contrasenia;

    public SolicitudIniciarSesionTestDataBuilder conCorreo(String correo){
        this.correo=correo;
        return this;
    }
    public SolicitudIniciarSesionTestDataBuilder conContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
        return this;
    }

    public SolicitudIniciarSesion build(){
        return new SolicitudIniciarSesion(this.correo,this.contrasenia);
    }
}
