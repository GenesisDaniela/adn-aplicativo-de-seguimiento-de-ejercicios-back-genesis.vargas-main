package com.ceiba.usuario.modelo.dto;

import com.ceiba.dominio.ValidadorArgumento;

public class InicioSesionDTO {
    private final String correo;
    private final String contrasenia;

    public InicioSesionDTO(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public static InicioSesionDTO reconstruir(String correo, String contrasenia){
        ValidadorArgumento.validarObligatorio(correo, "El correo es requerido");
        ValidadorArgumento.validarObligatorio(contrasenia, "la contraseña es requerido");

        return new InicioSesionDTO(correo, contrasenia);
    }


    public String getCorreo() {
        return correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}