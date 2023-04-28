package com.ceiba.plan.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.ejercicio.entidad.Ejercicio;
import com.ceiba.rutina.modelo.entidad.Rutina;

public final class Plan {
    private Long id;
    private final Rutina rutina;
    private final Ejercicio ejercicio;
    private Integer peso;
    private Integer series;
    private Integer repeticiones;

    private static final String MSGRUTINAREQUERIDA="la rutina es requerida";
    private static final String MSGEJERCICIOREQUERIDA="el ejercicio es requerido";
    private static final String MSGPESOREQUERIDO="el peso es requerido";
    private static final String MSGSERIESREQUERIDA="las series son requeridas";
    private static final String MSGREPETICIONESREQUERIDA="las repeticiones son requeridas";


    private Plan( Rutina rutina, Ejercicio ejercicio, Integer peso, Integer series, Integer repeticiones) {
        this.rutina = rutina;
        this.ejercicio = ejercicio;
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    private Plan(Long id, Rutina rutina, Ejercicio ejercicio, Integer peso, Integer series, Integer repeticiones) {
        this.id = id;
        this.rutina = rutina;
        this.ejercicio = ejercicio;
        this.peso = peso;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    public static Plan reconstruir(Long id, Rutina rutina, Ejercicio ejercicio, Integer peso, Integer series, Integer repeticiones){
        ValidadorArgumento.validarObligatorio(rutina, MSGRUTINAREQUERIDA);
        ValidadorArgumento.validarObligatorio(ejercicio, MSGEJERCICIOREQUERIDA);
        ValidadorArgumento.validarObligatorio(peso, MSGPESOREQUERIDO);
        ValidadorArgumento.validarObligatorio(series, MSGSERIESREQUERIDA);
        ValidadorArgumento.validarObligatorio(repeticiones, MSGREPETICIONESREQUERIDA);
        return new Plan(id, rutina, ejercicio,peso, series,repeticiones);
    }

    public static Plan crear(SolicitudCrearPlan solicitudCrearPlan) {
        ValidadorArgumento.validarObligatorio(solicitudCrearPlan.getRutina(), MSGRUTINAREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudCrearPlan.getEjercicio(), MSGEJERCICIOREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudCrearPlan.getPeso(), MSGPESOREQUERIDO);
        ValidadorArgumento.validarObligatorio(solicitudCrearPlan.getSeries(), MSGSERIESREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudCrearPlan.getRepeticiones(), MSGREPETICIONESREQUERIDA);
        return new Plan(solicitudCrearPlan.getRutina(),
                solicitudCrearPlan.getEjercicio(), solicitudCrearPlan.getPeso(),
                solicitudCrearPlan.getSeries(), solicitudCrearPlan.getRepeticiones());
    }

    public Plan editar(SolicitudEditarPlan solicitudEditarPlan) {
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getIdPlan(), "El id es obligatorio");
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getRutina(), MSGRUTINAREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getEjercicio(), MSGEJERCICIOREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getPeso(), MSGPESOREQUERIDO);
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getSeries(), MSGSERIESREQUERIDA);
        ValidadorArgumento.validarObligatorio(solicitudEditarPlan.getRepeticiones(), MSGREPETICIONESREQUERIDA);
        return new Plan(solicitudEditarPlan.getIdPlan(),solicitudEditarPlan.getRutina(),
                solicitudEditarPlan.getEjercicio(), solicitudEditarPlan.getPeso(),
                solicitudEditarPlan.getSeries(), solicitudEditarPlan.getRepeticiones());
    }

    public Long getId() {
        return id;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public Integer getPeso() {
        return peso;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }


}
