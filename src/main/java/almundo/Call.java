/**
 * 
 */
package almundo;


/**
 * @author camilo
 *
 */
public class Call implements Runnable {
	
	private String code;

	public static boolean operadorOcupado = false;

	public Call(String s) {
		this.code = s;
	}

	public void run() {

		System.out.println(" Iniciando llamada numero = " + code + " con Hilo : " + Thread.currentThread().getName());
		duracionLlamada();
		Dispatcher.dispatchCall(this);
		// System.out.println(Thread.currentThread().getName() + " End.");

	}

	public void duracionLlamada() {
		try {
			// Thread.sleep((int) Math.random() * 1000 );
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
