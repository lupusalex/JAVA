package classes;

import java.util.Random;

public class SyncedThread implements Runnable{
	private static Random random = new Random();
	private static int a = 0;
	private static int b = 0;
	private static Object lock = new Object();

	private String name;
	
	public SyncedThread(String name) {
		this.name = name;
	}
	
	private void method() {
		synchronized (lock) {
			System.out.printf("%s: a=%d b=%d\r\n", name, a, b);
			a++;
			try {
				Thread.sleep(random.nextInt(3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b++;
		}
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			method();
		}
	}

}
