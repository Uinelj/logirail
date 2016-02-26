package data;
/**
 * Represents a road that some train will do. 
 * A MissionCode is a succession of stations. Now it's just station IDs, but it may soon be stations themselves.
 * Each running train has a MissionCode assigned to it.
 * @author AKTOR Alexis
 * 
 */

import java.util.ArrayList;
//TODO : Keep coherence between misionCode and MissionCodeDatabase
public class MissionCode {
	private String name;
	private ArrayList<Integer> road;
	
	/**
	 * @param name CodeMission name (NORA, UPEC..)
	 * @param road List of stations IDs of the codeMission
	 */ 
	

	public MissionCode(String name, ArrayList<Integer> road){
		this.name = name;
		this.road = road;
	}
	
	public String getName(){
		return name;
	}
	public ArrayList<Integer> getRoad(){
		return road;
	}
	
	public String toString(){
		String ret = "";
		for(Integer i : road){
			ret += i + " ";
		}
		return ret;
	}	
} 
