
import java.util.ArrayList;

public class Teacher {
	private String name;
	private School school;
	private ArrayList<String> teachables;
	private AbsenceList absences;
	private Sub preferredSub;
	
	// JO: need to add Absences after initialization
	// DESC: constructor for new Teacher
	public Teacher(String name, School school, ArrayList<String> teachables) {
		this.name = name;
		this.school = school;
		this.teachables = teachables;
		this.absences = new AbsenceList();
	}
	
	public String getName() {
		return name;
	}
	
	public School getSchool() {
		return school;
	}
	
	public ArrayList<String> getTeachables() {
		return teachables;
	}
	
	public AbsenceList getAbsences() {
		return absences;
	}
	
	public void addAbsence(Absence absence) {
		absences.add(absence);
	}
	
	public void addAbsenceList(AbsenceList absences) {
		this.absences.addAll(absences);
	}
	
	public Sub getPreferredSub() {
		return preferredSub;
	}
	
	public void setPrefferedSub(Sub sub) {
		preferredSub = sub;
	}
	
	public String toString() {
		boolean first = true;
		String str = "";
		
		str += "Teacher: "+name+"\nSchool: "+school.getName()+"\nTeachables: ";
		for(String t : teachables) {
			if(first) {
				str += t;
				first = false;
			} else {
				str += ", "+t;
			}
		}
		if(preferredSub != null) {
			str += "\nPreferred substitute: "+preferredSub.getName();
		}
		
		return str;
	}
}
