package com.ceiba.configuracion;

import com.ceiba.plan.puerto.RepositorioPlan;
import com.ceiba.plan.puerto.dao.DaoPlan;
import com.ceiba.plan.servicio.ServicioCrearPlan;
import com.ceiba.plan.servicio.ServicioEditarPlan;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.rutina.servicio.ServicioCrearRutina;
import com.ceiba.rutina.servicio.ServicioEditarRutina;
import com.ceiba.rutina.servicio.ServicioObtenerRutina;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioIniciarSesion;
import com.ceiba.usuario.servicio.ServicioObtenerUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearRutina servicioCrearRutina(RepositorioRutina repositorioRutina){
        return new ServicioCrearRutina(repositorioRutina);
    }
    @Bean
    public ServicioEditarRutina servicioEditarRutina(RepositorioRutina repositorioRutina){
        return new ServicioEditarRutina(repositorioRutina);
    }

    @Bean
    public ServicioIniciarSesion servicioIniciarSesion(DaoUsuario daoUsuario){
        return new ServicioIniciarSesion(daoUsuario);
    }

    @Bean
    public ServicioCrearPlan servicioCrearPlan(RepositorioPlan repositorioPlan, DaoPlan daoPlan){
        return new ServicioCrearPlan(repositorioPlan, daoPlan);
    }

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario){
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioObtenerUsuario servicioObtenerUsuario(DaoUsuario daoUsuario){
        return new ServicioObtenerUsuario(daoUsuario);
    }

    @Bean
    public ServicioEditarPlan servicioEditarPlan(RepositorioPlan repositorioPlan){
        return new ServicioEditarPlan(repositorioPlan);
    }

    @Bean
    public ServicioObtenerRutina servicioObtenerRutina(RepositorioRutina repositorioRutina){
        return new ServicioObtenerRutina(repositorioRutina);
    }



}
