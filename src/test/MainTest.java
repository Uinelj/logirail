package test;

import data.CantonDataBase;
import data.Line;
import data.MissionCode;
import data.MissionCodeDatabase;
import data.StationDataBase;
import engine.Train;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test
		
		StationDataBase gareDataBase=StationDataBase.getInstance();
		CantonDataBase cantonDataBase = CantonDataBase.getInstance();
		MissionCodeDatabase missionDb= MissionCodeDatabase.getInstance();
		Line ligne = new Line(gareDataBase, cantonDataBase);
		
		Train train = new Train("trainTest", missionDb.getMissionCode("TEDI"), 1,ligne);
		
		try {
			train.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
