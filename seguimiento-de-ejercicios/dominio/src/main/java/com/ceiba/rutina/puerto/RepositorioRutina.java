package com.ceiba.rutina.puerto;

import com.ceiba.rutina.modelo.entidad.Rutina;

import java.util.List;

public interface RepositorioRutina {
    Long guardarRutina(Rutina rutina);
    List<Rutina> listarRutina();
    Rutina obtenerRutina(Long idRutina);

    Integer editarRutina(Rutina rutina, Long idRutina);
}
