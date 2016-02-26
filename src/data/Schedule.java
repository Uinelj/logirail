package data;

import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * @author Alexandre Fourgs 
 * Schedules depending on the mission code. This class
 * parse a JSON file to save the schedules.
 * 
 */
public class Schedule {
	private String missionCode;
	private ArrayList<Date> dates = new ArrayList<Date>();
	/**
	 * 
	 * @param missionCode Missioncode to be scheduled
	 */
	public Schedule(String missionCode) {
		this.missionCode = missionCode ;
	}
	
	
	public String getCode(){
		return missionCode ;
	}
	
	public ArrayList<Date> getDates(){
		return dates;
	}
	
	public void setCode (String missionCode){
		this.missionCode = missionCode ;
	}
	
	public void setDates (ArrayList<Date> dates){
		this.dates = dates ;
	}
	
	public String toString() {
		String message ;
		String mission = "Code mission : " + missionCode ;
		
		message = mission + "\n" ;
		message = message + "Horaires :\n" ;
		
		for (int i = 0 ; i < dates.size() ; i++){
			message = message + dates.get(i).toString() + "\n" ;
		}
		
		return message ;
	}

}
