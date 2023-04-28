package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MapeoUsuarioIniciarSesion implements RowMapper<InicioSesionDTO>, MapperResult {
    @Override
    public InicioSesionDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var correo = resultSet.getString("correo");
        var contrasenia = resultSet.getString("contrasenia");
        return InicioSesionDTO.reconstruir(correo, contrasenia);
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
