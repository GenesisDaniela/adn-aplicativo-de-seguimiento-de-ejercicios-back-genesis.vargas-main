package com.ceiba.rutina;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.rutina.servicio.ServicioEditarRutina;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ServicioEditarRutinaTest {
    @Test
    void deberiaEditarRutina() throws ParseException {
        var repositorioRutina = Mockito.mock(RepositorioRutina.class);
        Mockito.when(repositorioRutina.editarRutina(Mockito.any(), Mockito.any()))
                .thenReturn(1);

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
                .thenReturn(Rutina.reconstruir(1L,"Rutina de ejercicio",
                        "Perder peso", usuario));

        var solicitudEditarRutina = new SolicitudEditarRutinaTestDataBuilder().
                conIdRutina(1L).
                conDescripcion("Rutina cambiada").
                conObjetivo("Objetivo cambiado").
                conUsuarioPorDefecto().
                build();


        var servicioEditarRutina =new ServicioEditarRutina(repositorioRutina);
        servicioEditarRutina.ejecutar(solicitudEditarRutina);

        ArgumentCaptor<Rutina> captorRutina = ArgumentCaptor.forClass(Rutina.class);
        ArgumentCaptor<Long> captorIDRutina = ArgumentCaptor.forClass(Long.class);

        Mockito.verify(repositorioRutina, Mockito.times(1)).editarRutina(
                captorRutina.capture(), captorIDRutina.capture());

        Assertions.assertEquals("Rutina cambiada", captorRutina.getValue().getDescripcion());
        Assertions.assertEquals("Objetivo cambiado", captorRutina.getValue().getObjetivo());
        Assertions.assertEquals(usuario, captorRutina.getValue().getUsuario());
    }
}
