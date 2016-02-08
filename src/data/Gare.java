package data;

/**
 * Class Gare : ...
 * inherited from canton
 * @author AKTOR Alexis
 * 
 */

public class Gare extends Canton{
	
	private String type;
	
	/**
	 * @param type
	 * 	type of Gare
	 */
	
	public Gare(String type){
		super(type);
	}

	@Override
	public String toString() {
		return "Gare [name=" + type + "]";
	}

	public String getType() {
		return super.getType();
	}

	public void setType(String type) {
		super.setType(type);
	}

}
