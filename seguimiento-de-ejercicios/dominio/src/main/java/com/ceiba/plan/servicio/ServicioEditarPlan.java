package com.ceiba.plan.servicio;

import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.entidad.SolicitudEditarPlan;
import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.modelo.entidad.SolicitudEditarRutina;
import com.ceiba.rutina.puerto.RepositorioRutina;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServicioEditarPlan {

    private final RepositorioPlan repositorioPlan;

    public Integer ejecutar(SolicitudEditarPlan solicitudEditarPlan){
        var rutina = repositorioPlan.obtenerPlan(solicitudEditarPlan.getIdPlan());
        return repositorioPlan.editarPlan(rutina.editar(solicitudEditarPlan),solicitudEditarPlan.getIdPlan());
    }
}
