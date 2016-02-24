package engine;

import java.util.Calendar;

/**
 * 
 * @author alex
 *	This class is a basic clock.
 */
public class Clock extends Thread {
	private int speed ;
	private Calendar time = Calendar.getInstance() ;
	
	/**
	 * Constructor with basic speed (1).
	 */
	public Clock(){
		this.speed = 1 ;
		time.set(00, 00, 00, 00, 00, 00);
	}
	
	/**
	 * 
	 * @param speed is an integer for control the speed of the time.
	 * Constructor with parameter for the speed.
	 */
	public Clock(int speed){
		this.speed = speed ;
		time.set(00, 00, 00, 00, 00, 00);
	}
	
	/**
	 * Thread run function which increment the seconds.
	 */
	public void run() {
		int i = 0 ;
		while(i != 1){
			try{
				Thread.sleep(1000/speed);
				time.add(Calendar.SECOND, 1);
				System.out.println(time.getTime());
			}
			catch(InterruptedException ie){
				
			}
		}
	}
}
