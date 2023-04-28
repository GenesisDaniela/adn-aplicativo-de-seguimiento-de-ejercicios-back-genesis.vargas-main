package com.ceiba.rutina.servicio;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.modelo.entidad.SolicitudEditarRutina;
import com.ceiba.rutina.puerto.RepositorioRutina;

public class ServicioEditarRutina {
    private final RepositorioRutina repositorioRutina;

    public ServicioEditarRutina(RepositorioRutina repositorioRutina) {
        this.repositorioRutina = repositorioRutina;
    }

    public void ejecutar(SolicitudEditarRutina solicitudEditarRutina){
        var rutina = repositorioRutina.obtenerRutina(solicitudEditarRutina.getIdRutina());
        rutina = rutina.editar(solicitudEditarRutina);
        repositorioRutina.editarRutina(rutina, solicitudEditarRutina.getIdRutina());
    }
}
