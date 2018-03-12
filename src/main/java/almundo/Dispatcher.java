/**
 * 
 */
package almundo;

import almundo.modelo.Empleado;
import almundo.modelo.TipoEmpleado;

/**
 * Clase manejadora de las llamadas, asigna a cada empleado una llamada si est&aacute;
 * libre. Se pueden procesar cualquier cantidad o n&uacute;mero de llamadas <br><br>
 * 
 * El proceso de atenci&oacute;n inicia con un empleado tipo operador, si &eacute;ste est&aacute; ocupado, se contin&uacute;a 
 * con el supervisor, si tambi&eacute;n est&aacute; ocupado se redirige la llamada al director. <br><br>
 * 
 * Si todos los empleados est&aacute;n ocupados se vuelve a llamar recursivamente el m&eacute;todo <b>dispatchCall</b>,
 * de esta forma, vuelve a buscar cual empleado est&aacute; libre para asignarle la llamada.
 * 
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
