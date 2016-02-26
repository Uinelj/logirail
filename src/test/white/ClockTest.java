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
		ClockThread clockT = new ClockThread(clock);
		clockT.start();
		
		while(clockT.isAlive()){
			
			if ((clock.getSecond()) == 10){
				System.out.println("10 secondes !");
				clockT.setSpeed(2);
				try{
					clockT.sleep(5*1000);
				}
				catch(InterruptedException ie){
					
				}
			}
		}	
	}
}
