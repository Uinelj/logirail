package test.black;

import data.MissionCode;
import data.MissionCodeDatabase;
import data.ScheduleDatabase;
import data.StationDataBase;

public class TrainInstanciationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissionCodeDatabase mcd = MissionCodeDatabase.getInstance();
		ScheduleDatabase sd = ScheduleDatabase.getInstance();
		System.out.println(sd);
		/*System.out.println(mcd.getMissionCode("TEDI").toString());
		System.out.println(mcd.getMissionCode("ZEBU"));
		System.out.println(mcd.getMissionCode("NAGA"));*/
		StationDataBase gdb = StationDataBase.getInstance();
		MissionCode tedi = mcd.getMissionCode("NAGA");
		for(Integer i : tedi.getRoad()){
			System.out.println(gdb.getGare(i).getName() + "\n");
		}
	}

}
