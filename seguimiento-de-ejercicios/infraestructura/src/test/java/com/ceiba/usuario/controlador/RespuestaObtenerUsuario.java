package com.ceiba.usuario.controlador;

import com.ceiba.usuario.modelo.dto.UsuarioDTO;

public class RespuestaObtenerUsuario {
    private UsuarioDTO valor;

    public RespuestaObtenerUsuario() {
    }

    public RespuestaObtenerUsuario(UsuarioDTO valor) {
        this.valor = valor;
    }

    public UsuarioDTO getValor() {
        return this.valor;
    }
}
