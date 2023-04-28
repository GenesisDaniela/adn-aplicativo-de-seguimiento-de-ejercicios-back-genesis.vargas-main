package com.ceiba.rutina;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.rutina.servicio.ServicioCrearRutina;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ServicioGuardarRutinaTest {
    @Test
    void deberiaGuardarRutina() throws ParseException {
        var repositorioRutina = Mockito.mock(RepositorioRutina.class);
        Mockito.when(repositorioRutina.guardarRutina(Mockito.any()))
                .thenReturn(1L);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        var usuario =
         new UsuarioTestDataBuilder()
                .conNombre("Genesis")
                .conContrasenia("0123456789")
                .conCorreo("genesis@gmail.com")
                .conFechaNacimiento(fecha_nac)
                .conPeso((float)64)
                .reconstruir();

        var solicitudCrearRutina = new SolicitudCrearRutinaTestDataBuilder().
                conObjetivo("Bajar de peso").
                conDescripcion("Meta personal").
                conUsuarioPorDefecto().
                build();


        var servicioCrearRutina =new ServicioCrearRutina(repositorioRutina);
        var idRutina=servicioCrearRutina.ejecutar(solicitudCrearRutina);

        ArgumentCaptor<Rutina> captorRutina = ArgumentCaptor.forClass(Rutina.class);

        Mockito.verify(repositorioRutina, Mockito.times(1)).guardarRutina(
                captorRutina.capture());

        Assertions.assertEquals("Meta personal", captorRutina.getValue().getDescripcion());
        Assertions.assertEquals("Bajar de peso", captorRutina.getValue().getObjetivo());
        Assertions.assertEquals(usuario, captorRutina.getValue().getUsuario());
        Assertions.assertEquals(1L, idRutina);
    }
}
