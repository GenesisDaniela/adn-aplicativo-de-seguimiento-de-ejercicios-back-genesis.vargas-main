package com.ceiba.usuario;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioTest {
    @Test
    void deberiaReconstruirUsuarioExitosamente() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        var usuario = new UsuarioTestDataBuilder()
                .conNombre("Genesis")
                .conContrasenia("0123456789")
                .conCorreo("genesis@gmail.com")
                .conFechaNacimiento(fecha_nac)
                .conPeso((float)64)
                .reconstruir();

        Assertions.assertEquals("Genesis", usuario.getNombre());
        Assertions.assertEquals("0123456789", usuario.getContrasenia());
        Assertions.assertEquals("genesis@gmail.com", usuario.getCorreo());
        Assertions.assertEquals(fecha_nac, usuario.getFechaNacimiento());
        Assertions.assertEquals((float)64, usuario.getPeso());
    }

    @Test
    void reconstruirUsuarioMenorQuinceAniosDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2021");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionValorInvalido.class,
                "Solo puede registrarse si tiene más de 15 años");

    }

    @Test
    void reconstruirUsuarioSinCorreoDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionValorObligatorio.class,
                "El correo es requerido");

    }

    @Test
    void reconstruirUsuarioSinContraseniaDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionValorObligatorio.class,
                "la contraseña es requerido");

    }

    @Test
    void reconstruirUsuarioSinNombreDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conContrasenia("0123456789")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionValorObligatorio.class,
                "El nombre del usuario es requerido");

    }

    @Test
    void reconstruirUsuarioSinFechaNacimientoDeberiaLanzarError()  {
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conCorreo("genesis@gmail.com")
                        .conPeso((float)64).reconstruir(), ExcepcionValorObligatorio.class,
                "La fecha de nacimiento es requerida");

    }

    @Test
    void reconstruirUsuarioSinPesoDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "El peso es requerido");
    }

    @Test
    void reconstruirUsuarioPesoNegativoDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)-64).reconstruir(), ExcepcionValorInvalido.class,
                "El peso debe ser un valor positivo");
    }

    @Test
    void reconstruirUsuarioCorreoElectronicoSinFormatoDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("0123456789")
                        .conCorreo("genesiss")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionValorInvalido.class,
                "El correo no tiene un formato correcto");
    }

    @Test
    void reconstruirUsuarioContraseniaMenosDeDiezCaracteresDeberiaLanzarError() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_nac = formato.parse("23/11/2001");
        BasePrueba.assertThrows(() -> new UsuarioTestDataBuilder()
                        .conNombre("Genesis")
                        .conContrasenia("345")
                        .conCorreo("genesis@gmail.com")
                        .conFechaNacimiento(fecha_nac)
                        .conPeso((float)64).reconstruir(), ExcepcionLongitudValor.class,
                "la contraseña debe tener minimo 10 caracteres de longitud");
    }

}
