import data.GareDataBase;
import data.MissionCode;
import data.MissionCodeDatabase;
import data.ScheduleDatabase;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissionCodeDatabase mcd = MissionCodeDatabase.getInstance();
		ScheduleDatabase sd = ScheduleDatabase.getInstance();
		System.out.println(sd);
		/*System.out.println(mcd.getMissionCode("TEDI").toString());
		System.out.println(mcd.getMissionCode("ZEBU"));
		System.out.println(mcd.getMissionCode("NAGA"));*/
		GareDataBase gdb = GareDataBase.getInstance();
		MissionCode tedi = mcd.getMissionCode("NAGA");
		for(Integer i : tedi.getRoad()){
			System.out.println(gdb.getGare(i).getName() + "\n");
		}
		//System.out.println(gdb.getGare(17).getName());
	}
}
