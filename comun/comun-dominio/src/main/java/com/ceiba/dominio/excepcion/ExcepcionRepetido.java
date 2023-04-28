package com.ceiba.dominio.excepcion;

public class ExcepcionRepetido extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionRepetido(String mensaje) {
        super(mensaje);
    }
}
