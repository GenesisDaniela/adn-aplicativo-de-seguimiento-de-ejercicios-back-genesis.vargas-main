package com.ceiba.usuario.servicio;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionNoEncontrado;
import com.ceiba.usuario.modelo.entidad.SolicitudIniciarSesion;
import com.ceiba.usuario.modelo.dto.InicioSesionDTO;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

public class ServicioIniciarSesion {
    private final DaoUsuario daoUsuario;

    public ServicioIniciarSesion(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public String ejecutar(SolicitudIniciarSesion solicitudIniciarSesion){

        String correo = solicitudIniciarSesion.getCorreo();
        String contrasenia = solicitudIniciarSesion.getContrasenia();

        ValidadorArgumento.validarObligatorio(correo, "El correo es obligatorio");
        ValidadorArgumento.validarObligatorio(contrasenia, "La contraseña es obligatoria");
        ValidadorArgumento.validarLongitudMinima(correo,5,"El correo debe tener minimo 5 caracteres de longitud");
        ValidadorArgumento.validarLongitudMinima(contrasenia,10,"la contraseña debe tener minimo 10 caracteres de longitud");

        InicioSesionDTO inicioSesionDTO = daoUsuario.obtenerUsuarioPorcorreoContrasenia(solicitudIniciarSesion.getCorreo(), solicitudIniciarSesion.getContrasenia());
        if(inicioSesionDTO == null){
            throw new ExcepcionNoEncontrado("El correo no existe o contraseña incorrecta");
        }

        return solicitudIniciarSesion.getCorreo();
    }
}
