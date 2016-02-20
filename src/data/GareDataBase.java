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
/**
 * This class contains all the stations of the RER A.
 * It is built by parsing a JSON file, which is by default at data/gare.json, but we can specify another path to the constructor.
 * 
 * @author Abadji Julien
 *
 */
public class GareDataBase {
	private HashMap<Integer, Gare> gares;
	private String path = "data/gare.json";
	private static GareDataBase INSTANCE = new GareDataBase();
	private GareDataBase(){
		this.gares = new HashMap<Integer, Gare>();
		loadJsonGare(path);
	}

	
	/**
	 * Populates the HashMap following the JSON's data.
	 * @param file Path to the json file.
	 */
	private void loadJsonGare(String file){
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
	/**
	 * Returns the GareDataBase object initialized.
	 * @return The instance of the GareDataBase.
	 */
	public static GareDataBase getInstance(){
		return INSTANCE;
	}
	@Override
	public String toString() {
		return "GareDataBase [gares=" + gares + "]";
	}

	

}
