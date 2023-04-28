package com.ceiba.rutina;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.rutina.servicio.ServicioCrearRutina;
import com.ceiba.rutina.servicio.ServicioObtenerRutina;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioObtenerRutinaTest {
    @Test
    void deberiaObtenerRutina() throws ParseException {
        var repositorioRutina = Mockito.mock(RepositorioRutina.class);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        var usuario = new UsuarioTestDataBuilder()
                .conNombre("Genesis")
                .conContrasenia("0123456789")
                .conCorreo("genesis@gmail.com")
                .conFechaNacimiento(fecha_nac)
                .conPeso((float)64)
                .reconstruir();

        Mockito.when(repositorioRutina.obtenerRutina(Mockito.any()))
                .thenReturn(Rutina.reconstruir(1L,"Rutina 1",
                        "Objetivo 1",usuario ));

        var servicioObtenerRutina =new ServicioObtenerRutina(repositorioRutina);
        var idRutina=servicioObtenerRutina.ejecutar(1L);

        ArgumentCaptor<Long> captorRutina = ArgumentCaptor.forClass(Long.class);

        Mockito.verify(repositorioRutina, Mockito.times(1)).obtenerRutina(
                captorRutina.capture());

        Assertions.assertEquals(1L, captorRutina.getValue());
        Assertions.assertEquals(1L, idRutina);
    }
}
