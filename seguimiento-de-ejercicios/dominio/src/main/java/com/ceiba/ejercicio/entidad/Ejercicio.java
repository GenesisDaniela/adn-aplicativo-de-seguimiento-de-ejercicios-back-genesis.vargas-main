package com.ceiba.ejercicio.entidad;

import com.ceiba.dominio.ValidadorArgumento;

public final class Ejercicio {
    private final Long id;
    private final String nombre;
    private final String seccionCuerpo;

    private Ejercicio(Long id, String nombre, String seccionCuerpo) {
        this.id = id;
        this.nombre = nombre;
        this.seccionCuerpo = seccionCuerpo;
    }

    public static Ejercicio reconstruir(Long id, String nombre, String seccionCuerpo){
        ValidadorArgumento.validarObligatorio(id, "El id del ejercicio es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del ejercicio es requerido");
        ValidadorArgumento.validarObligatorio(seccionCuerpo, "La seccion del cuerpo del ejercicio es requerido");
        return new Ejercicio(id, nombre, seccionCuerpo);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSeccionCuerpo() {
        return seccionCuerpo;
    }
}
