
import java.util.ArrayList;

public class Sub {
	private String name;
	private ArrayList<String> teachables;
	private SchoolList blacklist;
	// JO: maybe separate class for unavailabilities like with Absences
	// JO: can have UnavailabilityList also
	private ArrayList<String> unavailabilities;
	private SchoolList schools;		// schools a Sub is assigned to
	private AbsenceList assignedAbsences;	// absences a Sub is assigned to
	
	// JO: I had a bunch of constructors for different Sub inputs, but decided to simplify a bit
	// JO: blacklist and unavailabilities should be set using the public methods
	// DESC: Sub constructor, must set blacklist and unavailabilities using public methods in calling class
	public Sub(String name, ArrayList<String> teachables) {
		this.name = name;
		this.teachables = teachables;
		this.blacklist = new SchoolList();
		this.unavailabilities = new ArrayList<String>();
		this.schools = new SchoolList();
		this.assignedAbsences = new AbsenceList();
	}
	
	public void setBlacklist(SchoolList blacklist) {
		this.blacklist = blacklist;
	}
	
	public void setUnavailabilities(ArrayList<String> unavailabilities) {
		this.unavailabilities = unavailabilities;
	}
	
	public String getName() {
		return name;
	}
	
	// JO: changed to return SchoolList since a Sub may be assigned to multiple schools throughout the year
	public SchoolList getSchools() {
		return schools;
	}
	
	public ArrayList<String> getTeachables() {
		return teachables;
	}
	
	public AbsenceList getAssignedAbsences() {
		return assignedAbsences;
	}
	
	public void assignAbsence(Absence absence) {
		assignedAbsences.add(absence);
	}
	
	public void addSchool(School school) {
		schools.add(school);
	}
	
	// JO: might need to catch exception
	public void removeBlacklist(School school) {
		blacklist.remove(school);
	}
	
	// JO: only printing name and teachables, maybe print more later
	public String toString() {
		boolean first = true;
		String str = "";
		
		str += "Substitute: "+name+"\nTeachables: ";
		for(String t : teachables) {
			if(first) {
				str += t;
				first = false;
			} else {
				str += ", "+t;
			}
		}
		str += "\n";
		return str;
	}
}
