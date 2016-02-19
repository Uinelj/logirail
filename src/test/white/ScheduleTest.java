package test.white;

import java.util.HashMap;
import java.util.Iterator;

import data.MissionCode;
import data.MissionCodeDatabase;
import data.Schedule;

public class ScheduleTest {

	/**
	 * Class that tests GareCodeDatabase
	 * toString / one by one verification
	 * @author Lucas Nicosia
	 * 
	 */
	public static void main(String[] args) {
		String missionCode = "";
		MissionCodeDatabase MCDB = MissionCodeDatabase.getInstance();
		HashMap<String, MissionCode> missionCodeDatabase = MCDB.getMissionCodeDatabase();
		/*Iterator it = missionCodeDatabase.iterator();
		while(it.hasNext()){
			if(missionCode.equals(it.next().)){
				
			}
		}*/
		Schedule schedule = new Schedule("opij");
		System.out.println("Test 1 : toString");
		System.out.println("	"+schedule.toString());
	}

}
