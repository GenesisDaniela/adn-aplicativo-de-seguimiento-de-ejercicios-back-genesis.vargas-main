package com.ceiba.rutina.comando.manejador;

import com.ceiba.rutina.modelo.dto.ResumenRutinaDTO;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.servicio.ServicioObtenerUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerRutinaDeUsuario{
    private final DaoUsuario daoUsuario;

    private final ServicioObtenerUsuario servicioObtenerUsuario;


    public ManejadorObtenerRutinaDeUsuario(DaoUsuario daoUsuario,
                                           ServicioObtenerUsuario servicioObtenerUsuario) {
        this.daoUsuario = daoUsuario;
        this.servicioObtenerUsuario = servicioObtenerUsuario;
    }

    public List<ResumenRutinaDTO> ejecutar(Long idUsuario){
        servicioObtenerUsuario.ejecutar(idUsuario);
        return daoUsuario.obtenerRutinasUsuario(idUsuario);
    }

}
