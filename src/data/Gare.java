package data;

/**
 * Represents a physical station, which is on the train line.
 * @author AKTOR Alexis
 * 
 */
//TODO : Call this a station ?
public class Gare extends Canton{
	
	private String name;
	private int id;
	/**
	 * @param type
	 * 	type of Gare
	 */
	
	public Gare(String name, int id){
		super(id, 0);
		this.setId(id);
		this.setName(name);
	}

	
	
	@Override
	public String toString() {
		return "Gare [name=" + name + ", id=" + id + "]";
	}



	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	

}
