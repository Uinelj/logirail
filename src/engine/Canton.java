package engine;

/**
 * The representation of a physical block where the train can be. A Canton can either be a station, or just a rails block.
 * Each block can have one train simultaneously inside.
 * @author AKTOR Alexis
 * 
 */
//TODO: Rename to block ?
//TODO: Replace lenght by length
//TODO: Replace occupyingTrain by something more meaningful, ie. isOccupied ?
public class Canton {
	
	//TODO: ALEXIS Refais ta doc please
	/**
	 * @field id of the train
	 * @field size of the train
	 * @field give the state of the canton ( true : the canton is occupied, false : the canton is not occupied )
	 */
	
	private int id;
	private int lenght;
	private boolean occupyingTrain;

	
	/**
	 * Constructs a new Canton
	 * */
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
	
	/**
	 * Decide if a train can enter in a canton (ie. if the Canton is empty)
	 * @param Train the train to eventually enter into the Canton
	 * @throws InterruptedException ALEXIS JE METS QUOI ICI?
	 */
	public synchronized void enter(Train train) throws InterruptedException {
		
		if(occupyingTrain == true){
			System.out.println("no train");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		occupyingTrain=true;
		train.setPosition();
	}

	/**
	 * Empty the Canton. Called when a train exits a canton
	 */
	public synchronized void exit() {
		occupyingTrain = false;
		notify();
	}

	


}
