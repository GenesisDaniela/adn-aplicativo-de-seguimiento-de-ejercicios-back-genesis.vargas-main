package com.ceiba.plan.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.plan.entidad.Plan;
import com.ceiba.plan.puerto.dao.DaoPlan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoPlanMysql implements DaoPlan {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoListarPlan mapeoPlan;

    @SqlStatement(namespace = "plan", value = "obtenerplanesderutina")
    private static String sqlObtenerPlanesDeRutina;

    public DaoPlanMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoListarPlan mapeoPlan) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPlan = mapeoPlan;
    }

    @Override
    public List<Plan> listarPlanesDeRutina(Long idRutina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_rutina", idRutina);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPlanesDeRutina,paramSource, mapeoPlan);
    }
}
