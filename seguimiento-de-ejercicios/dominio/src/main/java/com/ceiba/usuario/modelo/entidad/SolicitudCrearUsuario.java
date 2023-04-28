package com.ceiba.usuario.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
public class SolicitudCrearUsuario {
    private final String nombre;
    private final Float peso;
    private final String correo;
    private final String contrasenia;
    private final Date fechaNacimiento;
}
