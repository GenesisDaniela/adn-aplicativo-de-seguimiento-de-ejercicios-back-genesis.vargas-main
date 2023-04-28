package com.ceiba.rutina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MapeoCrearRutina implements RowMapper<Rutina>, MapperResult {

    private final RepositorioUsuario repositorioUsuario;

    public MapeoCrearRutina(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Rutina mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var idRutina = resultSet.getLong("id_rutina");
        var descripcion = resultSet.getString("descripcion");
        var objetivo = resultSet.getString("objetivo");
        var usuario = resultSet.getInt("usuario");
        return Rutina.reconstruir(idRutina,descripcion,objetivo, repositorioUsuario.obtenerUsuario(usuario));
    }

    @Override
    public LocalDate extraerLocalDate(ResultSet resultSet, String label) throws SQLException {
        return MapperResult.super.extraerLocalDate(resultSet, label);
    }

    @Override
    public LocalDateTime extraerLocalDateTime(ResultSet resultSet, String label) throws SQLException {
        return MapperResult.super.extraerLocalDateTime(resultSet, label);
    }
}
