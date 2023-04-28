package com.ceiba.rutina.modelo.dto;

import com.ceiba.plan.entidad.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RutinaDTO {
    private final Long idRutina;
    private final String descripcion;
    private final String objetivo;
    private final List<Plan> planes;

}
