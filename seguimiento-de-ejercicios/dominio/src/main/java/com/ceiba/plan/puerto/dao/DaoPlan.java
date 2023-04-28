package com.ceiba.plan.puerto.dao;

import com.ceiba.plan.entidad.Plan;

import java.util.List;

public interface DaoPlan {

    public List<Plan> listarPlanesDeRutina(Long idRutina);

}
