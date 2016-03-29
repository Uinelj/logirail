package engine;

import java.util.ArrayList;

import data.Line;
import data.MissionCode;
import data.Station;

/**
 * Representation of a running train on the line
 * @author AKTOR Alexis
 * 
 */

public class Train extends Thread{
	private String name;
	private MissionCode missionCode;
	private int id;
	private Boolean end;
	private int position;
	private Line line;
	private int CodemissionPosition;
	private ArrayList<Integer> path;
	
	/**
	 * Builds a new Train which will be used by the simulation
	 * @param name name of the path to load the data
	 * @param missionCode the MissionCode that the train follow
	 * @param id id of the train
	 * @param ligne graph of the line
	 */
	
	public Train(String name, MissionCode missionCode, int id,Line line){
		this.line = line;

		this.setName(name);
		this.setMissionCode(missionCode);
		this.setId(id);
		end = true;
		position = missionCode.getRoad().get(0);
		
		CodemissionPosition =0;
		path=new ArrayList<Integer>();
		
	}
	
	public void run(){
		Canton currentCanton;
		Canton currentStation;

		/*tant qu'on est pas arrivé à destination*/
		while(position != missionCode.getRoad().get(missionCode.getRoad().size()-2)){
			
			
			if(isCanton(position)){//cas si le train se trouve sur un canton
				currentCanton = new Canton(0, 0);
				currentCanton = line.getCantonDataBase().getGare(position-45);
				currentCanton.enter(this);//on rentre dans un canton
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentCanton.exit();//on attend puis on quitte le canton
				


				
				
			}
			
			else{//case si le train se trouve sur une gare
				currentStation = new Station("", 0);
				
				//pas de sleep pour l'instant, à voir avec les horaires ou mettre une durée d'arrêt
				
				currentStation = line.getStationDataBase().getGare(position);
				currentStation.enter(this);//on rentre dans un canton
				currentStation.exit();//on attend puis on quitte le canton

			}
			
		}
	}

	public String getTrainName() {
		return name;
	}

	public void setTrainName(String name) {
		this.name = name;
	}

	public MissionCode getMissionCode() {
		return missionCode;
	}

	public void setMissionCode(MissionCode missionCode) {
		this.missionCode = missionCode;
	}

	public int getTrainId() {
		return id;
	}

	public void setId(int id2) {
		this.id = id2;
	}
	/**
	 * Starts the train thread. 
	 * */
	
	
	/**
	 * sets the next position of the train
	 */
	public void setPosition(){
		
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		/*calcul of the path between the actual position and the next stations*/
		pathFinding(position, missionCode.getRoad().get(CodemissionPosition+1), path);

		/*if the size of the path is 2, the train is arrived to a stations
		 * the position of the start station is increment by 1
		 */
		if(path.size()==2){
			CodemissionPosition++;
			position = path.get(1);
			
		}
		
		/*if the size of the path is 3, the train is in a canton*/
		
		else if(path.size()==3){
			System.out.println(line.getStationDataBase().getGare(position).getName());
			
			position = path.get(1);

		}
		
		/*else, the pathfinding is out*/
		else {
			System.out.println("pathfinding out" + position);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @param position position in the graph of line
	 * @param endPath the position to reach
	 * @param path the final path to set
	 * @return
	 */
	public int pathFinding(int position, int endPath, ArrayList<Integer> path){
		
		int state=0;
		//A
		/*on ajoute la position de depart*/
		path.add(position);

		/*on parcour recursivement toute les branches suivant le cantons actuel*/
		for(int i=0 ;i < nextPositions(position).size();i++){
			
			if(state != 2){
				/*si l'arrete du graphe suivante est un canton
				 * on fait un path finding
				 */
				if(isCanton(nextPositions(position).get(i))){
					state = pathFinding(nextPositions(position).get(i), endPath, path);
				}
		
				/*
				 * Si c'est une gare on peut avoir deux choix:
				 * 1) la gare est la gare a atteindre : on ajoute la gare au path et on retourne le path
				 * 2) Ce n'est pas la gare finale, dans ce cas, le chemin n'est pas le bon
				 * 
				 */
				else{
					if(nextPositions(position).get(i) == endPath){
						path.add(nextPositions(position).get(i));
						return 2;
					}
					state = 0;
				}
			}
				
		}
		
		/*retour null : le chemin n'est pas le bon, on retire la derniere valeure du path*/
		if(state==0){
			path.remove(path.size()-1);
			return 0;
		}
		
		return 2;
	}
	
	/**
	 * Checks if a given ID is relevant to a Gare or a Canton
	 * @param id id of a canton
	 * @return a boolean to say if it's a canton or a station
	 */
	/*
	 * TODO: ALEXIS C'est pas une bonne facon de faire : 
	 * Si on change les id ou qu'on ajoute des gares on pourrait obtenir des fausse informations.
	 * Mieux : Chopper l'id, construire le canton, et en utilisant la reflexivite on peut savoir si l'objet est de type Gare ou pas. 
	 * */
	public Boolean isCanton(int id){

    	if(id >45)
    		return true;
    	else 
    		return false;
    }
	
	/**
	 * Alexis je comprends pas :(
	 * @param pos state position
	 * @return ArrayList which contains all of next edges linked with the state
	 */
	
	public ArrayList<Integer> nextPositions(int pos){
		int index = pos;
		
		ArrayList<Integer> nextPos = new ArrayList<Integer>();
		
		for(int i=0;i<line.getSize();i++){
			if(line.getMat(index, i) == 1){
				nextPos.add(i);
			}
		}
		return nextPos;
		
	}

}
