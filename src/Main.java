
import java.util.ArrayList;
import data.GareDataBase;
import data.Schedule;
import data.ScheduleDatabase;
import data.TrainModel;



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
		
		// Test ScheduleDatabase
		ScheduleDatabase schedules = new ScheduleDatabase();
		
		// Test Train Model
		TrainModel testModel = new TrainModel("test");
		ArrayList<TrainModel> models = new ArrayList<TrainModel>() ;
		models = testModel.trainModelJsonParser();
		for (int i = 0 ; i < models.size() ; i++){
			System.out.println(models.get(i).toString());
		}
	}
}
