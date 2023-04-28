package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.rutina.modelo.dto.ResumenRutinaDTO;
import com.ceiba.rutina.modelo.dto.RutinaDTO;
import com.ceiba.rutina.comando.manejador.ManejadorObtenerDetalleRutinaUsuario;
import com.ceiba.rutina.comando.manejador.ManejadorObtenerRutinaDeUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorObtenerUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/usuario")
@RestController
@Tag(name = "Controlador consulta usuario")
public class ConsultaControladorUsuario {

    private final ManejadorObtenerUsuario manejadorObtenerUsuario;
    private final ManejadorObtenerRutinaDeUsuario manejadorObtenerRutinaDeUsuario;

    private final ManejadorObtenerDetalleRutinaUsuario manejadorObtenerDetalleRutinaUsuario;


    public ConsultaControladorUsuario(ManejadorObtenerUsuario manejadorObtenerUsuario, ManejadorObtenerRutinaDeUsuario manejadorObtenerRutinaDeUsuario, ManejadorObtenerDetalleRutinaUsuario manejadorObtenerDetalleRutinaUsuario) {
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;
        this.manejadorObtenerRutinaDeUsuario = manejadorObtenerRutinaDeUsuario;
        this.manejadorObtenerDetalleRutinaUsuario = manejadorObtenerDetalleRutinaUsuario;
    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Obtener informacion de usuario", description = "Metodo utilizado para obtener la informacion de un usuario")
    public ComandoRespuesta<Usuario> obtenerUsuario(@PathVariable Long idUsuario) {
        return manejadorObtenerUsuario.ejecutar(idUsuario);
    }

    @GetMapping("/{idUsuario}/rutina")
    @Operation(summary = "Obtener rutinas", description = "Metodo utilizado para obtener las rutinas de un usuario")
    public List<ResumenRutinaDTO> obtenerRutinas(@PathVariable Long idUsuario) {
        return manejadorObtenerRutinaDeUsuario.ejecutar(idUsuario);
    }

    @GetMapping("/{idUsuario}/rutina/{idRutina}")
    @Operation(summary = "Obtener rutina", description = "Metodo utilizado para obtener la rutina de un usuario")
    public RutinaDTO obtenerRutina(@PathVariable Long idUsuario, @PathVariable Long idRutina) {
        return manejadorObtenerDetalleRutinaUsuario.ejecutar(idUsuario,idRutina);
    }

}