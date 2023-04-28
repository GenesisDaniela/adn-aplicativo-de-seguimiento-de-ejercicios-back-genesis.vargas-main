package com.ceiba.infraestructura.actuator;

import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;

/**
 * Interface que tiene por objetivo ser implementada por todos los bloques 
 * que quieran utilizar HealthCheck
 * 
 * @author sergio.villamizar
 *
 */

public interface Salud  {
	/**
	 * Registra los bloques implementados
	 */
    void registrarBloque();
	
	/**
	 * Valida la salud del bloque
	 * @throws ExepcionBloqueSinServicio
	 */
    void verificar() throws ExcepcionTecnica;//a�adir

}
