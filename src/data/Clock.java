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
	
	public int getHour(){
		return hour ;
	}
	
	public int getMinute(){
		return minute ;
	}
	
	public int getSecond(){
		return second ;
	}
	
	public void setHour(int hour){
		this.hour = hour ;
	}
	
	public void setMinute(int minute){
		this.minute = minute ;
	}
	
	public void setSecond(int second){
		this.second = second ;
	}
	
	public String toString(){
		return (this.hour + ":" + this.minute + ":" + this.second);
	}
}
