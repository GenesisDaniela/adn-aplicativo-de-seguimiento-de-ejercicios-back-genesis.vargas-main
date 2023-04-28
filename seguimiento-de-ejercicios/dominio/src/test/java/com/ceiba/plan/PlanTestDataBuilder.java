package com.ceiba.plan;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.rutina.modelo.entidad.Rutina;

public class PlanTestDataBuilder {
    private Long id;
    private Rutina rutina;
    private Ejercicio ejercicio;
    private Integer peso;
    private Integer series;
    private Integer repeticiones;

    public PlanTestDataBuilder(){}

    public PlanTestDataBuilder conRutina(Rutina rutina){
        this.rutina=rutina;
        return  this;
    }
    public PlanTestDataBuilder conEjercicio(Ejercicio ejercicio){
        this.ejercicio=ejercicio;
        return  this;
    }
    public PlanTestDataBuilder conPeso(Integer peso){
        this.peso=peso;
        return  this;
    }
    public PlanTestDataBuilder conRepeticiones(Integer repeticiones){
        this.repeticiones=repeticiones;
        return  this;
    }

    public PlanTestDataBuilder conSeries(Integer series){
        this.series=series;
        return  this;
    }

    public Plan reconstruir(){
        return Plan.reconstruir(this.id,this.rutina,
                this.ejercicio,this.peso,this.series,this.repeticiones);
    }

}
