package data;

/**
 * Represents a physical station, which is on the train line
 * @author AKTOR Alexis
 * 
 */
//TODO : Call this a station ?
public class Gare extends Canton{
	
	private String name;
	private int id;
	
	/**
	 * Gare constructor
	 * 
	 * @param name Real name of the station
	 * @param id ID of the station, following the data folder
	 * */
	public Gare(String name, int id){
		super(id, 0);
		this.setId(id);
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
	//TODO: Virer cette fonction ? Elle est dangeureuse, dans le sens ou du coup tu peux changer l'ID d'une gare, sans changer son nom.
	/**
	 * @param id new id of the station
	 * */
	public void setId(int id){
		this.id = id;
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
