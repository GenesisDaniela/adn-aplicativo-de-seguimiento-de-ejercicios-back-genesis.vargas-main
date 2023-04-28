package com.ceiba.rutina.comando.fabrica;

import com.ceiba.rutina.modelo.entidad.SolicitudCrearRutina;
import com.ceiba.rutina.comando.ComandoSolicitudCrearRutina;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudCrearRutina {
    private final RepositorioUsuario repositorioUsuario;

    public FabricaSolicitudCrearRutina(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public SolicitudCrearRutina crear(ComandoSolicitudCrearRutina comandoSolicitudCrearRutina){
        return new SolicitudCrearRutina(comandoSolicitudCrearRutina.getDescripcion(),
                comandoSolicitudCrearRutina.getObjetivo(),
                repositorioUsuario.obtenerUsuario(comandoSolicitudCrearRutina.getIdUsuario())
               );
    }
}
