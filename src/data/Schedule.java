package data;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

<<<<<<< HEAD
import Json.JSONArray;
import Json.JSONObject;
import Json.JSONParser;
=======
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
>>>>>>> 2f6fce00c5811ff125e2d275f53867aa74efd440

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
	
	/**
	 * 
	 * @return an ArrayList of all schedules for every mission.
	 * This method parse the schedules JSON file, and create an object "Schedule" for all of them.
	 * Then, it put this object into an ArrayList and return it.
	 * 
	 */
	public ArrayList<Schedule> schedulesParsing () {
		ArrayList<Schedule> listSchedules = new ArrayList<Schedule>();
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
            	Schedule actual = new Schedule((String)innerObj.get("MissionCode"));
            	
	            schedulesNotParsed = (String)innerObj.get("schedules");
	            		
	           	// Parsing des horaires de départ séparer par le caractères ";"
	           	for (String schedule : schedulesNotParsed.split(";")){
	           		// Conversion de string en objet Date (UNIX).
	           		DateFormat format = new SimpleDateFormat("hh:mm:ss");
	           		Date date = format.parse(schedule);
	            			
	           		actual.getSchedules().add(date);
	            			
	           	}
	           	listSchedules.add(actual);	
	            	
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listSchedules ;
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
