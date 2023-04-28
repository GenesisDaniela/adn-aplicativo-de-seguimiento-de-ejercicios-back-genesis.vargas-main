package com.ceiba.plan;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.rutina.RutinaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class PlanTest {
    @Test
    void deberiaReconstruirPlanExitosamente() throws ParseException {
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");

        var plan = new PlanTestDataBuilder()
                .conPeso(10).
                conRepeticiones(35).conSeries(20).
                conEjercicio(ejercicio).
                conRutina(rutina).
                reconstruir();

        Assertions.assertEquals(10, plan.getPeso());
        Assertions.assertEquals(35, plan.getRepeticiones());
        Assertions.assertEquals(20, plan.getSeries());
        Assertions.assertEquals(rutina, plan.getRutina());
        Assertions.assertEquals(ejercicio, plan.getEjercicio());
    }

    @Test
    void reconstruirPlanSinPesoDeberiaLanzarError(){
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();
        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");

        BasePrueba.assertThrows(() -> new PlanTestDataBuilder().
                        conRepeticiones(35).conSeries(20).
                        conEjercicio(ejercicio).
                        conRutina(rutina).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "el peso es requerido");
    }

    @Test
    void reconstruirPlanSinRepeticionesDeberiaLanzarError(){
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();
        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");
        BasePrueba.assertThrows(() -> new PlanTestDataBuilder()
                        .conPeso(10).
                        conSeries(20).
                        conEjercicio(ejercicio).
                        conRutina(rutina).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "las repeticiones son requeridas");
    }

    @Test
    void reconstruirPlanSinSeriesDeberiaLanzarError(){
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();
        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");
        BasePrueba.assertThrows(() -> new PlanTestDataBuilder()
                        .conPeso(10).
                        conRepeticiones(35).
                        conEjercicio(ejercicio).
                        conRutina(rutina).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "las series son requeridas");
    }

    @Test
    void reconstruirPlanSinEjercicioDeberiaLanzarError(){
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        BasePrueba.assertThrows(() -> new PlanTestDataBuilder()
                .conPeso(10).
                conRepeticiones(35).conSeries(20).
                conRutina(rutina).
                reconstruir(), ExcepcionValorObligatorio.class,
                "el ejercicio es requerido");
    }
    @Test
    void reconstruirPlanSinRutinaDeberiaLanzarError(){
        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");
        BasePrueba.assertThrows(() -> new PlanTestDataBuilder()
                        .conPeso(10).
                        conRepeticiones(35).conSeries(20).
                        conEjercicio(ejercicio).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "la rutina es requerida");
    }
}
