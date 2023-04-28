package com.ceiba.plan.comando.fabrica;

import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import com.ceiba.plan.comando.ComandoSolicitudCrearPlan;
import com.ceiba.plan.entidad.SolicitudCrearPlan;
import com.ceiba.rutina.puerto.RepositorioRutina;
import org.springframework.stereotype.Component;


@Component
public class FabricaSolicitudCrearPlan {

    private final RepositorioRutina repositorioRutina;
    private final DaoEjercicio daoEjercicio;

    public FabricaSolicitudCrearPlan(RepositorioRutina repositorioRutina, DaoEjercicio daoEjercicio) {
        this.repositorioRutina = repositorioRutina;
        this.daoEjercicio = daoEjercicio;
    }

    public SolicitudCrearPlan crear(ComandoSolicitudCrearPlan comandoSolicitudCrearPlan){
        return new SolicitudCrearPlan(comandoSolicitudCrearPlan.getPeso(),
                comandoSolicitudCrearPlan.getSeries(), comandoSolicitudCrearPlan.getRepeticiones(),
                daoEjercicio.obtenerEjercicio(comandoSolicitudCrearPlan.getEjercicio()),
                repositorioRutina.obtenerRutina(comandoSolicitudCrearPlan.getRutina()));
    }
}
