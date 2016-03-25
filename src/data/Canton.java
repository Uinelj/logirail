package data;

/**
 * The representation of a physical block where the train can be. A Canton can either be a station, or just a rails block.
 * Each block can have one train simultaneously inside.
 * @author AKTOR Alexis
 * 
 */
//TODO: Rename to block ?
public class Canton {
	

	/**
	 * @param id of the train
	 * @param size of the train
	 * @param give the state of the canton ( true : the canton is occupied, false : the canton is not occupied )
	 */
	
	private int id;
	private int lenght;
	private boolean occupyingTrain;

	
	
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
	 * Decide if the train can enter in a canton
	 * @param Train
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
	 * released a canton
	 */
	public synchronized void exit() {
		occupyingTrain = false;
		notify();
	}

	


}
