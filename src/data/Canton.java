package data;

/**
 * Class Canton : ...
 * @author AKTOR Alexis
 * 
 */
public class Canton {
	
	private String name;
	private int id;
	/**
	 * @param name
	 * name of canton
	 */
	public Canton(String name, int id){
		this.setName(name);
		this.setId(id);
	}


	

	@Override
	public String toString() {
		return "Canton [name=" + name + ", id=" + id + "]";
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}

}
