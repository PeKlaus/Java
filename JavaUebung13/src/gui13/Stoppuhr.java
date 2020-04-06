package gui13;

public class Stoppuhr extends Thread {
	public void run() {
		long zeit;
		long startzeit = System.currentTimeMillis() / 1000;
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			zeit = System.currentTimeMillis() / 1000 - startzeit;
			System.out.println(zeit);
		}
	}

}
