import java.util.ArrayList;

public class Registrar {
	
	// DEBUG: test driver
	public static void main(String[] args) {
		
		// DEBUG: test code for CSVReader
		AbsenceList absenceList = CSVReader.readAbsences("data/absences.csv");
		SubList subList = CSVReader.readSubstitutes("data/substitutes.csv");
		CSVReader.readPreferred("data/preferred.csv");
		CSVReader.readOnCalls("data/oncalls.csv");
		
		//DEBUG: Test code for assigning substitutes to absences based on teacher-substitute teachable compatibility.
		System.out.println();
//		System.out.println(absenceList);
		System.out.println();
//		System.out.println(subList);

		System.out.println();
		CSVReader.readUnavailabilities("data/unavailabilities.csv", subList);
		System.out.println(subList);
		System.out.println();
		
		SubAssigner subAssigner = new SubAssigner();
		subAssigner.assignSubs(absenceList, subList);
		CSVWriter.writeAssignments("data/assignments.csv", absenceList);
		System.out.println(absenceList);
		System.out.println();
		
//		for(Absence absence: absenceList)
//		{
//			absence.assignSub(subList);
//		}
//		
//		System.out.println("");
//		System.out.println(absenceList);
		
		
//		// DEBUG: test code for Absence toString()
//		System.out.println();
//		int sub = 1;
//		System.out.println("AbsenceList:");
//		for(Absence ab : absenceList) {
//			if(sub==1) {
//				// ab.setSub(new Sub("Ned Shneebly",new ArrayList<String>()));
//				// SIE: pick a sub from the sub arrayList, make sure same sub cant be put into
//				ab.setSub(new AssignSub().getSub(subList, ab));
//			}
//			sub--;
//			System.out.println(ab);
//			System.out.println();
//		}
//		
//		System.out.println("SubList:");
//		for(Sub s : subList) {
//			System.out.println(s);
//			System.out.println();
//		}
//		
//		// DEBUG: test code for School toString()
//		School school = new School("University of New Brunswick");
//		System.out.println(school);
//		System.out.println();
//		
//		ArrayList<String> t = new ArrayList<String>();
//		school.addTeacher(new Teacher("Richard J. Tervo",school,t));
//		school.addTeacher(new Teacher("Dennis F. Lovely",school,t));
//		System.out.println(school);
//		System.out.println();
//		
//		// DEBUG: test code for Teacher toString()
//		t.add("teaching");
//		t.add("speaking");
//		t.add("marking");
//		Teacher t1 = new Teacher("teacher1",school,t);
//		System.out.println(t1);
//		System.out.println();
//		t1.setPrefferedSub(new Sub("sub1",t));
//		System.out.println(t1);
//		System.out.println();
//		
//		// DEBUG: test code for Sub toString()
//		Sub s2 = new Sub("sub2",t);
//		System.out.println(subList);
//		System.out.println();
//		
//		// DEBUG: CSVWriter output
//		CSVWriter.writeAssignments("data/assignments.csv", absenceList);
//		
//		// DEBUG: test code for incorrect filename
//		//CSVReader.readSubstitutes("myfile.csv");
//		//System.out.println("Test output after incorrect filename");
	}
}
