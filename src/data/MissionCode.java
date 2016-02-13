package data;
/**
 * Class MissionCode : set of all canton of a trajectory
 * @author AKTOR Alexis
 * 
 */

import java.util.LinkedList;
//TODO : Keep coherence between misionCode and MissionCodeDatabase
public class MissionCode {
	private String name;
	private LinkedList<Canton> trajectory;
	
	/**
	 * @param name
	 * 	name of the codeMission. 
	 * 	ex : NORA, ...
	 */
	

	public MissionCode(String name, LinkedList<Canton> trajectory){
		this.setName(name);
		this.setTrajectory(trajectory);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Canton> getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(LinkedList<Canton> trajectory) {
		this.trajectory = trajectory;
	}
	
	public void addFist(Canton canton){
		trajectory.addFirst(canton);
	}
	
	public void addLast(Canton canton){
		trajectory.addLast(canton);
	}
	
	public void add(Canton canton, int position){
		trajectory.add(position, canton);
	}

}
