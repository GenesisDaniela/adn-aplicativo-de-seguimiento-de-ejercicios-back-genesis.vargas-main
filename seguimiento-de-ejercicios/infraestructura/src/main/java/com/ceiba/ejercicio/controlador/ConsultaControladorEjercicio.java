package com.ceiba.ejercicio.controlador;


import com.ceiba.ejercicio.consulta.ManejadorConsultaObtenerEjercicio;
import com.ceiba.ejercicio.entidad.Ejercicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/ejercicio")
@RestController
@Tag(name = "Controlador consulta ejercicio")
public class ConsultaControladorEjercicio {

    private ManejadorConsultaObtenerEjercicio manejadorConsultaObtenerEjercicio;

    public ConsultaControladorEjercicio(ManejadorConsultaObtenerEjercicio manejadorConsultaObtenerEjercicio) {
        this.manejadorConsultaObtenerEjercicio = manejadorConsultaObtenerEjercicio;
    }

    @GetMapping("")
    @Operation(summary = "Obtener", description = "Metodo utilizado para consultar todos los ejercicios")
    public List<Ejercicio> obeterFacturas() {
        return manejadorConsultaObtenerEjercicio.ejecutar();
    }

}
