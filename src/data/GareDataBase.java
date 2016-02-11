package data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.Iterator;
public class GareDataBase {
	private ArrayList<Gare> gares;
	
	public GareDataBase(){
		this.setGares(new ArrayList<Gare>());
	}

	
	
	public void LoadJsonGare(String file){
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(file));
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray lang = (JSONArray) jsonObject.get("gares");
            Gare gare;
            for(int i=0; i<lang.size(); i++){
            Iterator it = lang.iterator();
            	while (it.hasNext()) {                
	            	JSONObject innerObj = (JSONObject) it.next();
	             	gare = new Gare((String)innerObj.get("name"),Integer.parseInt((String) innerObj.get("id")));
	             	gares.add(gare);
            	}
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
