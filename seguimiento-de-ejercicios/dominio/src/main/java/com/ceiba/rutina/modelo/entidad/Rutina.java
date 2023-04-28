package com.ceiba.rutina.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.usuario.modelo.entidad.Usuario;

public final class Rutina {
    private Long id;
    private String descripcion;
    private String objetivo;
    private final Usuario usuario;
    private static final String MENSAJEUSUARIO = "Usuario no encontrado o vacio";
    private static final String MENSAJEDESCRIPCION= "La descripcion no puede estar vacia";
    private static final String MENSAJEOBJETIVO = "Debes proporcionar un objetivo";
    private Rutina(Long id, String descripcion, String objetivo, Usuario usuario) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.usuario = usuario;
        this.id = id;
    }

    private Rutina(String descripcion, String objetivo, Usuario usuario) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.usuario = usuario;
    }

    public static Rutina crear(SolicitudCrearRutina solicitudCrearRutina){
        ValidadorArgumento.validarObligatorio(solicitudCrearRutina.getUsuario(), MENSAJEUSUARIO);
        ValidadorArgumento.validarObligatorio(solicitudCrearRutina.getDescripcion(), MENSAJEDESCRIPCION);
        ValidadorArgumento.validarObligatorio(solicitudCrearRutina.getObjetivo(), MENSAJEOBJETIVO);
        return new Rutina(solicitudCrearRutina.getDescripcion(), solicitudCrearRutina.getObjetivo(), solicitudCrearRutina.getUsuario());
    }

    public Rutina editar(SolicitudEditarRutina solicitudEditarRutina){
        ValidadorArgumento.validarObligatorio(solicitudEditarRutina.getUsuario(), MENSAJEUSUARIO);
        ValidadorArgumento.validarObligatorio(solicitudEditarRutina.getDescripcion(), MENSAJEDESCRIPCION);
        ValidadorArgumento.validarObligatorio(solicitudEditarRutina.getObjetivo(), MENSAJEOBJETIVO);
        return new Rutina(solicitudEditarRutina.getIdRutina(),
                solicitudEditarRutina.getDescripcion(),
                solicitudEditarRutina.getObjetivo(),
                solicitudEditarRutina.getUsuario());
    }

    public static Rutina reconstruir( Long id, String descripcion, String objetivo, Usuario usuario){
        ValidadorArgumento.validarObligatorio(usuario, MENSAJEUSUARIO);
        ValidadorArgumento.validarObligatorio(descripcion, MENSAJEDESCRIPCION);
        ValidadorArgumento.validarObligatorio(objetivo, MENSAJEOBJETIVO);
        return new Rutina(id,descripcion, objetivo, usuario);
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
