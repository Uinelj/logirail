package data;

/**
 * Class Gare : ...
 * inherited from canton
 * @author AKTOR Alexis
 * 
 */

public class Gare extends Canton{
	
	private String name;
	private int id;
	
	/**
	 * @param type
	 * 	type of Gare
	 */
	
	public Gare(String name, int id){
		super(name, id);
		this.setId(id);
		this.setName(name);
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String type) {
		super.setName(type);
	}
	
	public int getId(){
		return super.getId();
	}
	
	public void setId(){
		super.setId(id);
	}

	@Override
	public String toString() {
		return "Gare [name=" + super.getName() + ", id=" + super.getId() + "]";
	}


}
