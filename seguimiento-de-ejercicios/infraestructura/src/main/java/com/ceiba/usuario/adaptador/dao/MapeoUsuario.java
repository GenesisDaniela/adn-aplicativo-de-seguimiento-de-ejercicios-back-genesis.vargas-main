package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class MapeoUsuario implements RowMapper<Usuario>, MapperResult {
    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id_usuario");
        var peso = resultSet.getFloat("peso");
        var fechaNacimiento = resultSet.getDate("fecha_nacimiento");
        var nombre = resultSet.getString("nombre");
        var correo = resultSet.getString("correo");
        var contrasenia = resultSet.getString("contrasenia");
        return Usuario.reconstruir(id, nombre, peso, fechaNacimiento, correo, contrasenia);
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
