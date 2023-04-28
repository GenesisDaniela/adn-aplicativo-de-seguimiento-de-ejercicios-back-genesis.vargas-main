package com.ceiba.rutina.servicio;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.modelo.entidad.SolicitudCrearRutina;
import com.ceiba.rutina.puerto.RepositorioRutina;

public class ServicioCrearRutina {
    private final RepositorioRutina repositorioRutina;

    public ServicioCrearRutina(RepositorioRutina repositorioRutina) {
        this.repositorioRutina = repositorioRutina;
    }

    public Long ejecutar(SolicitudCrearRutina solicitudCrearRutina){
        return repositorioRutina.guardarRutina(Rutina.crear(solicitudCrearRutina));
    }
}
