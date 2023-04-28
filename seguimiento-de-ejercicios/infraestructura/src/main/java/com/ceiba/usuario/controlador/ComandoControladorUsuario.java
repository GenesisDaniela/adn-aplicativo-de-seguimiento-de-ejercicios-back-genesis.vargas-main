package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.plan.comando.ComandoSolicitudCrearPlan;
import com.ceiba.plan.comando.manejador.ManejadorCrearPlan;
import com.ceiba.rutina.comando.ComandoSolicitudCrearRutina;
import com.ceiba.usuario.comando.ComandoSolicitudCrearUsuario;
import com.ceiba.rutina.comando.ComandoSolicitudEditarRutina;
import com.ceiba.rutina.comando.manejador.ManejadorCrearRutina;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.rutina.comando.manejador.ManejadorEditarRutina;
import com.ceiba.usuario.comando.manejador.ManejadorIniciarSesion;
import com.ceiba.usuario.consulta.ConsultaSolicitudIniciarSesion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/usuario")
@RestController
@Tag(name = "Controlador consulta usuario")
@Slf4j
public class ComandoControladorUsuario {

    private final ManejadorCrearRutina manejadorCrearRutina;
    private final ManejadorCrearPlan manejadorCrearPlan;
    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorEditarRutina manejadorEditarRutina;
    private final ManejadorIniciarSesion manejadorIniciarSesion;

    public ComandoControladorUsuario(ManejadorCrearRutina manejadorCrearRutina, ManejadorCrearPlan manejadorCrearPlan, ManejadorCrearUsuario manejadorCrearUsuario, ManejadorEditarRutina manejadorEditarRutina, ManejadorIniciarSesion manejadorIniciarSesion) {
        this.manejadorCrearRutina = manejadorCrearRutina;
        this.manejadorCrearPlan = manejadorCrearPlan;
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorEditarRutina = manejadorEditarRutina;
        this.manejadorIniciarSesion = manejadorIniciarSesion;
    }

    @PostMapping("/iniciar-sesion")
    @Operation(summary = "Iniciar Sesion", description = "Metodo utilizado para iniciar sesion")
    public ComandoRespuesta<String> iniciarSesion(@RequestBody ConsultaSolicitudIniciarSesion solicitudIniciarSesion) {
        return manejadorIniciarSesion.ejecutar(solicitudIniciarSesion);
    }

    @PostMapping("/{idUsuario}/rutina")
    @Operation(summary = "Crear rutina", description = "Metodo utilizado para crear una rutina")
    public ComandoRespuesta<Long> crearRutina(@PathVariable Integer idUsuario,@RequestBody ComandoSolicitudCrearRutina comandoSolicitudCrearRutina) {
        comandoSolicitudCrearRutina.setIdUsuario(idUsuario);
        return manejadorCrearRutina.ejecutar(comandoSolicitudCrearRutina);
    }

    @PostMapping("/{idUsuario}/rutina/{idRutina}/plan")
    @Operation(summary = "Crear plan", description = "Metodo utilizado para crear un plan")
    public ComandoRespuesta<Long> crearPlan(@PathVariable Integer idUsuario,@PathVariable Long idRutina, @RequestBody ComandoSolicitudCrearPlan comandoSolicitudCrearPlan) {
        comandoSolicitudCrearPlan.setRutina(idRutina);
        return manejadorCrearPlan.ejecutar(comandoSolicitudCrearPlan);
    }

    @PostMapping("")
    @Operation(summary = "Crear usuario", description = "Metodo utilizado para crear un usuario")
    public ComandoRespuesta<Long> registrarUsuario(@RequestBody ComandoSolicitudCrearUsuario comandoSolicitudCrearUsuario) {
        return manejadorCrearUsuario.ejecutar(comandoSolicitudCrearUsuario);
    }

    @PutMapping("/{idUsuario}/rutina/{idRutina}")
    @Operation(summary = "Editar rutina", description = "Metodo utilizado para editar una rutina")
    public ComandoRespuesta editarRutine(@PathVariable Integer idUsuario, @PathVariable Long idRutina, @RequestBody ComandoSolicitudEditarRutina comandoSolicitudEditarRutina){
        comandoSolicitudEditarRutina.setIdRutina(idRutina);
        comandoSolicitudEditarRutina.setIdUsuario(idUsuario);
        return manejadorEditarRutina.ejecutar(comandoSolicitudEditarRutina);
    }

}
