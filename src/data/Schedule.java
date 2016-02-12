package data;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

<<<<<<< HEAD
import Json.JSONArray;
import Json.JSONObject;
import Json.JSONParser;
=======
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
>>>>>>> 2f6fce00c5811ff125e2d275f53867aa74efd440

/**
 * 
 * @author Alexandre Fourgs 
 * Schedules depending on the mission code. This class
 * parse a JSON file for save the schedules.
 * 
 */
public class Schedule {
	private String code;
	private ArrayList<Date> schedules = new ArrayList<Date>();
	
	public Schedule(String code) {
		this.code = code ;
	}
	
	
	public String getCode(){
		return code ;
	}
	
	public ArrayList<Date> getSchedules(){
		return schedules;
	}
	
	public void setCode (String code){
		this.code = code ;
	}
	
	public void setSchedules (ArrayList<Date> schedules){
		this.schedules = schedules ;
	}
	
	public String toString() {
		String message ;
		String mission = "Code mission : " + code ;
		
		message = mission + "\n" ;
		message = message + "Horaires :\n" ;
		
		for (int i = 0 ; i < schedules.size() ; i++){
			message = message + schedules.get(i).toString() + "\n" ;
		}
		
		return message ;
	}

}
