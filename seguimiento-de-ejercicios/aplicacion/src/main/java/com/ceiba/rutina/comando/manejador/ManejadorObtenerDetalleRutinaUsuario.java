package com.ceiba.rutina.comando.manejador;

import com.ceiba.rutina.modelo.dto.RutinaDTO;
import com.ceiba.rutina.servicio.ServicioObtenerRutina;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.servicio.ServicioObtenerUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerDetalleRutinaUsuario {
    private final DaoUsuario daoUsuario;
    private final ServicioObtenerUsuario servicioObtenerUsuario;
    private final ServicioObtenerRutina servicioObtenerRutina;

    public ManejadorObtenerDetalleRutinaUsuario(DaoUsuario daoUsuario, ServicioObtenerUsuario servicioObtenerUsuario, ServicioObtenerRutina servicioObtenerRutina) {
        this.daoUsuario = daoUsuario;
        this.servicioObtenerUsuario = servicioObtenerUsuario;
        this.servicioObtenerRutina = servicioObtenerRutina;
    }

    public RutinaDTO ejecutar(Long idUsuario, Long idRutina){
        servicioObtenerUsuario.ejecutar(idUsuario);
        servicioObtenerRutina.ejecutar(idRutina);
        return daoUsuario.obtenerDetalleRutinaUsuario(idUsuario,idRutina);
    }
}
