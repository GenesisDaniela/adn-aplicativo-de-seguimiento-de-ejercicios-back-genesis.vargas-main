package com.ceiba.plan.adaptador.dao;

import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.rutina.puerto.RepositorioRutina;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoListarPlan implements RowMapper<Plan>, MapperResult {

    RepositorioRutina repositorioRutina;

    DaoEjercicio daoEjercicio;

    public MapeoListarPlan(RepositorioRutina repositorioRutina, DaoEjercicio daoEjercicio) {
        this.repositorioRutina = repositorioRutina;
        this.daoEjercicio = daoEjercicio;
    }

    @Override
    public Plan mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var rutina = repositorioRutina.obtenerRutina(resultSet.getLong("rutina"));
        var ejercicio = daoEjercicio.obtenerEjercicio(resultSet.getLong("ejercicio"));
        var peso = resultSet.getInt("peso");
        var series = resultSet.getInt("series");
        var repeticiones = resultSet.getInt("repeticiones");

        return Plan.reconstruir(id, rutina, ejercicio,peso,series,repeticiones);
    }
}
