package com.ceiba.plan.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearPlan {
    Integer peso;
    Integer repeticiones;
    Integer series;
    Long rutina;
    Long ejercicio;
}
