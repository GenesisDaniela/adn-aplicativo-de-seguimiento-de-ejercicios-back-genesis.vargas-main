package com.ceiba.plan.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.entidad.SolicitudCrearPlan;
import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.plan.puerto.dao.DaoPlan;

import java.util.List;


public class ServicioCrearPlan {
    private final RepositorioPlan repositorioPlan;
    private final DaoPlan daoPlan;

    public ServicioCrearPlan(RepositorioPlan repositorioPlan,DaoPlan daoPlan) {
        this.repositorioPlan = repositorioPlan;
        this.daoPlan = daoPlan;
    }

    public Long ejecutar(SolicitudCrearPlan solicitudCrearPlan) {
        List<Plan> planes = this.daoPlan.listarPlanesDeRutina(solicitudCrearPlan.getRutina().getId());
        ValidadorArgumento.validarMenor((long)(planes.size()), 5L, "El usuario no puede tener más de seis planes");
        return repositorioPlan.guardarPlan(Plan.crear(solicitudCrearPlan));
    }

}
