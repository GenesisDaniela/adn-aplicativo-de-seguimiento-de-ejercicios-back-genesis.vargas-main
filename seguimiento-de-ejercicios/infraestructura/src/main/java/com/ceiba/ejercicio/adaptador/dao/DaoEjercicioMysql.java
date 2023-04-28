package com.ceiba.ejercicio.adaptador.dao;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.ejercicio.puerto.dao.DaoEjercicio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class DaoEjercicioMysql implements DaoEjercicio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoEjercicio mapeoEjercicio;

    public DaoEjercicioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoEjercicio mapeoEjercicio) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoEjercicio = mapeoEjercicio;
    }

    @SqlStatement(namespace = "ejercicio", value = "obtenerejercicioporid")
    private static String sqlObtenerEjercicio;

    @SqlStatement(namespace = "ejercicio", value = "obtenerejercicios")
    private static String sqlObtenerEjercicios;



    @Override
    public Ejercicio obtenerEjercicio(Long idEjercicio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_ejercicio", idEjercicio);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerEjercicio, paramSource, mapeoEjercicio));
    }

    @Override
    public List<Ejercicio> listarEjercicio() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerEjercicios, mapeoEjercicio);
    }

    @Override
    public List<Ejercicio> listarEjercicioDeUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_usuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerEjercicios, mapeoEjercicio);
    }
}
