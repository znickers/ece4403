
import java.util.ArrayList;

public class Sub implements Comparable<Teacher>{
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
	
	public void addUnavailability(String unavailability) {
		unavailabilities.add(unavailability);
	}
	
	public ArrayList<String> getUnavailabilities() {
		return unavailabilities;
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
	
	public int compareTo(Teacher teacher)
	{
		int compatibility = 0; //ZAC: Integer value to represent teacher-substitute compatibility. Higher value represents better compatibility.
		ArrayList<String> teacherTeachables = teacher.getTeachables();
		for(String teachable: teacherTeachables)
		{
			if(teachables.contains(teachable))
				compatibility++; //ZAC: If teacher and substitute share a common teachable, compatibility value will increase by 1.
		}
		return compatibility;
	}
	
	// JO: need to test all toString cases
	// JO: may need to update the unavailabilities if we make them a class later
	public String toString() {
		boolean first = true;
		String str = "";
		
		str += "\n\nSubstitute: "+name+"\nTeachables: ";
		for(String t : teachables) {
			if(first) {
				str += t;
				first = false;
			} else {
				str += ", "+t;
			}
		}
		if(!unavailabilities.isEmpty()) {
			str += "\nUnavailabilities:";
			for(String u : unavailabilities) {
				str += "\n"+u;
			}
		}
		if(!blacklist.isEmpty()) {
			first = true;
			str += "\nBlacklist: ";
			for(School b : blacklist) {
				if(first) {
					str += b.getName();
					first = false;
				} else {
					str += ", "+b.getName();
				}
			}
		}
		if(!assignedAbsences.isEmpty()) {
			str += "\nAssigned absences:\n";
			for(Absence ab : assignedAbsences) {
				str += ab;
			}
		}
		return str;
	}
}
