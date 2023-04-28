package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoObtenerUsuario implements RowMapper<Usuario>, MapperResult {
    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id_usuario");
        var nombre = resultSet.getString("nombre");
        var peso = resultSet.getFloat("peso");
        var fechaNacimiento = resultSet.getDate("fecha_nacimiento");
        var correo = resultSet.getString("correo");
        var contrasenia = resultSet.getString("contrasenia");

        return Usuario.reconstruir(id,nombre,peso,fechaNacimiento,correo,contrasenia);

    }
}
