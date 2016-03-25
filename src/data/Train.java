package data;

import java.util.ArrayList;

/**
 * Representation of a running train on the line
 * @author AKTOR Alexis
 * 
 */

public class Train {
	private String name;
	private MissionCode missionCode;
	private int id;
	private Boolean end;
	private int position;
	private Ligne ligne;
	private int posCode;
	private ArrayList<Integer> path;
	
	/**
	 * 
	 * @param name name of the path to load the data
	 * @param missionCode the MissionCode that the train follow
	 * @param id id of the train
	 * @param ligne graph of the line
	 */
	
	public Train(String name, MissionCode missionCode, int id,Ligne line){
		this.ligne = line;
		this.setName(name);
		this.setMissionCode(missionCode);
		this.setId(id);
		end = true;
		position = missionCode.getRoad().get(0);
		
		posCode =0;
		path=new ArrayList<Integer>();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MissionCode getMissionCode() {
		return missionCode;
	}

	public void setMissionCode(MissionCode missionCode) {
		this.missionCode = missionCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id2) {
		this.id = id2;
	}
	
	public void start() throws InterruptedException{
		Canton currentCanton;
		Canton currentGare;

		while(position != missionCode.getRoad().get(missionCode.getRoad().size()-2)){
			
			
			if(isCanton(position)){
				currentCanton = new Canton(0, 0);
				currentCanton = ligne.getCantonDataBase().getGare(1);

				currentCanton.enter(this);
				Thread.sleep(200);
				currentCanton.exit();

				
				
			}
			
			else{
				System.out.println("gare");
				currentGare = new Gare("", 0);
				currentGare = ligne.getGareDataBase().getGare(position);
				currentGare.enter(this);
				currentGare.exit();

			}
			
		}
	}
	
	/**
	 * set the next position of the train
	 */
	public void setPosition(){
		
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		/*calcul of the path between the actual position and the next stations*/
		pathFinding(position, missionCode.getRoad().get(posCode+1), path);

		/*if the size of the path is 2, the train is arrived to a stations
		 * the position of the start station is increment by 1
		 */
		if(path.size()==2){
			posCode++;
			position = path.get(1);
			
		}
		
		/*if the size of the path is 3, the train is in a canton*/
		
		else if(path.size()==3){
			System.out.println(ligne.getGareDataBase().getGare(position).getName());
			
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
		/*on ajoute la position de d�part*/
		path.add(position);

		/*on parcour r�cursivement toute les branches suivant le cantons actuel*/
		for(int i=0 ;i < nextIs(position).size();i++){
			
			if(state != 2){
				/*si l'arr�te du graphe suivante est un canton
				 * on fait un path finding
				 */
				if(isCanton(nextIs(position).get(i))){
					state = pathFinding(nextIs(position).get(i), endPath, path);
				}
		
				/*
				 * Si c'est une gare on peut avoir deux choix:
				 * 1) la gare est la gare � atteindre : on ajoute la gare au path et on retourne le path
				 * 2) Ce n'est pas la gare finale, dans ce cas, le chemin n'est pas le bon
				 * 
				 */
				else{
					if(nextIs(position).get(i) == endPath){
						path.add(nextIs(position).get(i));
						return 2;
					}
					state = 0;
				}
			}
				
		}
		
		/*retour null : le chemin n'est pas le bon, on retire la derni�re valeure du path*/
		if(state==0){
			path.remove(path.size()-1);
			return 0;
		}
		
		return 2;
	}
	
	/**
	 * 
	 * @param id id of a canton
	 * @return a boolean to say if it's a canton or a station
	 */
	public Boolean isCanton(int id){
    	if(id >45)
    		return true;
    	else 
    		return false;
    }
	
	/**
	 * 
	 * @param pos state position
	 * @return ArrayList wich contains all of next edges linked with the state
	 */
	
	public ArrayList<Integer> nextIs(int pos){
		int index = pos;
		
		ArrayList<Integer> nextPos = new ArrayList<Integer>();
		
		for(int i=0;i<ligne.getSize();i++){
			if(ligne.getMat(index, i) == 1){
				nextPos.add(i);
			}
		}
		return nextPos;
		
	}

}
