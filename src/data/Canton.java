package data;

/**
 * Class Canton : ...
 * @author AKTOR Alexis
 * 
 */
public class Canton {
	

	private int id;
	/**
	 * @param name
	 * name of canton
	 */
	public Canton(int id){
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Canton [id=" + id + "]";
	}

	public void setId(int id) {
		this.id = id;
	}



}
