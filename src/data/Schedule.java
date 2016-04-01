package data;

import java.util.Date;
import java.util.ArrayList;

/**
 * 
 * @author Alexandre Fourgs 
 * Schedules depending on the mission code. This class
 * parses a JSON file to save the schedules.
 * 
 */
public class Schedule {
	private String missionCode;
	private ArrayList<Date> dates = new ArrayList<Date>();
	/**
	 * 	Constructor for a Schedule following a MissionCode. 
	 * @param missionCode Missioncode to be scheduled
	 */
	public Schedule(String missionCode) {
		this.missionCode = missionCode ;
	}
	
	/**
	 * @return missionCode the missionCode assigned to this Schedule.
	 * */
	public String getCode(){
		return missionCode ;
	}
	/**
	 * @return date ArrayList of the scheduled dates
	 * */
	public ArrayList<Date> getDates(){
		return dates;
	}
	/**
	 * @param missionCode the mission code to set 
	 * */
	public void setCode (String missionCode){
		this.missionCode = missionCode ;
	}
	/**
	 * @param dates an ArrayList of dates to be put on the Schedule
	 * */
	public void setDates (ArrayList<Date> dates){
		this.dates = dates ;
	}
	
	public String toString() {
		String message ;
		String mission = "Code mission : " + missionCode ;
		
		message = mission + "\n" ;
		message = message + "Horaires :\n" ;
		//TODO : Faire ca avec un iterateur ? 
		for (int i = 0 ; i < dates.size() ; i++){
			message = message + dates.get(i).toString() + "\n" ;
		}
		
		return message ;
	}
	
	public boolean equals(Schedule schedule) {
		if( (this.missionCode.equals(schedule.getCode())) && ( this.dates.equals(schedule.getDates()) )) {
			return true;
		}
		return false;
	}

}
