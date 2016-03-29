package data;
//TODO: Basic documentation
public class IncidentData {
	private int id ;
	private String type ;
	private int minTime ;
	private int maxTime ;
	
	public IncidentData(int id, String type, int minTime, int maxTime){
		this.id = id ;
		this.type = type ;
		this.minTime = minTime ;
		this.maxTime = maxTime ;
	}
	
	public int getId(){
		return id ;
	}
	
	public String getType(){
		return type ;
	}
	
	public int getMinTime(){
		return minTime ;
	}
	
	public int getMaxTime(){
		return maxTime ;
	}
	
	public String toString(){
		String toString = "[Incident] ID : " + id + " Type : "+ type + " minTime : " + minTime + " maxTime : " + maxTime ;
		
		return toString ;
	}
}
