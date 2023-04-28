package com.ceiba.usuario;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioCrearUsuarioTest {
    @Test
    void deberiaGuardarUsuario() throws ParseException {
        var repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.guardarUsuario(Mockito.any())).thenReturn(1L);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");

        var solicitudCrearUsuario = new SolicitudCrearUsuarioTestDataBuilder().
                conNombre("Genesis")
                .conContrasenia("1234567865")
                .conCorreo("genesis@gmail.com")
                .conFechaNacimiento(fecha_nac)
                .conPeso((float)64).build();


        var servicioCrearUsuario =new ServicioCrearUsuario(repositorioUsuario);
        var id_usuario=servicioCrearUsuario.ejecutar(solicitudCrearUsuario);
        
        ArgumentCaptor<Usuario> captorUsuario = ArgumentCaptor.forClass(Usuario.class);

        Mockito.verify(repositorioUsuario, Mockito.times(1)).guardarUsuario(
                captorUsuario.capture());

        Assertions.assertEquals("Genesis", captorUsuario.getValue().getNombre());
        Assertions.assertEquals("1234567865", captorUsuario.getValue().getContrasenia());
        Assertions.assertEquals("genesis@gmail.com", captorUsuario.getValue().getCorreo());
        Assertions.assertEquals(fecha_nac, captorUsuario.getValue().getFechaNacimiento());
        Assertions.assertEquals((float)64, captorUsuario.getValue().getPeso());
        Assertions.assertEquals(1L, id_usuario);
    }
}
