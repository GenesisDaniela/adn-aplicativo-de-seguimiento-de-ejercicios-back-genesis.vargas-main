package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoSolicitudCrearUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaSolicitudCrearUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

@Component

public class ManejadorCrearUsuario  implements ManejadorComandoRespuesta<ComandoSolicitudCrearUsuario, ComandoRespuesta<Long>> {

    RepositorioUsuario repositorioUsuario;

    FabricaSolicitudCrearUsuario fabricaSolicitudCrearUsuario;

    ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(RepositorioUsuario repositorioUsuario,
                                 FabricaSolicitudCrearUsuario fabricaSolicitudCrearUsuario,
                                 ServicioCrearUsuario servicioCrearUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.fabricaSolicitudCrearUsuario = fabricaSolicitudCrearUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario) {
        return new ComandoRespuesta<>(servicioCrearUsuario.ejecutar(
                fabricaSolicitudCrearUsuario.crear(comandoSolicitudCrearUsuario)
        ));
    }
}
