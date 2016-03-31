package engine;

/**
 * The representation of a physical block where the train can be. A Canton can either be a station, or just a rails block.
 * Each block can have one train simultaneously inside.
 * @author AKTOR Alexis
 * 
 */
//TODO: Rename to block ?
public class Canton {
	
	//TODO: ALEXIS Refais ta doc please
	/**
	 * @field id of the train
	 * @field size of the train
	 * @field give the state of the canton ( true : the canton is occupied, false : the canton is not occupied )
	 */
	
	private int id;
	private int length;
	private boolean isOccupied;

	
	/**
	 * Constructs a new Canton
	 * */
	public Canton(int id, int length){
		this.id = id;
		this.length = length;
	}
	
	public int getId() {
		return id;
	}

	public int getLength(){
		return length;
	}

	@Override
	public String toString() {
		return "Canton [id=" + id + "]";
	}
	
	/**
	 * Decide if a train can enter in a canton (ie. if the Canton is empty)
	 * @param Train the train to eventually enter into the Canton
	 */
	public synchronized void enter(Train train){
		
		if(isOccupied == true){
			System.out.println("no train");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("enter");
		isOccupied=true;
		train.setPosition();
	}

	/**
	 * Empty the Canton. Called when a train exits a canton
	 */
	public synchronized void exit() {
		System.out.println("exit");
		isOccupied = false;
		notify();
	}

	


}
