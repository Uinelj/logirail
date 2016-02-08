package data;

/**
 * Class Train : ...
 * @author AKTOR Alexis
 * 
 */

public class Train {
	private String name;
	private MissionCode missionCode;
	private String id;
	
	
	public Train(String name, MissionCode missionCode, String id){
		this.setName(name);
		this.setMissionCode(missionCode);
		this.setId(id);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MissionCode getMissionCode() {
		return missionCode;
	}

	public void setMissionCode(MissionCode missionCode) {
		this.missionCode = missionCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
