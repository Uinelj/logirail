package data;

/**
 * 
 * @author alex
 *	This class is the clock's data : hour value, minute value & second value.
 */
public class Clock {
	private int hour ;
	private int minute ;
	private int second ;
	
	public Clock(){
		this.hour = 0 ;
		this.minute = 0 ;
		this.second = 0 ;
	}
	
	public synchronized int getHour(){
		return hour ;
	}
	
	public synchronized int getMinute(){
		return minute ;
	}
	
	public synchronized int getSecond(){
		return second ;
	}
	
	private void setHour(int hour){
		this.hour = hour ;
	}
	
	private void setMinute(int minute){
		this.minute = minute ;
	}
	
	private void setSecond(int second){
		this.second = second ;
	}
	
	public synchronized void setClock(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public String toString(){
		return (this.hour + ":" + this.minute + ":" + this.second);
	}
}
