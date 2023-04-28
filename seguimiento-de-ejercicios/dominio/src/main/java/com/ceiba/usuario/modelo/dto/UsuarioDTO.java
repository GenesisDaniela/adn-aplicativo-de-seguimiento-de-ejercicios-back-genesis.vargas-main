package com.ceiba.usuario.modelo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioDTO {
    private  Long id;
    private  String nombre;
    private  Float peso;
    private  String correo;
    private  String contrasenia;

    private Date fechaNacimiento;

    public Date getFechaNacimiento() {
        return new Date(fechaNacimiento.getTime());
    }


    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nombre, Float peso, String correo, String contrasenia, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }
}
