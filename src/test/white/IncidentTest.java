package test.white;

import java.util.HashMap;
import java.util.Iterator;

import data.IncidentData;
import data.IncidentDatabase;
import data.Schedule;
import data.ScheduleDatabase;

public class IncidentTest {

	public static void main(String[] args) {
		// Test pour voir si la database des incident s'est bien créer.
		IncidentDatabase incidentDatab = IncidentDatabase.getInstance();
		HashMap<Integer, IncidentData> incidentDatabaseHM = incidentDatab.getIncidentDatabase();
		IncidentData actualIncident ;
		
		Iterator it = incidentDatabaseHM.keySet().iterator();
		
		while (it.hasNext()){
			int id = (int)it.next();
					
			actualIncident = (IncidentData) incidentDatabaseHM.get(id);
			
			System.out.println(actualIncident.toString());
		}

	}

}
