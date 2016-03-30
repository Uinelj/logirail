package test.white;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import data.MissionCode;
import data.MissionCodeDatabase;
import data.Schedule;
import data.ScheduleDatabase;

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
		
		// ???
		Schedule schedule = new Schedule("opij");
		System.out.println("Test 1 : toString");
		System.out.println("	"+schedule.toString());
		
		// Test pour voir si le parsing a bien fonctionné pour les horaires et la base de données.
		ScheduleDatabase scheduleDB = ScheduleDatabase.getInstance();
		HashMap<String, Schedule> scheduleDBHM = scheduleDB.getScheduleDatabase();
		Schedule actualSchedule ;
		Iterator it = scheduleDBHM.keySet().iterator();
		
		while (it.hasNext()){
			String codeMission = (String)it.next();
			
			System.out.println("Code Mission : " + codeMission);
			
			actualSchedule = (Schedule) scheduleDBHM.get(codeMission);
			
			System.out.println("Horaires : ");
			
			for(int i = 0 ; i < actualSchedule.getDates().size() ; i++){
				// Horaire au mauvais format, mais pas grave, faut juste regarder l'heure.
				System.out.println(actualSchedule.getDates().get(i).toString());
			}
		}
		
		// Test OK.
	}

}
