/**
 * 
 */
package almundo;

import almundo.modelo.Empleado;
import almundo.modelo.TipoEmpleado;

/**
 * Clase manejadora de las llamadas, asigna a cada empleado una llamada si esta
 * libre
 * 
 * @author camilo
 *
 */
public class Dispatcher {
	
	private static boolean operadorOcupado = false;

	private static boolean supervisorOcupado = false;

	private static boolean directorOcupado = false;

	public static void dispatchCall(Call call) {

		if (!operadorOcupado) {
			operadorOcupado = true;
			synchronized (Dispatcher.class) {
				Empleado.atenderLlamada(TipoEmpleado.OPERADOR, call.getCode());
				// call.duracionLlamada();

				operadorOcupado = false;
			}

		} else if (!supervisorOcupado) {
			supervisorOcupado = true;
			synchronized (Dispatcher.class) {
				// call.duracionLlamada();
				Empleado.atenderLlamada(TipoEmpleado.SUPERVISOR, call.getCode());

				supervisorOcupado = false;
			}

		} else if (!directorOcupado) {
			directorOcupado = true;
			synchronized (Dispatcher.class) {
				// call.duracionLlamada();
				Empleado.atenderLlamada(TipoEmpleado.DIRECTOR, call.getCode());
				directorOcupado = false;
			}
		} else {

			/**
			 * 
			 * Ingresa aqui si no hay ningun empleado libre !!!
			 * 
			 */

			synchronized (Dispatcher.class) {
				dispatchCall(call);
			}
		}

	}
}
