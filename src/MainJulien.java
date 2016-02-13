import data.MissionCodeDatabase;

public class MainJulien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissionCodeDatabase mcd = new MissionCodeDatabase();
		System.out.println(mcd.getRoute("TEDI"));
		System.out.println(mcd.getRoute("ZEBU"));
		System.out.println(mcd.getRoute("NAGA").get(3));
		
	}
}
