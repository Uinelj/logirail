package data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MissionCodeDatabase {
	//TODO : SafetyChecks, clean the code.
	//TODO : Make it a singleton.
	//TODO : Don't hardcode missioncodedatabase, road and name.
	//TODO : Does the missionCodeDatabase has to contain Gares ? 
	private String dbPath;
	private HashMap<String, ArrayList<Integer>> missionCodeDatabase = new HashMap<String, ArrayList<Integer>>();

	public MissionCodeDatabase(String path){
		dbPath = path;
		parseJson(path);
	}
	
	public MissionCodeDatabase(){
		this("data/missioncodes.json");
	}
	
	private void parseJson(String path){
		
		final JSONParser parser = new JSONParser();
		JSONObject jsonObject, missionCode;
		JSONArray road;
		ArrayList<Integer> currentMissionCodeRoad = new ArrayList<Integer>();
		
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader(path));
			jsonObject = (JSONObject) jsonObject.get("missioncodedatabase");
			
			for(String curKey : (Set<String>) jsonObject.keySet()){
				missionCode = (JSONObject) jsonObject.get(curKey);
				road = (JSONArray) missionCode.get("road");
				if (road != null) { 
					   for (int i=0;i<road.size();i++){ 
					    currentMissionCodeRoad.add(Integer.parseInt(road.get(i).toString()));
					   } 
					}
				//System.out.println(currentMissionCodeRoad);
				//System.out.println(missionCode.get("name").toString());
				missionCodeDatabase.put(missionCode.get("name").toString(), (ArrayList<Integer>) currentMissionCodeRoad.clone());
				currentMissionCodeRoad.clear();
			}
			//System.out.println(missionCodeDatabase);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void reloadJson(){
		parseJson(dbPath);
	}
	public ArrayList<Integer> getRoute(String missionCode){
		return missionCodeDatabase.get(missionCode);
	}
}
