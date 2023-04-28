package com.ceiba.usuario.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

import java.util.Date;
import java.util.Objects;

public class Usuario {
    private Long id;
    private String nombre;
    private Float peso;
    private String correo;
    private String contrasenia;
    private Date fechaNacimiento;

    private static final long EDAD_MINIMA_PERMITIDA = 16L;
    private static final long MILISEGUNDOS_ANIO = 31557600000L;


    private Usuario(Long id, String nombre, Float peso, Date fechaNacimiento, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Usuario(String nombre, Float peso, String correo, String contrasenia, Date fechaNacimiento) {
        this.nombre = nombre;
        this.peso = peso;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = new Date(fechaNacimiento.getTime());
    }

    public static Usuario crear(SolicitudCrearUsuario solicitudCrearUsuario){
        ValidadorArgumento.validarObligatorio(solicitudCrearUsuario.getNombre(), "El nombre del usuario es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearUsuario.getPeso(), "El peso es requerido");
        ValidadorArgumento.validarPositivo((double)solicitudCrearUsuario.getPeso(), "El peso debe ser un valor positivo");
        ValidadorArgumento.validarObligatorio(solicitudCrearUsuario.getCorreo(), "El correo es requerido");
        ValidadorArgumento.validarRegex(solicitudCrearUsuario.getCorreo(), "^(.+)@(\\S+)$","El correo no tiene un formato correcto");
        ValidadorArgumento.validarObligatorio(solicitudCrearUsuario.getContrasenia(), "la contraseña es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearUsuario.getFechaNacimiento(),"La fecha de nacimiento es requerida");
        ValidadorArgumento.validarLongitudMinima(solicitudCrearUsuario.getCorreo(),5,"El correo debe tener minimo 5 caracteres de longitud");
        ValidadorArgumento.validarLongitudMinima(solicitudCrearUsuario.getContrasenia(),10,"la contraseña debe tener minimo 10 caracteres de longitud");
        return new Usuario(solicitudCrearUsuario.getNombre(),
                solicitudCrearUsuario.getPeso(),
                solicitudCrearUsuario.getCorreo(), solicitudCrearUsuario.getContrasenia(), solicitudCrearUsuario.getFechaNacimiento());
    }

    public static Usuario reconstruir(Long id, String nombre, Float peso, Date fechaNacimiento, String correo, String contrasenia){
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del usuario es requerido");
        ValidadorArgumento.validarObligatorio(peso, "El peso es requerido");
        ValidadorArgumento.validarPositivo((double)peso, "El peso debe ser un valor positivo");
        ValidadorArgumento.validarObligatorio(correo, "El correo es requerido");
        ValidadorArgumento.validarRegex(correo, "^(.+)@(\\S+)$","El correo no tiene un formato correcto");
        ValidadorArgumento.validarObligatorio(contrasenia, "la contraseña es requerido");
        ValidadorArgumento.validarObligatorio(fechaNacimiento,"La fecha de nacimiento es requerida");
        ValidadorArgumento.validarLongitudMinima(correo,5,"El correo debe tener minimo 5 caracteres de longitud");
        ValidadorArgumento.validarLongitudMinima(contrasenia,10,"la contraseña debe tener minimo 10 caracteres de longitud");

        Date now = new Date();
        long diff = now.getTime()-fechaNacimiento.getTime();
        long edad =diff/MILISEGUNDOS_ANIO;
        ValidadorArgumento.validarMenor(EDAD_MINIMA_PERMITIDA,edad,
                "Solo puede registrarse si tiene más de 15 años");

        return new Usuario(id, nombre, peso, fechaNacimiento, correo, contrasenia);
    }

    public Date getFechaNacimiento() {
        return new Date(fechaNacimiento.getTime());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPeso() {
        return peso;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Usuario usuario = (Usuario) o;

        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}