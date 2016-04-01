package test.white;

import data.MissionCode;
import data.MissionCodeDatabase;
	/**
	 * Class that tests MissionCodeDatabase
	 * toString / one by one verification
	 * @author Lucas Nicosia
	 *
	 */
public class MissionCodeDatabaseTest {
	public static void main(String[] args){
	System.out.println("Test 1 : toString");
	MissionCodeDatabase MCDB = MissionCodeDatabase.getInstance();
	System.out.println("	"+MCDB.toString());

	System.out.println("Test 2 : unique mission");
	for( String missionCode : MCDB.getMissionCodeDatabase().keySet()){
		System.out.println("	-"+missionCode+": "+MCDB.getMissionCode(missionCode));
	}
	/*System.out.println("	-TEDI :"+MCDB.getMissionCode("TEDI").toString());
	System.out.println("	-ZEBU :"+MCDB.getMissionCode("ZEBU"));
	System.out.println("	-NAGA :"+MCDB.getMissionCode("NAGA"));*/
	
	System.out.println("Test 3 : get all mission codes NAME only");
	System.out.println("	"+MCDB.getMissionCode("zdzdca"));
	
	}
}
