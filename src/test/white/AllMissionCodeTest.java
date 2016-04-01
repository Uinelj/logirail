package test.white;

import junit.framework.TestCase;

import org.junit.Test;

import data.MissionCodeDatabase;

public class AllMissionCodeTest extends TestCase{

	private MissionCodeDatabase MCDB;
	public AllMissionCodeTest(){
		
	}
	protected void setUp() throws Exception {
		super.setUp();
		MCDB = MissionCodeDatabase.getInstance();
	}
	@Test
	public void allMissionCodeTest() {
		System.out.println("Test 1 : toString");
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
		assertNull(MCDB.getMissionCode("dzazzdad"));
	}
}
