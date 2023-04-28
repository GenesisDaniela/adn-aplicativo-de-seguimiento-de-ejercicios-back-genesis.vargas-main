package com.ceiba.plan;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.plan.servicio.ServicioEditarPlan;
import com.ceiba.rutina.RutinaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;

class ServicioEditarPlanTest {
    @Test
    void deberiaEditarPlan() throws ParseException {
        var repositorioPlan = Mockito.mock(RepositorioPlan.class);
        Mockito.when(repositorioPlan.editarPlan(Mockito.any(),Mockito.any() ))
                .thenReturn(1);
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");

        Mockito.when(repositorioPlan.obtenerPlan(Mockito.any()))
                .thenReturn(Plan.crear(new SolicitudCrearPlanTestDataBuilder().
                        conPeso(84).
                        conRepeticiones(10).
                        conSeries(15).
                        conEjercicio(ejercicio).conRutina(rutina).build()));


        var solicitudEditarPlan = new SolicitudEditarPlanTestDataBuilder().
                conPeso(84).
                conId(1L).
                conRepeticiones(10).
                conSeries(15).
                conEjercicio(ejercicio).conRutina(rutina).build();


        var servicioEditarPlan =new ServicioEditarPlan(repositorioPlan);
        var idPlan=servicioEditarPlan.ejecutar(solicitudEditarPlan);

        ArgumentCaptor<Plan> captorPlan = ArgumentCaptor.forClass(Plan.class);
        ArgumentCaptor<Long> captorIdPlan = ArgumentCaptor.forClass(Long.class);

        Mockito.verify(repositorioPlan, Mockito.times(1)).editarPlan(
                captorPlan.capture(),captorIdPlan.capture());

        Assertions.assertEquals(84, captorPlan.getValue().getPeso());
        Assertions.assertEquals(10, captorPlan.getValue().getRepeticiones());
        Assertions.assertEquals(15, captorPlan.getValue().getSeries());
        Assertions.assertEquals(rutina, captorPlan.getValue().getRutina());
        Assertions.assertEquals(ejercicio, captorPlan.getValue().getEjercicio());
        Assertions.assertEquals(1, idPlan);
    }
}
