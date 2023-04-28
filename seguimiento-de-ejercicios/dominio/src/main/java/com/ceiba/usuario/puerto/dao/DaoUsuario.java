package com.ceiba.usuario.puerto.dao;

import com.ceiba.rutina.modelo.dto.ResumenRutinaDTO;
import com.ceiba.rutina.modelo.dto.RutinaDTO;
import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.List;

public interface DaoUsuario {
    InicioSesionDTO obtenerUsuarioPorcorreoContrasenia(String correo, String contrasenia);

    Usuario obtenerUsuario(Long idUsuario);
    List<ResumenRutinaDTO> obtenerRutinasUsuario(Long idUsuario);

    RutinaDTO obtenerDetalleRutinaUsuario(Long idUsuario, Long idRutina);

}
