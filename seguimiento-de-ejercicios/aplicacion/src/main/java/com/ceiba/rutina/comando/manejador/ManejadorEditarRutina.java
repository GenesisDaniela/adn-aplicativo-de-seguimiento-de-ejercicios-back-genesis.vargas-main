package com.ceiba.rutina.comando.manejador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rutina.servicio.ServicioEditarRutina;
import com.ceiba.rutina.comando.ComandoSolicitudEditarRutina;
import com.ceiba.rutina.comando.fabrica.FabricaEditarRutina;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEditarRutina implements ManejadorComandoRespuesta<ComandoSolicitudEditarRutina, ComandoRespuesta<Long>> {
    ServicioEditarRutina servicioEditarRutina;
    FabricaEditarRutina fabricaEditarRutina;

    public ManejadorEditarRutina(ServicioEditarRutina servicioEditarRutina, FabricaEditarRutina fabricaEditarRutina) {
        this.servicioEditarRutina = servicioEditarRutina;
        this.fabricaEditarRutina = fabricaEditarRutina;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudEditarRutina comandoSolicitudEditarRutina) {
        servicioEditarRutina.ejecutar(fabricaEditarRutina.editar(comandoSolicitudEditarRutina));
        return new ComandoRespuesta<>(comandoSolicitudEditarRutina.getIdRutina());
    }
}
