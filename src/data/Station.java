package data;

import engine.Canton;

/**
 * Represents a physical station, which is on the train line
 * @author AKTOR Alexis
 * 
 */
//TODO : Call this a station ?
public class Station extends Canton{
	
	private String name;
	private int id;
	
	/**
	 * Gare constructor
	 * 
	 * @param name Real name of the station
	 * @param id ID of the station, following the data folder
	 * */
	public Station(String name, int id){
		super(id, 0);
		this.id = id;
		this.setName(name);
	}

	
	/**
	 * Get the station's information in a human-readable format
	 * */
	@Override
	public String toString() {
		return "Gare [name=" + name + ", id=" + id + "]";
	}


	/**
	 * @return id id of the station
	 * */
	public int getId(){
		return id;
	}

	/**
	 * @return the name of the station
	 * */
	public String getName() {
		return name;
	}


	/**
	 * @param name New station name to set
	 * */
	public void setName(String name) {
		this.name = name;
	}

	

}
