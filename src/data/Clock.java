package data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import graphics.FirstViewController;

/**
 * Emulates a 24-hour clock used by the simulation.
 * @author Alex FOURGS
 */
public class Clock {
	private int hour ;
	private int minute ;
	private int second ;
	/**
	 * Initializes a new clock at 05:00:00
	 * */
	public Clock(){
		this.hour = 5 ;
		this.minute = 0 ;
		this.second = 0 ;
	}
	/**
	 * @return current hours
	 * */
	public synchronized int getHour(){
		return hour ;
	}

	/**
	 * @return current minutes
	 * */
	public synchronized int getMinute(){
		return minute ;
	}
	/**
	 * @return current seconds
	 * */
	public synchronized int getSecond(){
		return second ;
	}
	/**
	 * @param hour hour to set
	 * */
	private void setHour(int hour){
		this.hour = hour ;
	}

	/**
	 * @param minute minutes to set
	 * */
	private void setMinute(int minute){
		this.minute = minute ;
	}

	/**
	 * @param second seconds to set
	 * */
	private void setSecond(int second){
		this.second = second ;
	}
	/**
	 * Sets the clock at a precise hour, minutes and seconds, in a thread safe method
	 * 
	 * @param hour hour to set
	 * @param minute minutes to set
	 * @param second seconds to set
	 * */
	public synchronized void setClock(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
		}
	/**
	 * Get a string representing the current hour in a human-readable format
	 * 
	 * @returns the human-readable string
	 * */
	public String toString(){
		return (this.hour + ":" + this.minute + ":" + this.second);
	}
	
	public Date getTime(){
		Date time = new Date() ;
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {
			time = timeFormat.parse(hour + ":" + minute + ":" + second);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		return time ;
	}
}
