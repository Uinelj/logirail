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
public class CantonDataBase {
	private HashMap<Integer, Canton> cantons;
	private String path = "data/cantons.json";
	private static CantonDataBase INSTANCE = new CantonDataBase();
	private CantonDataBase(){
		this.cantons = new HashMap<Integer, Canton>();
		loadJsonGare(path);
	}

	
	/**
	 * Populates the HashMap following the JSON's data.
	 * @param file Path to the JSON file.
	 */
	void loadJsonGare(String file){
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(file));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lang = (JSONArray) jsonObject.get("cantons"); //why lang?
            int id;
            int lenght;
            Iterator it = lang.iterator();
            while(it.hasNext()){
            	JSONObject innerObj = (JSONObject) it.next();
            	//System.out.println(innerObj);
            	//Ugly, but the lib doesnt provide some way to get strings.
            	lenght = Integer.parseInt((String) innerObj.get("lenght"));
            	id = Integer.parseInt((String) innerObj.get("id"));
            	cantons.put(Integer.parseInt((String)innerObj.get("id")), new Canton(id, lenght));
            }
        	
            	
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public Canton getGare(int id){
		return cantons.get(id);
	}
	/**
	 * Returns the GareDataBase object initialized.
	 * @return The instance of the GareDataBase.
	 */
	public static CantonDataBase getInstance(){
		return INSTANCE;
	}
	@Override
	public String toString() {
		return "GareDataBase [gares=" + cantons + "]";
	}

	

}
