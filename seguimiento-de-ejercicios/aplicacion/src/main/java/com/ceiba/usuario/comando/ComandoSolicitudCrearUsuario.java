package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearUsuario {

    private String nombre;
    private Float peso;
    private String correo;
    private  String contrasenia;
    private Date fechaNacimiento;

}
