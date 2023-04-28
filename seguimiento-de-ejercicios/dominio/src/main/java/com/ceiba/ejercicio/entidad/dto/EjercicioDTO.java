package com.ceiba.ejercicio.entidad.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EjercicioDTO {
    private final Long id;
    private final String nombre;
    private final String seccionCuerpo;
}
