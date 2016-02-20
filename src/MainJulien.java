import data.GareDataBase;
import data.MissionCodeDatabase;

public class MainJulien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MissionCodeDatabase mcd = MissionCodeDatabase.getInstance();
		System.out.println(mcd.getMissionCode("TEDI").toString());
		System.out.println(mcd.getMissionCode("ZEBU"));
		System.out.println(mcd.getMissionCode("NAGA"));*/
		GareDataBase gdb = GareDataBase.getInstance();
		System.out.println(gdb.getGare(15));
	}
}
