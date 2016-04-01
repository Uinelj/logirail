package test.white;

import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

import org.junit.Test;

import data.MissionCodeDatabase;
import data.Schedule;
import data.ScheduleDatabase;

public class ScheduleTest extends TestCase{

	/**
	 * Class that tests GareCodeDatabase
	 * toString / one by one verification
	 * @author Lucas Nicosia
	 * 
	 */
	@Test
	public void testSchedule() {
		MissionCodeDatabase mcdb = MissionCodeDatabase.getInstance();
		ScheduleDatabase sdb = ScheduleDatabase.getInstance();
		for(String missionCode : mcdb.getMissionCodeDatabase().keySet()) {
			Schedule fromDatabase = sdb.getScheduleDatabase().get(missionCode);
			assertTrue("Schedule instancie conforme a la db", fromDatabase.equals(sdb.getScheduleDatabase().get(missionCode)));
			
		}
	}
}
