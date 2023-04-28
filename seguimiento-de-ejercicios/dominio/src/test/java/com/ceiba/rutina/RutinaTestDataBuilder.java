package com.ceiba.rutina;

import com.ceiba.rutina.modelo.entidad.Rutina;
import com.ceiba.usuario.UsuarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RutinaTestDataBuilder {
    private Long id;
    private String descripcion;
    private String objetivo;
    private Usuario usuario;

    public RutinaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public RutinaTestDataBuilder conObjetivo(String objetivo) {
        this.objetivo = objetivo;
        return this;
    }

    public RutinaTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public RutinaTestDataBuilder conUsuarioPorDefecto() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha_nac = formato.parse("23/11/2001");
            this.usuario = new UsuarioTestDataBuilder()
                    .conNombre("Genesis")
                    .conContrasenia("0123456789")
                    .conCorreo("genesis@gmail.com")
                    .conFechaNacimiento(fecha_nac)
                    .conPeso((float)64)
                    .reconstruir();
        } catch (ParseException e){
            throw new RuntimeException("Formato de fecha incorrecto");
        }
        return this;
    }

    public Rutina reconstruir() {
        return Rutina.reconstruir(id, descripcion, objetivo, usuario);
    }
}
