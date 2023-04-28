package com.ceiba.plan.adaptador.dao;

import com.ceiba.ejercicio.puerto.RepositorioEjercicio;
import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPlan implements RowMapper<Plan>, MapperResult {

    private RepositorioRutina repositorioRutina;

    private DaoEjercicio daoEjercicio;

    public MapeoPlan(RepositorioRutina repositorioRutina, DaoEjercicio daoEjercicio) {
        this.repositorioRutina = repositorioRutina;
        this.daoEjercicio = daoEjercicio;
    }

    @Override
    public Plan mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id");
        var rutina = resultSet.getLong("rutina");
        var ejercicio = resultSet.getLong("ejercicio");
        var peso = resultSet.getInt("peso");
        var series = resultSet.getInt("series");
        var repeticiones = resultSet.getInt("repeticiones");
        return Plan.reconstruir(id,repositorioRutina.obtenerRutina(rutina)
                ,daoEjercicio.obtenerEjercicio(ejercicio), peso, series, repeticiones);
    }
}
