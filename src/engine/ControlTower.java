package engine;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import data.Schedule;
import data.ScheduleDatabase;

/**
 * This class is the control tower, she creates all trains & "control" them.
 *  
 * @author Alexandre Fourgs
 *
 */
public class ControlTower {
	private static ControlTower INSTANCE = new ControlTower() ;
	LinkedHashMap<String, Date> fifo = new LinkedHashMap<String, Date>();
	
	/**
	 * Constructor
	 */
	private ControlTower (){
		fifo = initializeFifo();
	}
	
	private LinkedHashMap<String, Date> initializeFifo(){
		ScheduleDatabase scheduleDB = ScheduleDatabase.getInstance();
		HashMap<String, Schedule> schedules = scheduleDB.getScheduleDatabase();
		Iterator it = schedules.keySet().iterator();
		Schedule actualSchedule ;
		LinkedHashMap<String, Date> fifo = new LinkedHashMap<String, Date>();
		
		while(it.hasNext()){
			String codeMission = (String)it.next();
			actualSchedule = (Schedule) schedules.get(codeMission);
			
			for (int i = 0 ; i < actualSchedule.getDates().size() ; i++){
				fifo.put(codeMission, actualSchedule.getDates().get(i));
			}
		}
		
		// Ranger par ordre croissant les horaires de tout les codes missions
		
		return fifo ;
	}
	
	/**
	 * This method delete the train before he's launch.
	 * @param codeMission is the code mission of the train that have to be delete.
	 * @param date is the schedule we have to delete.
	 */
	public void deleteTrain(String codeMission, Schedule date){
	
	}
	
	/**
	 * 
	 * @return the instance of the ControlTower object.
	 */
	public static ControlTower getInstance(){
		return INSTANCE ;
	}
	/**
	 * 
	 * Bloc note idée de création de la tour de contrôle.
	 * 
	 * Méthode 1 (Un peu bourbier) :  
	 * 1/ Regarder l'heure de l'horloge tout le temps
	 * 2/ Comparer l'heure de l'horloge avec les horaires
	 * 3/ Si l'heure à laquelle on est un train doit partir, on l'initialise et on le démarre
	 * 4/ Sinon on fait rien
	 * Bourbier parceque à chaque fois on doit aller voir les horaires.
	 * 
	 * Méthode 2 (Peut-être mieux, mais équivalent) :
	 * 1/ On créer une file des horaires
	 * 2/ On regarde l'heure et le premier élément de la file
	 * 3/ Si ils sont égaux (même heure) on initialise & lance le train correspondant.
	 * 4/ Sinon on fait rien
	 * 
	 * Méthode 2 choisis pour l'instant.
	 * 
	 * Ajouter un thread pour initialiser les trains ?
	 * 
	 */
}
