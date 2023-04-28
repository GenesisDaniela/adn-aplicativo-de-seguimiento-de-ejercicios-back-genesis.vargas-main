package com.ceiba.rutina.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.modelo.entidad.SolicitudCrearRutina;
import com.ceiba.rutina.puerto.RepositorioRutina;

public class ServicioObtenerRutina {
    private final RepositorioRutina repositorioRutina;

    public ServicioObtenerRutina(RepositorioRutina repositorioRutina) {
        this.repositorioRutina = repositorioRutina;
    }

    public Long ejecutar(Long idRutina){
        ValidadorArgumento.validarObligatorio(idRutina,"Debe proporcionar el id de la rutina");
        var rutina =repositorioRutina.obtenerRutina(idRutina);
        ValidadorArgumento.validarObligatorio(rutina,"rutina no encontrada");
        return rutina.getId();
    }

}
