package engine;

import java.util.Calendar;

import data.Clock;

/**
 * 
 * @author Alexandre Fourgs
 *	This class is the a basic clock's engine.
 *	It works with a thread.
 */
public class ClockThread implements Runnable {
	private int speed ;
	private Calendar time = Calendar.getInstance() ;
	private Clock clock ;
	
	/**
	 * Constructor with basic speed (1).
	 */
	public ClockThread(Clock clock){
		this.speed = 1 ;
		time.set(00, 00, 00, 00, 00, 00);
		this.clock = clock ;
	}
	
	/**
	 * 
	 * @param speed is an integer for control the speed of the time.
	 * @param clock is an object that contains the clock data : hours, minute & second.
	 * Constructor with parameter for the speed.
	 */
	public ClockThread(int speed, Clock clock){
		this.speed = speed ;
		time.set(00, 00, 00, 00, 00, 00);
		this.clock = clock ;
	}
	
	/**
	 * Thread run function which increment the seconds and stop when it's 23:59:59.
	 */
	public void run() {
		while(((time.get(Calendar.HOUR_OF_DAY)!=23) 
				|| (time.get(Calendar.MINUTE)!=59) 
				|| (time.get(Calendar.SECOND)!=59))
				|| (!Thread.currentThread().isInterrupted())){
			try{
				Thread.sleep(1000/speed);
				time.add(Calendar.SECOND, 1);
				clock.setClock(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.SECOND));
				
				System.out.println(clock.toString());
			}
			catch(InterruptedException ie){
				
			}
		}
	}
	
	public void setSpeed(int speed){
		this.speed = speed ;
	}
}
