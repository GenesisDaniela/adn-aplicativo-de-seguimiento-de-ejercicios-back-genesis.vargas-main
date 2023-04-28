package com.ceiba.ejercicio.puerto.dao;

import com.ceiba.ejercicio.entidad.Ejercicio;

import java.util.List;

public interface DaoEjercicio {
    Ejercicio obtenerEjercicio(Long idEjercicio);
    List<Ejercicio> listarEjercicio();
    List<Ejercicio> listarEjercicioDeUsuario(Long idUsuario);

}
