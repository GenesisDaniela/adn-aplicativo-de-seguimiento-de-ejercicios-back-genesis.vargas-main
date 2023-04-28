package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioObtenerUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerUsuario implements ManejadorComandoRespuesta<Long, ComandoRespuesta<Usuario>> {
    ServicioObtenerUsuario servicioObtenerUsuario;

    public ManejadorObtenerUsuario(ServicioObtenerUsuario servicioObtenerUsuario) {
        this.servicioObtenerUsuario = servicioObtenerUsuario;
    }

    @Override
    public ComandoRespuesta<Usuario> ejecutar(Long idusuario) {
        return new ComandoRespuesta<>(servicioObtenerUsuario.ejecutar(idusuario));
    }
}
