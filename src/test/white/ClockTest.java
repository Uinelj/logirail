package test.white;

import data.Clock;
import engine.ClockThread;

/**
 * 
 * @author alex
 *	Class for test the clock.
 */
public class ClockTest {
	public static void main(String[] args) {
		//Thread.stop();
		Clock clock = new Clock();
		ClockThread clockR = new ClockThread(clock);
		Thread clockT = new Thread(clockR);
		clockT.start();
		System.out.println("thread demarre");
		try {
			System.out.println("Sleep 5 secondes");
			clockT.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clockT.interrupt();
		if(clockT.isInterrupted()){
			System.out.println("Thread interrompu");
		}
		else {
			System.out.println("Thread pas interrompu");
		}
	}
}
