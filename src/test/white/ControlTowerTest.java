package test.white;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;

import data.Schedule;

import engine.ControlTower;

public class ControlTowerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlTower controler = ControlTower.getInstance() ;
		LinkedHashMap<Date, ArrayList<String>> scheduleFile = controler.getFifo();
		
		Iterator it = scheduleFile.keySet().iterator();
		
		// On affiche la liste des trains à créer dans la journée. C'est bien dans l'ordre.
		while(it.hasNext()){
			Date schedule = (Date)it.next();
			
			System.out.println("Horaire : " + schedule);
			
			ArrayList<String> missions = scheduleFile.get(schedule);
			
			System.out.println("Missions : ");
			
			for(int i = 0 ; i < missions.size() ; i++){
				String actualMission = missions.get(i);
				
				System.out.println(actualMission);
			}
		}
		
		// Teste de suppression d'un train, on teste pour le dernier train et on ré-affiche la liste.
		controler.deleteTrain("NAGA", "19:10");
		
		it = scheduleFile.keySet().iterator();
		while(it.hasNext()){
			Date schedule = (Date)it.next();
			
			System.out.println("Horaire : " + schedule);
			
			ArrayList<String> missions = scheduleFile.get(schedule);
			
			System.out.println("Missions : ");
			
			for(int i = 0 ; i < missions.size() ; i++){
				String actualMission = missions.get(i);
				
				System.out.println(actualMission);
			}
		}
		
	}

}
