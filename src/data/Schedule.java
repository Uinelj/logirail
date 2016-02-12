package data;

import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private ArrayList<Date> schedules = new ArrayList<Date>();

	public Schedule (){
		
	}
	
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
	public void scheduleForOneMission(String code) {
		File json = new File("data/schedule.json");
		JSONParser fileParser = new JSONParser();
		String schedulesNotParsed = "" ;
		
        try {
 
            Object obj = fileParser.parse(new FileReader(json));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray schedulesArray = (JSONArray) jsonObject.get("Schedules");
            
            Iterator it = schedulesArray.iterator();
            	while (it.hasNext()) { 
	            	JSONObject innerObj = (JSONObject) it.next();
	            	
	            	if (((String) innerObj.get("MissionCode")).equals(code)){
	            		schedulesNotParsed = (String)innerObj.get("schedules");
	            		
	            		// Parsing des horaires de départ séparer par le caractères ";"
	            		for (String schedule : schedulesNotParsed.split(";")){
	            			// Conversion de string en objet Date (UNIX).
	            			DateFormat format = new SimpleDateFormat("hh:mm:ss");
	            			Date date = format.parse(schedule);
	            			
	            			schedules.add(date);
	            			
	            		}
	            		// Parser par rapport aux points virgules et ajouter chaque date dans schedulesFromJson.
	            		
	            		break ;
	            	}
            	}
            	
        } catch (Exception e) {
            e.printStackTrace();
        }
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
