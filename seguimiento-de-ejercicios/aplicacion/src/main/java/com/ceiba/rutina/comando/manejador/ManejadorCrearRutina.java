package com.ceiba.rutina.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.rutina.servicio.ServicioCrearRutina;
import com.ceiba.rutina.comando.ComandoSolicitudCrearRutina;
import com.ceiba.rutina.comando.fabrica.FabricaSolicitudCrearRutina;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRutina implements ManejadorComandoRespuesta<ComandoSolicitudCrearRutina, ComandoRespuesta<Long>> {
    ServicioCrearRutina servicioCrearRutina;
    FabricaSolicitudCrearRutina fabricaSolicitudCrearRutina;

    public ManejadorCrearRutina(ServicioCrearRutina servicioCrearRutina, FabricaSolicitudCrearRutina fabricaSolicitudCrearRutina) {
        this.servicioCrearRutina = servicioCrearRutina;
        this.fabricaSolicitudCrearRutina = fabricaSolicitudCrearRutina;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearRutina comandoSolicitudCrearRutina){
        return new ComandoRespuesta<>(servicioCrearRutina.ejecutar(
                fabricaSolicitudCrearRutina.crear(comandoSolicitudCrearRutina)));
    }
}
