package com.ceiba.rutina.controlador;

import com.ceiba.rutina.comando.ComandoSolicitudCrearRutina;

public class ComandoCrearRutinaTestDataBuilder {
    private String descripcion;
    private String objetivo;
    private Integer usuario;

    public ComandoCrearRutinaTestDataBuilder crearPorDefecto(){
        this.descripcion = "Rutina cardiovascular";
        this.objetivo = "Un corazón más saludable";
        this.usuario = 1;
        return this;
    }

    public ComandoSolicitudCrearRutina build(){
        return new ComandoSolicitudCrearRutina(descripcion, objetivo, usuario);
    }
}
