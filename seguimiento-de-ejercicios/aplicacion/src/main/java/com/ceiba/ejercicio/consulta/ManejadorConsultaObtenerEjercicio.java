package com.ceiba.ejercicio.consulta;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorConsultaObtenerEjercicio {
    private final DaoEjercicio daoEjercicio;

    public ManejadorConsultaObtenerEjercicio(DaoEjercicio daoEjercicio) {
        this.daoEjercicio = daoEjercicio;
    }

    public List<Ejercicio> ejecutar(){
        return daoEjercicio.listarEjercicio();
    }


}
