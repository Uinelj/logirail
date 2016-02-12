import java.net.SocketPermission;
import java.util.ArrayList;

import data.GareDataBase;
import data.Schedule;



/*
 * Main d'exemple, qui affiche un hello world. 
 * @author Julien ABADJI
 * */
public class Main {
	/*
	 * Fonction statique main, qui permet de lancer du code tranquillement. 
	 * @param args Arguments passés en ligne de commande. 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GareDataBase gare = new GareDataBase();
		gare.LoadJsonGare("data/gare.json");
		System.out.println(gare);
		
		Schedule schedule = new Schedule("TEDI");
		schedule.scheduleForOneMission("TEDI");
		System.out.println(schedule.toString());
		
		ArrayList<Schedule> test = new ArrayList<Schedule>();
		test = schedule.schedulesParsing();
		for (int i = 0 ; i < test.size() ; i++){
			System.out.println(test.get(i).toString());
		}
	}
}
