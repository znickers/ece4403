import java.util.ArrayList;

public class Registrar {
	
	// DEBUG: test driver
	public static void main(String[] args) {
		
		// DEBUG: test code for CSVReader
		AbsenceList al = CSVReader.readAbsences("data/absences.csv");
		CSVReader.readSubstitutes("data/substitutes.csv");
		CSVReader.readPreferred("data/preferred.csv");
		CSVReader.readOnCalls("data/oncalls.csv");
		
		// DEBUG: test code for Absence toString()
		int sub = 1;
		for(Absence ab : al) {
			if(sub==1) {
				ab.setSub(new Sub("Ned Shneebly",new ArrayList<String>()));
			}
			sub--;
			System.out.println(ab);
		}
		
		// DEBUG: test code for School toString()
		School school = new School("University of New Brunswick");
		System.out.println(school);
		
		ArrayList<String> t = new ArrayList<String>();
		school.addTeacher(new Teacher("Richard J. Tervo",school,t));
		school.addTeacher(new Teacher("Dennis F. Lovely",school,t));
		System.out.println(school);
		
		// DEBUG: test code for Teacher toString()
		t.add("teaching");
		t.add("speaking");
		t.add("marking");
		Teacher t1 = new Teacher("teacher1",school,t);
		System.out.println(t1);
		t1.setPrefferedSub(new Sub("sub1",t));
		System.out.println(t1);
		
		// DEBUG: test code for Sub toString()
		Sub s1 = new Sub("sub2",t);
		System.out.println(s1);
		
		// DEBUG: test code for incorrect filename
//		CSVReader.readSubstitutes("myfile.csv");
//		System.out.println("Test output after incorrect filename");
	}
}
