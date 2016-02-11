package data;
import Json.JSONArray;
import Json.JSONObject;
import Json.JSONParser;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.Iterator;
public class GareDataBase {
	private ArrayList<Gare> gares;
	
	public GareDataBase(){
		this.gares= new ArrayList<Gare>();
	}

	
	
	public void LoadJsonGare(String file){
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(file));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lang = (JSONArray) jsonObject.get("gares");

            Iterator it = lang.iterator();
            	while (it.hasNext()) {                
	            	JSONObject innerObj = (JSONObject) it.next();
	                Gare gare = new Gare(null, -1);
	            	gare = new Gare((String)innerObj.get("name"),Integer.parseInt((String) innerObj.get("id")));
	            	gares.add(gare);
            	}
            	
        } catch (Exception e) {
            e.printStackTrace();
        }
	}



	@Override
	public String toString() {
		return "GareDataBase [gares=" + gares + "]";
	}



	public ArrayList<Gare> getGares() {
		return gares;
	}



	public void setGares(ArrayList<Gare> gares) {
		this.gares = gares;
	}
	

}
