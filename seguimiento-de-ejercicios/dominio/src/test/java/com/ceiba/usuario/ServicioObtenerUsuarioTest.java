package com.ceiba.usuario;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.servicio.ServicioObtenerUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServicioObtenerUsuarioTest {
    @Test
    void deberiaObtenerUsuario() throws ParseException {
        var daoUsuario = Mockito.mock(DaoUsuario.class);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");

        Mockito.when(daoUsuario.obtenerUsuario(Mockito.any()))
                .thenReturn(Usuario.reconstruir(1L,"genesis", 64f, fecha_nac,
                        "genesis@gmail.com","1234567432"));

        var servicioObtenerUsuario =new ServicioObtenerUsuario(daoUsuario);
        var usuario=servicioObtenerUsuario.ejecutar(1L);


        ArgumentCaptor<Long> captorUsuario = ArgumentCaptor.forClass(
                Long.class);

        Mockito.verify(daoUsuario, Mockito.times(1)).
                obtenerUsuario(
                        captorUsuario.capture());

        Assertions.assertEquals(1L, captorUsuario.getValue());
        Assertions.assertEquals("1234567432", usuario.getContrasenia());
        Assertions.assertEquals("genesis",usuario.getNombre());
        Assertions.assertEquals(64f, usuario.getPeso());
        Assertions.assertEquals(fecha_nac, usuario.getFechaNacimiento());
        Assertions.assertEquals("genesis@gmail.com", usuario.getCorreo());



    }
}
