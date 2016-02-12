package data;

import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * @author Alexandre Fourgs 
 * Schedules depending on the mission code. This class
 * parse a JSON file for save the schedules.
 * 
 */
public class Schedule {
	private String code;
	private ArrayList<Date> schedules = new ArrayList<Date>();
	
	public Schedule(String code) {
		this.code = code ;
	}
	
	
	public String getCode(){
		return code ;
	}
	
	public ArrayList<Date> getSchedules(){
		return schedules;
	}
	
	public void setCode (String code){
		this.code = code ;
	}
	
	public void setSchedules (ArrayList<Date> schedules){
		this.schedules = schedules ;
	}
	
	public String toString() {
		String message ;
		String mission = "Code mission : " + code ;
		
		message = mission + "\n" ;
		message = message + "Horaires :\n" ;
		
		for (int i = 0 ; i < schedules.size() ; i++){
			message = message + schedules.get(i).toString() + "\n" ;
		}
		
		return message ;
	}

}
