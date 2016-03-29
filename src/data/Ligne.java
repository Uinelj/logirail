package data;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Representation of the train line by a graph of stations.
 * Built by parsing a JSON file, located in data/ligne.json.
 * @author Alexandre Fourgs ?
 *
 */
public class Ligne {
	
	private  int[][] line;
	private ArrayList<Canton> cantons;
	private int size;
	private String path="data/ligne.json";
	private GareDataBase gareDataBase;
	private CantonDataBase cantonDataBase;
	/**
	 * Creates a new Ligne (line), following a set of Gare and a set of Canton.
	 * 
	 * @param gareDataBase database of Gare to be used
	 * @param cantonDataBase database of Canton to be used
	 * */
    public Ligne(GareDataBase gareDataBase, CantonDataBase cantonDataBase){
    	this.setCantonDataBase(cantonDataBase);
    	this.setGareDataBase(gareDataBase);
    	size = 100;
    	line = new int[size][size];
    	cantons = new ArrayList<Canton>();
    	init();
    	jSonLoad();
    	reverse();
    	affiche();
    }
    /**
     * Parses the JSON following the path attribute of the class, and loads it onto I don't know.
     * */
    //TODO: ALEX Commente un peu l'algo please, je sais pas ou vont les donnees parsees.
    private void jSonLoad(){
    	JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(path));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lang = (JSONArray) jsonObject.get("line"); //why lang?
    		JSONArray road;

            int in;
            int out;
            int actu=0;
            Iterator it = lang.iterator();
            while(it.hasNext()){
            	JSONObject innerObj = (JSONObject) it.next();
            	//System.out.println(innerObj);
            	//Ugly, but the lib doesnt provide some way to get strings.
            	in = Integer.parseInt((String) innerObj.get("in"));
            	out = Integer.parseInt((String) innerObj.get("out"));
				road = (JSONArray) innerObj.get("cantons");
				actu = in;
            	if (road != null) { 
					   for (int i=0;i<road.size();i++){ 
						line[actu][Integer.parseInt(road.get(i).toString())+45] = 1;
						actu = Integer.parseInt(road.get(i).toString())+45;
					   } 
					   
					   line[actu][out]=1;
					}
            	//gares.put(Integer.parseInt((String)innerObj.get("id")), new Gare(currentStationName, currentStationId));
            }
        	
            	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Initializes at 0 the line adjacency matrix.
     * */
    //Si la ligne que j'ai c/c fonctionne aussi bien, peut etre tej cette méthode ?
    private void init(){
    	/*for(int i=0;i<size;i++){
    		for(int j=0; j<size;j++){
    			line[i][j]=0;
    		}
    	}*/
    	//Shorter way to initialize a 0-filled array.
    	//See http://stackoverflow.com/questions/2154251/any-shortcut-to-initialize-all-array-elements-to-zero
    	int line[][] = new int[size][size];
    }
    /**
     * Prints the adjacency matrix.
     * */
    //TODO: ALEX virer ça aussi ? Ou c'est utilise dans le programme ?
    private void affiche(){
    	for(int j=0;j<size;j++){
			//System.out.print(j);
    		for(int i=0; i<size;i++){
    			//System.out.print(i);
    			System.out.print(line[j][i]);
    		}
    		System.out.println();
    	}
    }
    /**
     * Returns a specific value from the transition matrix
     * 
     * @param in Where the train comes in
     * @param out Where the train comes out
     * */
    public int getMat(int in, int out){
    	return line[in][out];
    }
    /**
     * Returns the whole transition matrix
     * 
     * @return line the transition matrix
     * */
    public int[][] getMat(){
    	return line;
    }
    /**
     * returns the size of the matrix, either height or width
     * 
     * @return size the width/height of the square transition matrix
     * */
    public int getSize(){
    	return size;
    }
    /**
     * Reverses the transition matrix, by replacing all the zeroes by ones and vice versa
     * */
    private void reverse(){
    	for(int i=0; i<size;i++){
    		for(int j=0;j<size;j++){
    			if(line[i][j] == 1){
    				line[j][i]=1;
    			}
    		}
    	}
    }

    
    public GareDataBase getGareDataBase() {
		return gareDataBase;
	}

	public void setGareDataBase(GareDataBase gareDataBase) {
		this.gareDataBase = gareDataBase;
	}

	public CantonDataBase getCantonDataBase() {
		return cantonDataBase;
	}

	public void setCantonDataBase(CantonDataBase cantonDataBase) {
		this.cantonDataBase = cantonDataBase;
	}
}
