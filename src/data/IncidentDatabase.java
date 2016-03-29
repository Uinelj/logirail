package data;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class contains all differents type of incident that can arrive.
 *  
 * @author Alexandre Fourgs
 *
 */
public class IncidentDatabase {
	private static IncidentDatabase INSTANCE = new IncidentDatabase();
	private HashMap<Integer, IncidentData> incidentDatabase = new HashMap<Integer, IncidentData>();
	
	private IncidentDatabase(){
		incidentDatabase = incidentParsing();
	}
	
	/**
	 * This method parse the .json file of incident and create it.
	 * 
	 * @return a HashMap object that contains all types of incident & informations about it.
	 * 
	 */
	private HashMap<Integer, IncidentData> incidentParsing(){
		HashMap<Integer, IncidentData> incidentDatabase = new HashMap<Integer, IncidentData>();
		File json = new File("data/incident.json");
		JSONParser fileParser = new JSONParser();
		
		try {
			Object obj = fileParser.parse(new FileReader(json));
			
			JSONObject jsonObject = (JSONObject) obj ;
			JSONArray schedulesArray = (JSONArray) jsonObject.get("Incident");
            
            Iterator it = schedulesArray.iterator();
            
            while (it.hasNext()) { 
            	JSONObject innerObj = (JSONObject) it.next();
            	
            	int id = (Integer)innerObj.get("Id");
            	
            	IncidentData actual = new IncidentData(id, (String)innerObj.get("Type"), (Integer)innerObj.get("Min_Time"), (Integer)innerObj.get("Max_Time"));
            			
	           	incidentDatabase.put(id, actual);	
            }
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		return incidentDatabase ;
	}
	
	/**
	 * Getter of the current initialized instance of IncidentDatabase
	 * @return the initialized instance of IncidentDatabase
	 */
	public static IncidentDatabase getInstance(){
		return INSTANCE ;
	}
	
	
	

}
