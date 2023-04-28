package com.ceiba.plan;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.plan.entidad.SolicitudEditarPlan;
import com.ceiba.rutina.modelo.entidad.Rutina;

public class SolicitudEditarPlanTestDataBuilder {
    private Integer peso;

    private Long id_plan;

    private Integer series;
    private Integer repeticiones;
    private Ejercicio ejercicio;
    private Rutina rutina;

    public SolicitudEditarPlanTestDataBuilder conPeso(int peso){
        this.peso=peso;
        return this;
    }
    public SolicitudEditarPlanTestDataBuilder conSeries(int series){
        this.series=series;
        return this;
    }
    public SolicitudEditarPlanTestDataBuilder conRepeticiones(int repeticiones){
        this.repeticiones=repeticiones;
        return this;
    }
    public SolicitudEditarPlanTestDataBuilder conEjercicio(Ejercicio ejercicio){
        this.ejercicio=ejercicio;
        return this;
    }
    public SolicitudEditarPlanTestDataBuilder conRutina(Rutina rutina){
        this.rutina=rutina;
        return this;
    }

    public SolicitudEditarPlanTestDataBuilder conId(Long id_plan){
        this.id_plan=id_plan;
        return this;
    }

    public SolicitudEditarPlan build(){
        return new SolicitudEditarPlan(this.id_plan,this.peso,this.series,this.repeticiones,this.ejercicio,this.rutina);
    }
}
