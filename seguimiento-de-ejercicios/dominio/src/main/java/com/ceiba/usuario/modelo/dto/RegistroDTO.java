package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Getter
public class RegistroDTO {
    private final Long id;
    private final String nombre;
    private final Float peso;
    private final String correo;
    private final String contrasenia;
    private final Date fechaNacimiento;

}
