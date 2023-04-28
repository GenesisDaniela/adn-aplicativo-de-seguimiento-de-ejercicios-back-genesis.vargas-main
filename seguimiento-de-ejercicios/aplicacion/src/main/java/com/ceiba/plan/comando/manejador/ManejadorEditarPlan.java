package com.ceiba.plan.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plan.comando.fabrica.FabricaEditarPlan;
import com.ceiba.plan.servicio.ServicioEditarPlan;
import com.ceiba.plan.comando.ComandoSolicitudEditarPlan;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEditarPlan implements ManejadorComandoRespuesta<ComandoSolicitudEditarPlan, ComandoRespuesta<Integer>> {

    private final ServicioEditarPlan servicioEditarPlan;
    private final FabricaEditarPlan fabricaEditarPlan;

    public ManejadorEditarPlan(ServicioEditarPlan servicioEditarPlan, FabricaEditarPlan fabricaEditarPlan) {
        this.servicioEditarPlan = servicioEditarPlan;
        this.fabricaEditarPlan = fabricaEditarPlan;
    }

    @Override
    public ComandoRespuesta<Integer> ejecutar(ComandoSolicitudEditarPlan comandoSolicitudEditarPlan) {
        return new ComandoRespuesta<>(servicioEditarPlan.ejecutar(
                fabricaEditarPlan.editar(comandoSolicitudEditarPlan)));
    }
}
