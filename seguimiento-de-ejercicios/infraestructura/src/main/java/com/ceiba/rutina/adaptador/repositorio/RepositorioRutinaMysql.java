package com.ceiba.rutina.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rutina.adaptador.dao.MapeoCrearRutina;
import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.rutina.puerto.RepositorioRutina;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class RepositorioRutinaMysql implements RepositorioRutina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoCrearRutina mapeoRutina;
    private static final String PARAM_NAME_ID_RUTINA="id_rutina";


    public RepositorioRutinaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCrearRutina mapeoRutina) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoRutina = mapeoRutina;
    }

    @SqlStatement(namespace = "rutina", value = "crearrutina")
    private static String sqlcrearrutina;

    @SqlStatement(namespace = "rutina", value = "editarrutina")
    private static String sqleditarrutina;

    @SqlStatement(namespace = "rutina", value = "obtenerrutinaporid")
    private static String sqlobtenerrutinaporid;

    @Override
    public Long guardarRutina(Rutina rutina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_RUTINA, rutina.getId());
        paramSource.addValue("descripcion", rutina.getDescripcion());
        paramSource.addValue("objetivo", rutina.getObjetivo());
        paramSource.addValue("usuario", rutina.getUsuario().getId());
        return this.customNamedParameterJdbcTemplate.crear(paramSource,
                sqlcrearrutina,PARAM_NAME_ID_RUTINA );
    }

    @Override
    public List<Rutina> listarRutina() {
        return new ArrayList<>();
    }

    @Override
    public Rutina obtenerRutina(Long idRutina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_RUTINA, idRutina);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerrutinaporid, paramSource, mapeoRutina));
    }

    @Override
    public Integer editarRutina(Rutina rutina, Long idRutina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_RUTINA, idRutina);
        paramSource.addValue("descripcion", rutina.getDescripcion());
        paramSource.addValue("objetivo", rutina.getObjetivo());
        return this.customNamedParameterJdbcTemplate.
                getNamedParameterJdbcTemplate().update(sqleditarrutina, paramSource);
    }
}
