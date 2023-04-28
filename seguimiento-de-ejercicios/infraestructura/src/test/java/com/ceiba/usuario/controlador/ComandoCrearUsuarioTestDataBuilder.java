package com.ceiba.usuario.controlador;

import com.ceiba.usuario.comando.ComandoSolicitudCrearUsuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComandoCrearUsuarioTestDataBuilder {

    private String nombre;
    private Float peso;
    private String correo;
    private  String contrasenia;
    private Date fechaNacimiento;

    public ComandoCrearUsuarioTestDataBuilder crearPorDefecto() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = formato.parse("23/11/2001");
        this.nombre ="Genesis";
        this.peso =64f;
        this.correo ="Genesis@gmail.com";
        this.contrasenia ="1234567898";
        this.fechaNacimiento =fechaNacimiento;
        return this;
    }

    public ComandoSolicitudCrearUsuario build() {
        return new ComandoSolicitudCrearUsuario(nombre, peso,correo,contrasenia,fechaNacimiento);
    }
}
