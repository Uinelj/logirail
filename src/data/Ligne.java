package data;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * Representation of the train line, a graph of stations.
 * Built by parsing a JSON file, located in data/ligne.json.
 * @author Alexandre Fourgs ?
 *
 */
public class Ligne {

	private  int[][] line;
	private int size;
	private String path="data/ligne.json";
	
    public Ligne(){
    	size = 89;
    	line = new int[size][size];
    	init();
    	jSonLoad();
    	affiche();
    }
    
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
    
    
    private void init(){
    	for(int i=0;i<size;i++){
    		for(int j=0; j<size;j++){
    			line[i][j]=0;
    		}
    	}
    }
    
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
}
