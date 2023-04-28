package com.ceiba.rutina.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudEditarRutina {
    private Long idRutina;
    private  String descripcion;
    private  String objetivo;
    private  Integer idUsuario;
}
