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
		Clock clock = new Clock();
		ClockThread clockR = new ClockThread(clock);
		Thread clockT = new Thread(clockR);
		clockT.start();
		
		while(clockT.isAlive()){
			
			if ((clock.getSecond()) == 10){
				System.out.println("10 secondes !");
				//Thread.currentThread().interrupt();
				clockT.interrupt();
				clockR.setSpeed(2);
				try{
					System.out.println("Sleep");
					Thread.sleep(50000);
				}
				catch(InterruptedException ie){
					System.out.println("Exception sleep");
				}
			}
			else if((clock.getSecond())==20){
				System.out.println("20 secondes !");
				clockR.setSpeed(4);
			}
		}	
	}
}
