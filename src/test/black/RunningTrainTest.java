package test.black;

import data.CantonDataBase;
import data.Line;
import data.MissionCodeDatabase;
import data.StationDataBase;
import engine.Train;

public class RunningTrainTest {
	public static void main(String[] args) {
		// Test
		
		StationDataBase stationDataBase=StationDataBase.getInstance();
		CantonDataBase cantonDataBase = CantonDataBase.getInstance();
		MissionCodeDatabase missionDb= MissionCodeDatabase.getInstance();
		Line line = new Line(stationDataBase, cantonDataBase);
		Train train = new Train("Train de test", missionDb.getMissionCode("QAHA"), 1,line,1000);
		train.start();
		
		
	}
			
		
}
