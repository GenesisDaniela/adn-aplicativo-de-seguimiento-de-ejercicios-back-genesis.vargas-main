package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoUsuario mapeoUsuario;

    @SqlStatement(namespace = "usuario", value = "crearusuario")
    private static String sqlcrearusuario;

    @SqlStatement(namespace = "usuario", value = "obtenerporid")
    private static String sqlobtenerusuarioporid;

    @SqlStatement(namespace = "usuario", value = "obtenerusuarioporcorreo")
    private static String sqlobtenerusuarioporcorreo;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoUsuario mapeoUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoUsuario = mapeoUsuario;
    }

    @Override
    public Long guardarUsuario(Usuario usuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", usuario.getNombre());
        paramSource.addValue("peso", usuario.getPeso());
        paramSource.addValue("fecha_nacimiento", usuario.getFechaNacimiento());
        paramSource.addValue("correo", usuario.getCorreo());
        paramSource.addValue("contrasenia", usuario.getContrasenia());
        // se realiza sobrecrga del metodo crear para especificar que la llave primaria tiene
        // nombre diferente a id, en este caso es id_usuario
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlcrearusuario, "id_usuario") ;
    }

    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_usuario", idUsuario);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerusuarioporid, paramSource, mapeoUsuario));
    }

    @Override
    public Usuario obtenerUsuarioPorCorreo(String correo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("correo", correo);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerusuarioporcorreo, paramSource, mapeoUsuario));
    }

}