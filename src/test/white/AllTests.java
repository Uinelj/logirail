package test.white;

import data.MissionCodeDatabase;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests {

	private static TestSuite suite;
	/**
	 * @param args
	 */
	
	public static TestSuite suite(){
		suite = new TestSuite("All tests");
		suite.addTestSuite(AllMissionCodeTest.class);
		suite.addTestSuite(ScheduleTest.class);
		
		return suite;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		junit.textui.TestRunner.run(suite());
	}

}
