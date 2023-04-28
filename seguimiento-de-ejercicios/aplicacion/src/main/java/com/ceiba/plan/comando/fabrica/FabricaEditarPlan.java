package com.ceiba.plan.comando.fabrica;

import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import com.ceiba.plan.entidad.SolicitudEditarPlan;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.plan.comando.ComandoSolicitudEditarPlan;
import org.springframework.stereotype.Component;

@Component
public class FabricaEditarPlan {
    private final RepositorioRutina repositorioRutina;
    private final DaoEjercicio daoEjercicio;

    public FabricaEditarPlan(RepositorioRutina repositorioRutina, DaoEjercicio daoEjercicio) {
        this.repositorioRutina = repositorioRutina;
        this.daoEjercicio = daoEjercicio;
    }

    public SolicitudEditarPlan editar(ComandoSolicitudEditarPlan comandoSolicitudEditarPlan){
        return new SolicitudEditarPlan(comandoSolicitudEditarPlan.getIdPlan(),comandoSolicitudEditarPlan.getPeso(),
                comandoSolicitudEditarPlan.getSeries(), comandoSolicitudEditarPlan.getRepeticiones(),
                daoEjercicio.obtenerEjercicio(comandoSolicitudEditarPlan.getEjercicio()), repositorioRutina.obtenerRutina(comandoSolicitudEditarPlan.getRutina()));
    }
}
