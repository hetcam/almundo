/**
 * 
 */
package almundo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author camilo
 *
 */
@SpringBootApplication
public class Run implements ApplicationRunner {
	
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
		System.out.println("Finalizando todas las llamadas");
		
	}
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }

}
