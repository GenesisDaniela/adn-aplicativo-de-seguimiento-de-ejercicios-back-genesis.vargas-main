package com.ceiba.ejercicio.adaptador.dao;

import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class MapeoEjercicio  implements RowMapper<Ejercicio>, MapperResult {

    @Override
    public Ejercicio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var idEjercicio = resultSet.getLong("id_ejercicio");
        var nombre = resultSet.getString("nombre");
        var seccionCuerpo = resultSet.getString("seccion_cuerpo");
        return Ejercicio.reconstruir(idEjercicio,nombre, seccionCuerpo);
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
