package test;

import data.Canton;
import data.CantonDataBase;
import data.GareDataBase;
import data.Ligne;
import data.MissionCode;
import data.MissionCodeDatabase;
import data.Train;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test
		
		GareDataBase gareDataBase=GareDataBase.getInstance();
		CantonDataBase cantonDataBase = CantonDataBase.getInstance();
		MissionCodeDatabase missionDb= MissionCodeDatabase.getInstance();
		Ligne ligne = new Ligne(gareDataBase, cantonDataBase);
		
		Train train = new Train("trainTest", missionDb.getMissionCode("TEDI"), 1,ligne);
		
		try {
			train.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
