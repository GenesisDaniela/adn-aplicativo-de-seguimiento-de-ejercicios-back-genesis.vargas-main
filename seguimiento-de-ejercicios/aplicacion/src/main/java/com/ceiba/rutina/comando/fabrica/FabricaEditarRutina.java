package com.ceiba.rutina.comando.fabrica;

import com.ceiba.rutina.modelo.entidad.SolicitudEditarRutina;
import com.ceiba.rutina.comando.ComandoSolicitudEditarRutina;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaEditarRutina {
    private final RepositorioUsuario repositorioUsuario;

    public FabricaEditarRutina(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public SolicitudEditarRutina editar(ComandoSolicitudEditarRutina comandoSolicitudEditarRutina){
        return new SolicitudEditarRutina(comandoSolicitudEditarRutina.getIdRutina(),comandoSolicitudEditarRutina.getDescripcion(),
                comandoSolicitudEditarRutina.getObjetivo(),
                repositorioUsuario.obtenerUsuario(comandoSolicitudEditarRutina.getIdUsuario())
        );
    }
}
