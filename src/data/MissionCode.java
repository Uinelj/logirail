package data;
/**
 * Class MissionCode : set of all canton of a trajectory
 * @author AKTOR Alexis
 * 
 */

import java.util.ArrayList;
//TODO : Keep coherence between misionCode and MissionCodeDatabase
public class MissionCode {
	private String name;
	private ArrayList<Integer> road;
	
	/**
	 * @param name
	 * 	name of the codeMission. 
	 * 	ex : NORA, ...
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
