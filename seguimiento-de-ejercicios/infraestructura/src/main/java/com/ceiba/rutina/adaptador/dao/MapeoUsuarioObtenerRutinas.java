package com.ceiba.rutina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.rutina.modelo.dto.ResumenRutinaDTO;
import com.ceiba.rutina.modelo.entidad.Rutina;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class MapeoUsuarioObtenerRutinas implements RowMapper<ResumenRutinaDTO>, MapperResult {
    @Override
    public ResumenRutinaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id_rutina");
        var descripcion = resultSet.getString("descripcion");
        var objetivo = resultSet.getString("objetivo");
        return new ResumenRutinaDTO(id,descripcion,objetivo);
    }
}
