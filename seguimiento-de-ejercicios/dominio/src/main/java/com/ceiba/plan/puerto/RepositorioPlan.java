package com.ceiba.plan.puerto;

import com.ceiba.plan.entidad.Plan;

import java.util.List;

public interface RepositorioPlan {
    Long guardarPlan(Plan plan);
    Plan obtenerPlan(Long id);
    List<Plan> listarPlan();
    Integer editarPlan(Plan plan, Long idPlan);
}
