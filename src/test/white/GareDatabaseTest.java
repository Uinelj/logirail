package test.white;

import data.Station;
import data.StationDataBase;

public class GareDatabaseTest {

	/**
	 * Class that tests GareCodeDatabase
	 * toString / one by one verification
	 * @author Lucas Nicosia
	 *
	 */
	public static void main(String[] args) {
		System.out.println("Test 1 : toString");
		StationDataBase gare = StationDataBase.getInstance();
		System.out.println("	"+gare.toString());
	
	}

}
