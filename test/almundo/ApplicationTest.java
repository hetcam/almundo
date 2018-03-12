/**
 * 
 */
package almundo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author camilo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	private static Logger log = LoggerFactory.getLogger(ApplicationTest.class);
	
	/**
	 * Test para realizar llamadas en numero mayor a 10.
	 * <br>
	 * Se hace una prueba con 200 llamdas.
	 * 
	 * @throws Exception
	 */
	@Test
    public void realizanLlamadas() throws Exception {
		
		final int NTHREADS = 200;
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		
		for (int i = 0; i < NTHREADS; i++) {
			Runnable worker = new Call("" + i);
			executor.execute(worker);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		log.info("Finalizando todas las llamadas");
    }

}
