package com.ceiba.rutina.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResumenRutinaDTO {
    private final Long id;
    private final String descripcion;
    private final String objetivo;
}
