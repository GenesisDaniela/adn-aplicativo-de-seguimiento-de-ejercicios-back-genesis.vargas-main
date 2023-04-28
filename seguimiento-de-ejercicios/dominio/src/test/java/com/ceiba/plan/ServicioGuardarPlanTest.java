package com.ceiba.plan;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.plan.puerto.dao.DaoPlan;
import com.ceiba.plan.servicio.ServicioCrearPlan;
import com.ceiba.rutina.RutinaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class ServicioGuardarPlanTest {
    @Test
    void deberiaGuardarPlan() throws ParseException {
        var repositorioPlan = Mockito.mock(RepositorioPlan.class);
        Mockito.when(repositorioPlan.guardarPlan(Mockito.any()))
                .thenReturn(1L);
        var daoPlan = Mockito.mock(DaoPlan.class);
        List<Plan> planes = new ArrayList<>();
        Mockito.when(daoPlan.listarPlanesDeRutina(Mockito.any()))
                .thenReturn(planes);
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");

        var solicitudCrearPlan = new SolicitudCrearPlanTestDataBuilder().
                conPeso(84).
                conRepeticiones(10).
                conSeries(15).
                conEjercicio(ejercicio).conRutina(rutina).build();


        var servicioCrearPlan =new ServicioCrearPlan(repositorioPlan, daoPlan);
        var idPlan=servicioCrearPlan.ejecutar(solicitudCrearPlan);

        ArgumentCaptor<Plan> captorRutina = ArgumentCaptor.forClass(Plan.class);

        Mockito.verify(repositorioPlan, Mockito.times(1)).guardarPlan(
                captorRutina.capture());

        Assertions.assertEquals(84, captorRutina.getValue().getPeso());
        Assertions.assertEquals(10, captorRutina.getValue().getRepeticiones());
        Assertions.assertEquals(15, captorRutina.getValue().getSeries());
        Assertions.assertEquals(rutina, captorRutina.getValue().getRutina());
        Assertions.assertEquals(ejercicio, captorRutina.getValue().getEjercicio());
        Assertions.assertEquals(1L, idPlan);
    }

    @Test
    void noDeberiaGuardarPlan() throws ParseException{
        var repositorioPlan = Mockito.mock(RepositorioPlan.class);
        Mockito.when(repositorioPlan.guardarPlan(Mockito.any()))
                .thenReturn(1L);
        var daoPlan = Mockito.mock(DaoPlan.class);
        List<Plan> planes = new ArrayList<>();


        Mockito.when(daoPlan.listarPlanesDeRutina(Mockito.any()))
                .thenReturn(planes);
        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        var ejercicio = Ejercicio.reconstruir(1L,"Prensa","Tren superior");

        var solicitudCrearPlan = new SolicitudCrearPlanTestDataBuilder().
                conPeso(84).
                conRepeticiones(10).
                conSeries(15).
                conEjercicio(ejercicio).conRutina(rutina).build();
        planes.add(Plan.reconstruir(2L, rutina, ejercicio, 20, 4, 15));
        planes.add(Plan.reconstruir(3L, rutina, ejercicio, 20, 4, 15));
        planes.add(Plan.reconstruir(4L, rutina, ejercicio, 20, 4, 15));
        planes.add(Plan.reconstruir(5L, rutina, ejercicio, 20, 4, 15));
        planes.add(Plan.reconstruir(6L, rutina, ejercicio, 20, 4, 15));
        planes.add(Plan.reconstruir(7L, rutina, ejercicio, 20, 4, 15));

        var servicioCrearPlan =new ServicioCrearPlan(repositorioPlan, daoPlan);
        BasePrueba.assertThrows(() -> servicioCrearPlan.ejecutar(solicitudCrearPlan)
                        , ExcepcionValorInvalido.class,
                "El usuario no puede tener más de seis planes");
    }
}
