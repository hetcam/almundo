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
	
	private static final int NTHREADS = 10;
		
	public void run(ApplicationArguments args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		
		for (int i = 0; i < 10; i++) {
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
