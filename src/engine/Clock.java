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
		while((time.get(Calendar.HOUR_OF_DAY)!=23) || (time.get(Calendar.MINUTE)!=59) || (time.get(Calendar.SECOND)!=59)){
			try{
				Thread.sleep(1000/speed);
				time.add(Calendar.SECOND, 1);
				System.out.println(time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE) + ":" + time.get(Calendar.SECOND));
			}
			catch(InterruptedException ie){
				
			}
		}
	}
}
