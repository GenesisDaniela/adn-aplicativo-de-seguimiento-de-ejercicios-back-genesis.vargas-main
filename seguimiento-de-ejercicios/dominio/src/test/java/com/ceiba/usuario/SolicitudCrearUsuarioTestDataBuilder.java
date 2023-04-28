package com.ceiba.usuario;

import com.ceiba.usuario.modelo.entidad.SolicitudCrearUsuario;

import java.util.Date;

public class SolicitudCrearUsuarioTestDataBuilder {
    private String nombre;
    private Float peso;
    private String correo;
    private String contrasenia;
    private Date fechaNacimiento;

    public SolicitudCrearUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SolicitudCrearUsuarioTestDataBuilder conPeso(Float peso) {
        this.peso = peso;
        return this;
    }

    public SolicitudCrearUsuarioTestDataBuilder conContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    public SolicitudCrearUsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public SolicitudCrearUsuarioTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public SolicitudCrearUsuario build() {
        return new SolicitudCrearUsuario(nombre, peso, correo, contrasenia, fechaNacimiento);
    }
}
