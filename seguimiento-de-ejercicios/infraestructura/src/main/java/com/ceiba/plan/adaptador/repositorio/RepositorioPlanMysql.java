package com.ceiba.plan.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.plan.adaptador.dao.MapeoPlan;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.puerto.RepositorioPlan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPlanMysql implements RepositorioPlan {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "plan", value = "crearplan")
    private static String sqlcrearplan;

    @SqlStatement(namespace = "plan", value = "editarplan")
    private static String sqleditarplan;

    @SqlStatement(namespace = "plan", value = "obtenerplanporid")
    private static String sqlobtenerplan;

    private MapeoPlan mapeoPlan;

    public RepositorioPlanMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPlan mapeoPlan) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPlan = mapeoPlan;
    }

    @Override
    public Long guardarPlan(Plan plan) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", plan.getId());
        paramSource.addValue("peso", plan.getPeso());
        paramSource.addValue("series", plan.getSeries());
        paramSource.addValue("repeticiones", plan.getRepeticiones());
        paramSource.addValue("ejercicio", plan.getEjercicio().getId());
        paramSource.addValue("rutina", plan.getRutina().getId());
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlcrearplan, "id");
    }

    @Override
    public Plan obtenerPlan(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
         return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                 this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerplan, paramSource, mapeoPlan));
    }

    @Override
    public List<Plan> listarPlan() {
        return new ArrayList<>();
    }

    @Override
    public Integer editarPlan(Plan plan, Long idPlan) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPlan);
        paramSource.addValue("peso", plan.getPeso());
        paramSource.addValue("series", plan.getSeries());
        paramSource.addValue("repeticiones", plan.getRepeticiones());
        paramSource.addValue("ejercicio", plan.getEjercicio().getId());
        paramSource.addValue("rutina", plan.getRutina().getId());
        return this.customNamedParameterJdbcTemplate.
                getNamedParameterJdbcTemplate().update(sqleditarplan, paramSource);
    }
}
