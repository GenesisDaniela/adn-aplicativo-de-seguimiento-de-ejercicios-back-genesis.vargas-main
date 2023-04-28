package com.ceiba.usuario.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class SolicitudIniciarSesion {
    private final String correo;
    private final String contrasenia;
}

