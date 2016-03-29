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
	 */
}
