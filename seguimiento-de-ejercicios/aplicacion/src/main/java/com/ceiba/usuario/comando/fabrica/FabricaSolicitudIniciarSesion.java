package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.consulta.ConsultaSolicitudIniciarSesion;
import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudIniciarSesion {

    public SolicitudIniciarSesion crear(ConsultaSolicitudIniciarSesion consultaSolicitudIniciarSesion) {
        return new SolicitudIniciarSesion(consultaSolicitudIniciarSesion.getCorreo(),
                consultaSolicitudIniciarSesion.getContrasenia());
    }

}
