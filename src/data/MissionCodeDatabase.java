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
/**
 * This class contains all the mission codes. 
 * It is built by parsing a JSON file, which is by default at data/missioncodes.json, but we can specify another path to the constructor.
 * 
 * @author Julien Abadji
 * */
public class MissionCodeDatabase {
	//TODO : SafetyChecks, clean the code.
	//TODO : Make it a singleton.
	//TODO : Don't hardcode missioncodedatabase, road and name.
	//TODO : Does the missionCodeDatabase has to contain Gares ? 
	private String dbPath;
	private HashMap<String, ArrayList<Integer>> missionCodeDatabase = new HashMap<String, ArrayList<Integer>>();
	/**
	 * Constructor for the MissionCodeDatabase object. 
	 * 
	 * @param path Path to the JSON file.
	 * */
	public MissionCodeDatabase(String path){
		dbPath = path;
		parseJson(path);
	}
	
	public MissionCodeDatabase(){
		this("data/missioncodes.json");
	}
	/**
	 * Opens and parses the JSON file, constructing an HashMap of Gares/Cantons(blocks), which the key is the missioncode.
	 * 
	 * @param path Path to the JSON file.
	 * 
	 * @throws IOException if there's a problem accessing/reading the file from its path.
	 * @throws ParseException if the file is not a valid JSON file. 
	 * */
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
				missionCodeDatabase.put(missionCode.get("name").toString(), (ArrayList<Integer>) currentMissionCodeRoad.clone());
				currentMissionCodeRoad.clear();
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Repopulates the HashMap, in case of JSON file modification during the execution of the program.
	 * */
	// TODO: Make it actually work by emptying the HashMap before.
	public void reloadJson(){
		parseJson(dbPath);
	}
	//TODO : Is it more Trash oriented than Object oriented ?
	/**
	 * @return an ArrayList of the Gare ID's. May be modified soon.
	 * */
	public ArrayList<Integer> getRoute(String missionCode){
		return missionCodeDatabase.get(missionCode);
	}
}
