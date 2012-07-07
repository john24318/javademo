package demo.java.util.concurrent.locks;

public class VolatileDemo implements Runnable {

	private volatile boolean stop;

	public void stopProcessing() {
		stop = true;
	}

	public void run() {
		while (!stop) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VolatileDemo target = new VolatileDemo();

		System.out.println("Begin");

		new Thread(target, "VolatileDemo").start();

		try {
			Thread.sleep(10000 - 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		target.stopProcessing();
		System.out.println("\nEnd");
	}

}
