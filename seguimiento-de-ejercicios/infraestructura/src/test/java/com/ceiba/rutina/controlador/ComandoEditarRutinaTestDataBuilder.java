package com.ceiba.rutina.controlador;

import com.ceiba.rutina.comando.ComandoSolicitudEditarRutina;

public class ComandoEditarRutinaTestDataBuilder {
    private Long idRutina;
    private String descripcion;
    private String objetivo;
    private Integer usuario;

    public ComandoEditarRutinaTestDataBuilder crearPorDefecto(){
        this.idRutina = 1L;
        this.descripcion = "Rutina cardiovascular editada";
        this.objetivo = "Un corazón más saludable editada";
        this.usuario = 1;
        return this;
    }

    public ComandoSolicitudEditarRutina build(){
        return new ComandoSolicitudEditarRutina(idRutina,descripcion, objetivo, usuario);
    }
}
