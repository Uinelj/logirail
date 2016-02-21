package data;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * 
 * @author Alexandre Fourgs
 *
 */
public class ScheduleDatabase {
	private HashMap<String, Schedule> schedulesDatabase = new HashMap<String, Schedule>();
	private static ScheduleDatabase INSTANCE = new ScheduleDatabase();
	private ScheduleDatabase (){
		schedulesDatabase = schedulesParsing();
	}
	/**
	 * 
	 * @return an ArrayList of all schedules for every mission.
	 * This method parse the schedules JSON file, and create an object "Schedule" for all of them.
	 * Then, it put this object into an ArrayList and return it.
	 * 
	 */
	private HashMap<String, Schedule> schedulesParsing () {
		HashMap<String, Schedule> schedulesDatabase = new HashMap<String, Schedule>() ;
		String actualCode ;
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
            	
            	actualCode = actual.getCode();
            	
	            schedulesNotParsed = (String)innerObj.get("schedules");
	            		
	           	// Parsing des horaires de départ séparer par le caractères ";"
	           	for (String schedule : schedulesNotParsed.split(";")){
	           		// Conversion de string en objet Date (UNIX).
	           		DateFormat format = new SimpleDateFormat("hh:mm:ss");
	           		Date date = format.parse(schedule);
	            			
	           		actual.getSchedules().add(date);
	            			
	           	}
	           	schedulesDatabase.put(actualCode, actual);	
	            	
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return schedulesDatabase ;
	}
	
	public static ScheduleDatabase getInstance(){
		return INSTANCE;
	}
	public String toString() {
		String scheduleDB = "";
		
		// TODO toString ScheduleDatabase
		
		return schedulesDatabase.toString();
	}
}
