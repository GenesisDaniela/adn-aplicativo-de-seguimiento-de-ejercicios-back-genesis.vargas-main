package com.ceiba.usuario;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.Date;

public class UsuarioTestDataBuilder {
    private Long id;
    private String nombre;
    private Float peso;
    private String correo;
    private String contrasenia;
    private Date fechaNacimiento;

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conPeso(Float peso) {
        this.peso = peso;
        return this;
    }

    public UsuarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioTestDataBuilder conContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }

    public UsuarioTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Usuario reconstruir() {
        return Usuario.reconstruir(id, nombre, peso, fechaNacimiento, correo,contrasenia);
    }
}
