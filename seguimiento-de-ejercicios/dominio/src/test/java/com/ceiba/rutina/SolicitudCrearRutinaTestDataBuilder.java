package com.ceiba.rutina;

import com.ceiba.rutina.modelo.entidad.SolicitudCrearRutina;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolicitudCrearRutinaTestDataBuilder {
    private String descripcion;
    private String objetivo;
    private Usuario usuario;

    public SolicitudCrearRutinaTestDataBuilder(String descripcion, String objetivo, Usuario usuario) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.usuario = usuario;
    }
    public SolicitudCrearRutinaTestDataBuilder(){}
    public SolicitudCrearRutinaTestDataBuilder conDescripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }

    public SolicitudCrearRutinaTestDataBuilder conObjetivo(String objetivo){
        this.objetivo=objetivo;
        return this;
    }

    public SolicitudCrearRutinaTestDataBuilder conUsuarioPorDefecto(){
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_nac = formato.parse("23/11/2001");
            this.usuario = new UsuarioTestDataBuilder()
                    .conNombre("Genesis")
                    .conContrasenia("0123456789")
                    .conCorreo("genesis@gmail.com")
                    .conFechaNacimiento(fecha_nac)
                    .conPeso((float)64)
                    .reconstruir();
        } catch (ParseException e){
            throw new RuntimeException("Formato de fecha incorrecto");
        }
        return this;
    }

    public SolicitudCrearRutina build(){
        return new SolicitudCrearRutina(this.descripcion,this.objetivo,this.usuario);
    }
}
