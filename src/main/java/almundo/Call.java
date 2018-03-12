/**
 * 
 */
package almundo;

import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase encargada de instanciar o crear las llamadas
 * 
 * @author camilo
 *
 */
public class Call implements Runnable {
	
	private static Logger log = LoggerFactory.getLogger(Call.class);
	
	private String code;
	
	public Call(String s) {
		this.code = s;
	}

	public void run() {

		log.info(" Iniciando llamada numero = " + code + " con Hilo : " + Thread.currentThread().getName());
		duracionLlamada();
		Dispatcher.dispatchCall(this);
	}

	public void duracionLlamada() {
		try {
			int numero = ThreadLocalRandom.current().nextInt(5, 11);
			Thread.sleep(numero * 1000 );
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
