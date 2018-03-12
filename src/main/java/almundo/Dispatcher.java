/**
 * 
 */
package almundo;

/**
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
				// call.duracionLlamada();
				System.out.println("Operador atendiendo llamada numero " + call.getCode());

				operadorOcupado = false;
			}

		} else if (!supervisorOcupado) {
			supervisorOcupado = true;
			synchronized (Dispatcher.class) {
				// call.duracionLlamada();
				System.out.println("Supervisor atendiendo llamada numero " + call.getCode());

				supervisorOcupado = false;
			}

		} else if (!directorOcupado) {
			directorOcupado = true;
			synchronized (Dispatcher.class) {
				// call.duracionLlamada();
				System.out.println("Director atendiendo llamada numero " + call.getCode());
				directorOcupado = false;
			}
		} else {
			synchronized (Dispatcher.class) {
				dispatchCall(call);
			}
		}

	}
}
