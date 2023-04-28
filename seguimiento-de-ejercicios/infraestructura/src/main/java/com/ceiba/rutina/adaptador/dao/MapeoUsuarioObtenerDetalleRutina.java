package com.ceiba.rutina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.plan.puerto.dao.DaoPlan;
import com.ceiba.rutina.modelo.dto.RutinaDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoUsuarioObtenerDetalleRutina implements RowMapper<RutinaDTO>, MapperResult {

    DaoPlan daoPlan;

    public MapeoUsuarioObtenerDetalleRutina(DaoPlan daoPlan) {
        this.daoPlan = daoPlan;
    }

    @Override
    public RutinaDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("id_rutina");
        var descripcion = resultSet.getString("descripcion");
        var objetivo = resultSet.getString("objetivo");
        var planes = daoPlan.listarPlanesDeRutina(id);
        return new RutinaDTO(id,descripcion,objetivo,planes);
    }
}
