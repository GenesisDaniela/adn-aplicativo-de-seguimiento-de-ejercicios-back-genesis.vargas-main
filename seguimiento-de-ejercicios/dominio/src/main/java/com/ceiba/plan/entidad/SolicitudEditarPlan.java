package com.ceiba.plan.entidad;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.rutina.modelo.entidad.Rutina;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SolicitudEditarPlan {
    private final Long idPlan;
    private final Integer peso;
    private final Integer series;
    private final Integer repeticiones;
    private final Ejercicio ejercicio;
    private final Rutina rutina;
}
