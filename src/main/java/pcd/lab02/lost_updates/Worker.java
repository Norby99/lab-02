package pcd.lab02.lost_updates;


public class Worker extends Thread {
	
	private UnsafeCounter counter;
	private int ntimes;
	
	public Worker(String name, UnsafeCounter counter, int ntimes){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
	}
	
	public void run(){
		log("started");
		for (int i = 0; i < ntimes; i++) {
			// se faccio il syncronized qui, rendo l'oggetto worker thread safe, ma non
			// la funzione di incremento. In poche parole l'operazione di increment
			// rimane unsafe
			//synchronized (counter) {
				counter.inc();
			//}
		}
		log("completed");
	}
	
	private void log(String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}
