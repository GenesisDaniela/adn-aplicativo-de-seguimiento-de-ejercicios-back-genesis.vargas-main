package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.consulta.ConsultaSolicitudIniciarSesion;
import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;
import com.ceiba.usuario.servicio.ServicioIniciarSesion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorIniciarSesion   {

    ServicioIniciarSesion servicioIniciarSesion;

    public ManejadorIniciarSesion(ServicioIniciarSesion servicioIniciarSesion) {
        this.servicioIniciarSesion = servicioIniciarSesion;
    }

    public ComandoRespuesta<String> ejecutar(ConsultaSolicitudIniciarSesion solicitudIniciarSesion) {
        var usuario = servicioIniciarSesion.ejecutar(
                new SolicitudIniciarSesion(solicitudIniciarSesion.getCorreo(), solicitudIniciarSesion.getContrasenia())
        );

        return new ComandoRespuesta<>(usuario);
    }
}
