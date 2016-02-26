package data;

/**
 * The representation of a physical block where the train can be. A Canton can either be a station, or just a rails block.
 * Each block can have one train simultaneously inside.
 * @author AKTOR Alexis
 * 
 */
//TODO: Rename to block ?
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
