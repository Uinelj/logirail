package test.white;

import data.MissionCodeDatabase;

public class MissionCodeDatabaseTest {
	public static void main(String[] args){
	System.out.println("Test 1 : toString");
	MissionCodeDatabase MC = MissionCodeDatabase.getInstance();
	System.out.println("	"+MC.toString());

	System.out.println("Test 2 : unique mission");
	System.out.println("	-TEDI :"+MC.getMissionCode("TEDI").toString());
	System.out.println("	-ZEBU :"+MC.getMissionCode("ZEBU"));
	System.out.println("	-NAGA :"+MC.getMissionCode("NAGA"));
	}
}
