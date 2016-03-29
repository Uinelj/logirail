package engine;

/**
 * This class is the control tower, she creates all trains & "control" them.
 *  
 * @author Alexandre Fourgs
 *
 */
public class ControlTower {
	
	/**
	 * 
	 * Bloc note idee de création de la tour de controle.
	 * 
	 * Methode 1 (Un peu bourbier) :  
	 * 1/ Regarder l'heure de l'horloge tout le temps
	 * 2/ Comparer l'heure de l'horloge avec les horaires
	 * 3/ Si l'heure à laquelle on est un train doit partir, on l'initialise et on le demarre
	 * 4/ Sinon on fait rien
	 * Bourbier parceque à chaque fois on doit aller voir les horaires.
	 * 
	 * Méthode 2 (Peut-etre mieux, mais equivalent) :
	 * 1/ On creer une file des horaires
	 * 2/ On regarde l'heure et le premier element de la file
	 * 3/ Si ils sont égaux (meme heure) on initialise & lance le train correspondant.
	 * 4/ Sinon on fait rien
	 * 
	 */
}
