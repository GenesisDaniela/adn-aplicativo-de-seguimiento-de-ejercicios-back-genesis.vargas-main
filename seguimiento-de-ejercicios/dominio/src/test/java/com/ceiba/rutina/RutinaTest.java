package com.ceiba.rutina;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class RutinaTest {
    @Test
    void deberiaReconstruirRutinaExitosamente() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        var usuario = new UsuarioTestDataBuilder()
                .conNombre("Genesis")
                .conContrasenia("0123456789")
                .conCorreo("genesis@gmail.com")
                .conFechaNacimiento(fecha_nac)
                .conPeso((float)64)
                .reconstruir();

        var rutina = new RutinaTestDataBuilder()
                .conUsuarioPorDefecto()
                .conObjetivo("Ganar masa muscular")
                .conDescripcion("Llegar a la hipertrofia")
                .reconstruir();

        Assertions.assertEquals("Ganar masa muscular", rutina.getObjetivo());
        Assertions.assertEquals("Llegar a la hipertrofia", rutina.getDescripcion());
        Assertions.assertEquals(usuario, rutina.getUsuario());
    }

    @Test
    void reconstruirRutinaSinUsuarioDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new RutinaTestDataBuilder()
                        .conObjetivo("Ganar masa muscular")
                        .conDescripcion("Llegar a la hipertrofia")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "Usuario no encontrado o vacio");
    }

    @Test
    void reconstruirRutinaSinDescripcionDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new RutinaTestDataBuilder()
                        .conObjetivo("Ganar masa muscular")
                        .conUsuarioPorDefecto()
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "La descripcion no puede estar vacia");
    }

    @Test
    void reconstruirRutinaSinObjetivoDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new RutinaTestDataBuilder()
                        .conUsuarioPorDefecto()
                        .conDescripcion("Llegar a la hipertrofia")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "Debes proporcionar un objetivo");
    }
}
