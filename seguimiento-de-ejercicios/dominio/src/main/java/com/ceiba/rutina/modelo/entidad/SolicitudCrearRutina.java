package com.ceiba.rutina.modelo.entidad;

import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SolicitudCrearRutina {
    private final String descripcion;
    private final String objetivo;
    private final Usuario usuario;
}
