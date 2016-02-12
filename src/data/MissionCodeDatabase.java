package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class MissionCodeDatabase : dataBase of all codeMissions
 * @author AKTOR Alexis
 * 
 */
import Json.JSONArray;
import Json.JSONObject;
import Json.JSONParser;
import Json.ParseException;

public class MissionCodeDatabase {
	ArrayList<MissionCode> dataBase;
	
	public MissionCodeDatabase(){
		final JSONParser parser = new JSONParser();
		try {
			final JSONObject jsonObject =  (JSONObject) parser.parse(new FileReader("data/missioncodes.json"));
			System.out.println(jsonObject.toString());
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
