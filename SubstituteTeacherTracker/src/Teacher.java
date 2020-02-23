
import java.util.ArrayList;

public class Teacher {
	private String name;
	private School school;
	private ArrayList<String> teachables;
	private AbsenceList absences;
	private Sub preferredSub;
	
	// DESC: constructor for new Teacher with single absence
	public Teacher(String name, School school, ArrayList<String> teachables, Absence absence) {
		this.name = name;
		this.school = school;
		this.teachables = teachables;
		this.absences = new AbsenceList();
		this.absences.addAbsence(absence);
	}
	
	// DESC: constructor for new Teacher with recurring absences
	public Teacher(String name, School school, ArrayList<String> teachables, AbsenceList absences) {
		this.name = name;
		this.school = school;
		this.teachables = teachables;
		this.absences = absences;
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
		absences.addAbsence(absence);
	}
	
	public Sub getPreferredSub() {
		return preferredSub;
	}
	
	public void setPrefferedSub(Sub sub) {
		preferredSub = sub;
	}
}
