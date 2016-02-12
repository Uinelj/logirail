import data.MissionCodeDatabase;

public class MainJulien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissionCodeDatabase mcd = new MissionCodeDatabase();
		System.out.println(mcd.getRoute("BILE"));
		System.out.println(mcd.getRoute("TEST"));
		System.out.println(mcd.getRoute("ARYA"));
		
	}
}
