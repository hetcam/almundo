/**
 * 
 */
package almundo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Clase que permite iniciar la aplicacion
 * 
 * @author camilo
 *
 */
@SpringBootApplication
public class Run implements ApplicationRunner {
	
	private static Logger log = LoggerFactory.getLogger(Run.class);
	
	private static final int NUMERO_LLAMADAS = 10;
	/**
	 * Ejecuta la creacion de las llamadas, inicia con 10 llamadas	
	 */
	public void run(ApplicationArguments args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(NUMERO_LLAMADAS);
		
		for (int i = 0; i < NUMERO_LLAMADAS; i++) {
			Runnable worker = new Call("" + i);
			executor.execute(worker);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		log.info("Finalizando todas las llamadas");
		
	}
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }

}
