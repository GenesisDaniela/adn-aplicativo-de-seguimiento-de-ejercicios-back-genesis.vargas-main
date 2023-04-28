package com.ceiba.rutina.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearRutina {
    private  String descripcion;
    private  String objetivo;
    private  Integer idUsuario;
}
