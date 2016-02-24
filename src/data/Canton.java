package data;

/**
 * Class Canton : ...
 * @author AKTOR Alexis
 * 
 */
public class Canton {
	

	private int id;
	private int lenght;
	
	
	
	public Canton(int id, int lenght){
		this.id = id;
		this.lenght = lenght;
	}
	
	public int getId() {
		return id;
	}

	public int getLenght(){
		return lenght;
	}

	@Override
	public String toString() {
		return "Canton [id=" + id + "]";
	}

	


}
