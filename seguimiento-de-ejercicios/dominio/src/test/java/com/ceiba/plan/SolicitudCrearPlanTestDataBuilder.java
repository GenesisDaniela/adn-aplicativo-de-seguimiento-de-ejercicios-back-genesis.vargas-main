package com.ceiba.plan;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.plan.entidad.SolicitudCrearPlan;
import com.ceiba.rutina.modelo.entidad.Rutina;

public class SolicitudCrearPlanTestDataBuilder {
    private Integer peso;
    private Integer series;
    private Integer repeticiones;
    private Ejercicio ejercicio;
    private Rutina rutina;

    public SolicitudCrearPlanTestDataBuilder conPeso(int peso){
        this.peso=peso;
        return this;
    }
    public SolicitudCrearPlanTestDataBuilder conSeries(int series){
        this.series=series;
        return this;
    }
    public SolicitudCrearPlanTestDataBuilder conRepeticiones(int repeticiones){
        this.repeticiones=repeticiones;
        return this;
    }
    public SolicitudCrearPlanTestDataBuilder conEjercicio(Ejercicio ejercicio){
        this.ejercicio=ejercicio;
        return this;
    }
    public SolicitudCrearPlanTestDataBuilder conRutina(Rutina rutina){
        this.rutina=rutina;
        return this;
    }

    public SolicitudCrearPlan build(){
        return new SolicitudCrearPlan(this.peso,this.series,this.repeticiones,this.ejercicio,this.rutina);
    }
}
