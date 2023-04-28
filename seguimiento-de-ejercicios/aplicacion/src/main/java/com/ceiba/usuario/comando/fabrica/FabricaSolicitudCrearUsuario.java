package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoSolicitudCrearUsuario;
import com.ceiba.usuario.modelo.entidad.SolicitudCrearUsuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudCrearUsuario {
    public SolicitudCrearUsuario crear(ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario){
        return new SolicitudCrearUsuario(comandoSolicitudCrearUsuario.getNombre(),
                comandoSolicitudCrearUsuario.getPeso(), comandoSolicitudCrearUsuario.getCorreo(),
                comandoSolicitudCrearUsuario.getContrasenia(),
                comandoSolicitudCrearUsuario.getFechaNacimiento());
    }
}
