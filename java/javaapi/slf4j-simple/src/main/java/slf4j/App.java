package slf4j;

public class App {
    public static void main(String[] args) {
		runSimple();
    }
    
    public static void runSimple() {
    	Helios o = new Helios();
    	o.something();
    	try {
			Thread.sleep(1000); //let the logging stream (System.err) output everything
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
    }
}
