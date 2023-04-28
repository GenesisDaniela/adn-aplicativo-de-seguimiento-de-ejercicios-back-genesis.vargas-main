package com.ceiba.plan.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudEditarPlan {
    Long idPlan;
    Integer peso;
    Integer repeticiones;
    Integer series;
    Long rutina;
    Long ejercicio;
}
