package data;
/**
 * Class MissionCode : set of all canton of a trajectory
 * @author AKTOR Alexis
 * 
 */

import java.util.ArrayList;
//TODO : Keep coherence between misionCode and MissionCodeDatabase
public class MissionCode {
	private String id;
	private ArrayList<Integer> missionCode;
	
	/**
	 * @param id
	 * 	name of the codeMission. 
	 * 	ex : NORA, ...
	 */ 
	

	public MissionCode(){
		missionCode = new ArrayList<Integer>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void add(Integer value){
		missionCode.add(value);
	}
  
} 
