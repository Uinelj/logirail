package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class MissionCodeDatabase : dataBase of all codeMissions
 * @author AKTOR Alexis
 * 
 */
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MissionCodeDatabase {
	HashMap<String, ArrayList<String>> missionCodeDatabase;
	
	public MissionCodeDatabase(){
		final JSONParser parser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("data/missioncodes.json"));
			//TODO : Adapter cela :)
			/*public void populateResult(){
				jo = new JSONObject(jsonAnswer);
				Iterator<String> keysItr = jo.keys();
				while(keysItr.hasNext()){
					String key = keysItr.next();
					String value = jo.get(key).toString();
					result.put(key, value);
				}
			}*/

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
