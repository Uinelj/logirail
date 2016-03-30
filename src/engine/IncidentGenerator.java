package engine;

import data.IncidentData;

/**
 * This class is a generator that generate incident on the line.
 * 
 * @author Alexandre Fourgs
 *
 */
public class IncidentGenerator {
	private static IncidentGenerator INSTANCE = new IncidentGenerator();
	
	private IncidentGenerator(){
		
	}
	
	public static IncidentGenerator getInstance(){
		return INSTANCE ;
	}
	
	
}
