package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.rutina.adaptador.dao.MapeoUsuarioObtenerDetalleRutina;
import com.ceiba.rutina.adaptador.dao.MapeoUsuarioObtenerRutinas;
import com.ceiba.rutina.modelo.dto.ResumenRutinaDTO;
import com.ceiba.rutina.modelo.dto.RutinaDTO;
import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DaoUsuarioMysql implements DaoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoUsuarioObtenerRutinas mapeoUsuarioObtenerRutinas;

    private final MapeoUsuarioObtenerDetalleRutina mapeoUsuarioObtenerDetalleRutina;

    private static final String PARAM_NAME_ID_USUARIO="id_usuario";
    private static final String PARAM_NAME_ID_RUTINA="id_rutina";


    @SqlStatement(namespace = "usuario", value = "obtenerusuario")
    private static String sqlObtenerUsuario;
    @SqlStatement(namespace = "usuario", value = "obtenerporid")
    private static String sqlObtenerUsuarioPorId;

    @SqlStatement(namespace = "usuario", value = "obtenerrutinasporid")
    private static String sqlObtenerRutinasDeUsuarioPorId;

    @SqlStatement(namespace = "usuario", value = "obtenerdetallerutinaporid")
    private static String sqlObtenerDetalleRutinaDeUsuarioPorId;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,
                           MapeoUsuarioObtenerRutinas mapeoUsuarioObtenerRutinas,
                           MapeoUsuarioObtenerDetalleRutina mapeoUsuarioObtenerDetalleRutina) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoUsuarioObtenerRutinas = mapeoUsuarioObtenerRutinas;
        this.mapeoUsuarioObtenerDetalleRutina = mapeoUsuarioObtenerDetalleRutina;

    }

    @Override
    public InicioSesionDTO obtenerUsuarioPorcorreoContrasenia(String correo, String contrasenia) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("correo", correo);
        paramSource.addValue("contrasenia", contrasenia);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerUsuario,
                        paramSource, new MapeoUsuarioIniciarSesion()));
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_USUARIO, idUsuario);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerUsuarioPorId,
                        paramSource, new MapeoObtenerUsuario()));
    }

    @Override
    public List<ResumenRutinaDTO> obtenerRutinasUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_USUARIO, idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerRutinasDeUsuarioPorId,paramSource, mapeoUsuarioObtenerRutinas);
    }

    @Override
    public RutinaDTO obtenerDetalleRutinaUsuario(Long idUsuario, Long idRutina) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_NAME_ID_USUARIO, idUsuario);
        paramSource.addValue(PARAM_NAME_ID_RUTINA, idRutina);

        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(
                        sqlObtenerDetalleRutinaDeUsuarioPorId,
                        paramSource, mapeoUsuarioObtenerDetalleRutina));
    }


}
