package data;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//TODO: Find a way to display accents.
//TODO: Javadoc
//TODO: Singleton
public class GareDataBase {
	//private ArrayList<Gare> gares;
	private HashMap<Integer, Gare> gares;
	public GareDataBase(){
		//this.gares= new ArrayList<Gare>();
		this.gares = new HashMap<Integer, Gare>();
		loadJsonGare("data/gare.json");
	}

	
	
	public void loadJsonGare(String file){
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(file));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lang = (JSONArray) jsonObject.get("gares"); //why lang?
            String currentStationName;
            int currentStationId;
            Iterator it = lang.iterator();
            while(it.hasNext()){
            	JSONObject innerObj = (JSONObject) it.next();
            	//System.out.println(innerObj);
            	//Ugly, but the lib doesnt provide some way to get strings.
            	currentStationName = (String) innerObj.get("name");
            	currentStationId = Integer.parseInt((String) innerObj.get("id"));
            	gares.put(Integer.parseInt((String)innerObj.get("id")), new Gare(currentStationName, currentStationId));
            }
        	
            	
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public Gare getGare(int id){
		return gares.get(id);
	}

	@Override
	public String toString() {
		return "GareDataBase [gares=" + gares + "]";
	}

	

}
