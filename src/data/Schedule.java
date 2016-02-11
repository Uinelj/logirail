package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

import Json.JSONArray;
import Json.JSONObject;
import Json.JSONParser;

/**
 * 
 * @author Alexandre Fourgs 
 * Schedules depending on the mission code. This class
 * parse a JSON file for save the schedules.
 * 
 */
public class Schedule {
	private String code;
	private ArrayList<Time> schedules = new ArrayList<Time>();

	public Schedule(String code) {
		this.code = code ;
	}

	/**
	 * 
	 * @param code is a string of the code mission.
	 * @return the object schedule from the mission with the code "code".
	 * 
	 * Pas fini.
	 */
	public Schedule scheduleForOneMission(String code) {
		Schedule sch = new Schedule(code);
		ArrayList<Time> schedulesFromJson = new ArrayList<Time>();
		File json = new File("../../data/schedules.json");
		JSONParser fileParser = new JSONParser();
		String schedulesNotParsed = "" ;
		
        try {
 
            Object obj = fileParser.parse(new FileReader(json));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray schedulesArray = (JSONArray) jsonObject.get("schedules");

            Iterator it = schedulesArray.iterator();
            	while (it.hasNext()) { 
	            	JSONObject innerObj = (JSONObject) it.next();
	            	
	            	if (((String) innerObj.get("MissionCode")).equals(code)){
	            		schedulesNotParsed = (String)innerObj.get(schedules);
	            		// Parser par rapport aux points virgules et ajouter chaque date dans schedulesFromJson.
	            		
	            		break ;
	            	}
            	}
            	
        } catch (Exception e) {
            e.printStackTrace();
        }

        sch.setSchedules(schedulesFromJson);
        
		return sch;
	}
	
	public String getCode(){
		return code ;
	}
	
	public ArrayList<Time> getSchedules(){
		return schedules;
	}
	
	public void setCode (String code){
		this.code = code ;
	}
	
	public void setSchedules (ArrayList<Time> schedules){
		this.schedules = schedules ;
	}
	
	public String toString() {
		return "" ;
	}

}
