package com.ceiba.usuario;

import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioIniciarSesion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServicioIniciarSesionTest {
    @Test
    void deberiaIniciarSesion() throws ParseException {
        var daoUsuario = Mockito.mock(DaoUsuario.class);
        Mockito.when(daoUsuario.obtenerUsuarioPorcorreoContrasenia(Mockito.any(),Mockito.any()))
                .thenReturn(new InicioSesionDTO("genesis@gmail.com","1234567865"));

        var solicitudIniciarSesion = new SolicitudIniciarSesionTestDataBuilder()
                .conCorreo("genesis@gmail.com")
                .conContrasenia("1234567865").build();

        var servicioIniciarSesion =new ServicioIniciarSesion(daoUsuario);
        var correo_usuario=servicioIniciarSesion.ejecutar(solicitudIniciarSesion);


        ArgumentCaptor<String> captorUsuario = ArgumentCaptor.forClass(
                String.class);

        Mockito.verify(daoUsuario, Mockito.times(1)).
                obtenerUsuarioPorcorreoContrasenia(
                captorUsuario.capture(), captorUsuario.capture());

        List<String> correoYContrasenia = captorUsuario.getAllValues();
        Assertions.assertEquals("genesis@gmail.com", correo_usuario);
        Assertions.assertEquals("genesis@gmail.com", correoYContrasenia.get(0));
        Assertions.assertEquals("1234567865", correoYContrasenia.get(1));
    }
}
