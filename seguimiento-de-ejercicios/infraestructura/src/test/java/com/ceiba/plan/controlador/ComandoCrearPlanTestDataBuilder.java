package com.ceiba.plan.controlador;

import com.ceiba.plan.comando.ComandoSolicitudCrearPlan;

import java.text.ParseException;

public class ComandoCrearPlanTestDataBuilder {
    private Long rutina;
    private Long ejercicio;
    private Integer peso;
    private Integer series;
    private Integer repeticiones;

    public ComandoCrearPlanTestDataBuilder crearPorDefecto()  throws ParseException {
        this.rutina = 1L;
        this.ejercicio = 1L;
        this.peso = 64;
        this.series = 4;
        this.repeticiones = 15;
        return this;
    }

    public ComandoCrearPlanTestDataBuilder conRutina(Long rutina){
        this.rutina = rutina;
        return this;
    }

    public ComandoCrearPlanTestDataBuilder conEjercicio(Long ejercicio){
        this.ejercicio = ejercicio;
        return this;
    }

    public ComandoCrearPlanTestDataBuilder conPeso(Integer peso){
        this.peso = peso;
        return this;
    }

    public ComandoCrearPlanTestDataBuilder conSeries(Integer series){
        this.series = series;
        return this;
    }

    public ComandoCrearPlanTestDataBuilder conRepeticiones(Integer repeticiones){
        this.repeticiones = repeticiones;
        return this;
    }

    public ComandoSolicitudCrearPlan build(){
        return new ComandoSolicitudCrearPlan(peso,repeticiones, series, rutina, ejercicio);
    }

}
