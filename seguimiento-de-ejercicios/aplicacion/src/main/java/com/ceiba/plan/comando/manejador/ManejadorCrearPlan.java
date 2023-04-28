package com.ceiba.plan.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plan.comando.ComandoSolicitudCrearPlan;
import com.ceiba.plan.comando.fabrica.FabricaSolicitudCrearPlan;
import com.ceiba.plan.servicio.ServicioCrearPlan;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlan implements ManejadorComandoRespuesta<ComandoSolicitudCrearPlan, ComandoRespuesta<Long>> {

    private final ServicioCrearPlan servicioCrearPlan;
    private final FabricaSolicitudCrearPlan fabricaSolicitudCrearPlan;

    public ManejadorCrearPlan(ServicioCrearPlan servicioCrearPlan, FabricaSolicitudCrearPlan fabricaSolicitudCrearPlan) {
        this.servicioCrearPlan = servicioCrearPlan;
        this.fabricaSolicitudCrearPlan= fabricaSolicitudCrearPlan;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearPlan comandoSolicitudCrearPlan) {
        return new ComandoRespuesta<>(servicioCrearPlan.ejecutar(
                fabricaSolicitudCrearPlan.crear(comandoSolicitudCrearPlan)));
    }
}
