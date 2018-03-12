/**
 * 
 */
package almundo.modelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Permite maneajar la informacion de los diferentes tipos de empleados
 * 
 * @author camilo
 *
 */

@Component
public class Empleado {
	
	private static Logger log = LoggerFactory.getLogger(Empleado.class);
	
	private long identificacion;
	
	private String nombre;
	
	private TipoEmpleado tipo;
	
	public static void atenderLlamada(TipoEmpleado tipo, String codigoLlamada) {
		
		if(tipo == TipoEmpleado.OPERADOR) {
			log.info("Operador atendiendo llamada numero " + codigoLlamada);
		
		} else if(tipo == TipoEmpleado.SUPERVISOR) {
			log.info("Supervisor atendiendo llamada numero " + codigoLlamada);
		
		} else if (tipo == TipoEmpleado.DIRECTOR) {
			log.info("Director atendiendo llamada numero " + codigoLlamada);
		}
		
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoEmpleado getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpleado tipo) {
		this.tipo = tipo;
	}
	
}
