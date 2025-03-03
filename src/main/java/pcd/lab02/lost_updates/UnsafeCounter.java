package pcd.lab02.lost_updates;

public class UnsafeCounter {

	private int cont;
	
	public UnsafeCounter(int base){
		this.cont = base;
	}
	
	/*public void inc(){
		// se fatto qui il syncronize, delego la thread safeness
		// all'operazione di incremento
		synchronized (this) {
			cont++;
		}
	}*/

	public synchronized void inc() {
		// se creato così rendo sincronizzato direttamente il metodo
		cont++;
	}
	
	public int getValue(){
		synchronized (this) {
			return cont;
		}
	}
}
