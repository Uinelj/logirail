import data.GareDataBase;



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
		gare.LoadJsonGare("gare.json");
		System.out.println(gare);
	}

}
