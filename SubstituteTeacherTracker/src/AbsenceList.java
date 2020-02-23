
import java.util.ArrayList;

public class AbsenceList {
	private ArrayList<Absence> absences;
	
	public AbsenceList() {
		absences = new ArrayList<Absence>();
	}
	
	// DESC: adds an Absence to the absences list
	public void addAbsence(Absence absence) {
		absences.add(absence);
	}
	
	// TODO: test method
	// JO: there might be a better way to implement this
	// DESC: removes an Absence from the absences list
	public void removeAbsence(Absence absence) {
		absences.remove(absence);
	}
}
