package engine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

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
	LinkedHashMap<Date, ArrayList<String>> fifo = new LinkedHashMap<Date, ArrayList<String>>();
	
	/**
	 * Constructor
	 */
	private ControlTower (){
		fifo = initializeFifo();
	}
	
	/**
	 * This method create a LinkedHashMap with every train to start in a day.
	 * 
	 * @return a LinkedHashMap that contains every train to launch in a day. The HashMap is range in the order by schedule.
	 */
	private LinkedHashMap<Date, ArrayList<String>> initializeFifo(){
		
		// On récupère une instance de calendar, et on set l'heure à 5h00.
		Calendar time = Calendar.getInstance();
		time.set(00, 00, 00, 05, 00, 00);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				
		// On créer la file.
		LinkedHashMap<Date, ArrayList<String>> fifo = new LinkedHashMap<Date, ArrayList<String>>();
		
		// On récupére l'instance de la base de donnée des horaires.
		ScheduleDatabase scheduleDB = ScheduleDatabase.getInstance();
		Schedule actualSchedule ;
		
		// On récupère l'HashMap des horaires.
		HashMap<String, Schedule> schedules = scheduleDB.getScheduleDatabase();
	
		// On parcours le temps d'une journée, chaque minute.
		while ((time.get(Calendar.HOUR_OF_DAY) != 4) || (time.get(Calendar.MINUTE) != 59)){
			
			Iterator it = schedules.keySet().iterator();
			
			// On parcours les horaires.
			while(it.hasNext()){
				
				String codeMission = (String)it.next();
				actualSchedule = (Schedule) schedules.get(codeMission);
				
				// On parcours toute les horaires pour le code mission actuel.
				
				for (int i = 0 ; i < actualSchedule.getDates().size() ; i++){
					
					Date actual = actualSchedule.getDates().get(i);
					
					// On compare l'heure de la classe avec les horaires.
					// Revoir schedule car j'utilise des méthode deprecated
					if(dateFormat.format(actual).equals(dateFormat.format(time.getTime()))){
						// Si on a déjà un autre train qui part à cette heure.
						// Ca signifie qu'il existe déjà une entrée pour cette clé.
						// Donc on a juste à ajouter la mission qui part à la même heure.
						if(fifo.containsKey((Date)actual)){
							fifo.get(actual).add(codeMission);
						}
						// Sinon, ça signifie que cette entrée n'existe pas encore.
						// On doit la créer ainsi que le tableau des missions qui partent à cette heure.
						else {
							ArrayList<String> missions = new ArrayList<String>();
							missions.add(codeMission);
							fifo.put(actual, missions);
						}						
					}
				}
			}
			
			// On itère d'une minute.
			time.add(Calendar.MINUTE, 1);
		}
		
		// Ranger par ordre croissant les horaires de tout les codes missions
		
		return fifo ;
	}
	
	/**
	 * This method delete the train before he's launch.
	 * @param codeMission is the code mission of the train that have to be delete.
	 * @paraxm date is the schedule we have to delete.
	 */
	public void deleteTrain(String codeMission, String schedule){
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date scheduleConverted = new Date();
		boolean find = false ;
		int i = 0 ;
		ArrayList<String> trains ;
		
		try {
			scheduleConverted = dateFormat.parse(schedule);
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		trains = fifo.get(scheduleConverted);
		
		// On parcours tout les trains à créer à l'horaire voulu.
		while (!find && (i < trains.size())){
			
			// Si c'est le code mission du train qu'on souhaite supprimer, on le supprime.
			if(trains.get(i).equals((String)codeMission)){
				trains.remove(i);
				find = true ;
			}
			// Sinon on continue de parcourir la liste.
			else {
				i++ ;
			}
		}
		// Si il n'y a plus de train à créer à cette horaire, on supprime l'horaire.
		if (trains.isEmpty()){
			fifo.remove(scheduleConverted);
		}
	}
	
	public LinkedHashMap<Date, ArrayList<String>> getFifo(){
		return fifo ;
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
	 * 1/ On creer une file des horaires (Fait)
	 * 2/ On regarde l'heure et le premier element de la file
	 * 3/ Si ils sont égaux (meme heure) on initialise & lance le train correspondant.
	 * 4/ Sinon on fait rien
	 * 
	 * Ajouter un thread pour initialiser les trains ?
	 * 
	 */
}
