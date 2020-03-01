
public class Registrar {
	
	// DEBUG: test driver
	public static void main(String[] args) {
		
		// DEBUG: test code for CSVReader
		AbsenceList aList = CSVReader.readAbsences("data/absences.csv");
		SubList sList = CSVReader.readSubstitutes("data/substitutes.csv");
		CSVReader.readPreferred("data/preferred.csv");
		CSVReader.readOnCalls("data/oncalls.csv");
		
		//DEBUG: Test code for assigning substitutes to absences based on teacher-substitute teachable compatibility.
		System.out.println("");
		System.out.println(aList);
		System.out.println("");
		System.out.println(sList);
		
		for(Absence absence: aList)
		{
			System.out.println(absence.getDate());
			absence.assignSub(sList);
		}
		
		System.out.println("");
		System.out.println(aList);
		
		
		/*
		// DEBUG: test code for Absence toString()
		System.out.println();
		int sub = 1;
		System.out.println("AbsenceList:");
		for(Absence ab : al) {
			if(sub==1) {
				ab.setSub(new Sub("Ned Shneebly",new ArrayList<String>()));
			}
			sub--;
			System.out.println(ab);
			System.out.println();
		}
		
		System.out.println("SubList:");
		for(Sub s : sl) {
			System.out.println(s);
			System.out.println();
		}
		
		// DEBUG: test code for School toString()
		School school = new School("University of New Brunswick");
		System.out.println(school);
		System.out.println();
		
		ArrayList<String> t = new ArrayList<String>();
		school.addTeacher(new Teacher("Richard J. Tervo",school,t));
		school.addTeacher(new Teacher("Dennis F. Lovely",school,t));
		System.out.println(school);
		System.out.println();
		
		// DEBUG: test code for Teacher toString()
		t.add("teaching");
		t.add("speaking");
		t.add("marking");
		Teacher t1 = new Teacher("teacher1",school,t);
		System.out.println(t1);
		System.out.println();
		t1.setPrefferedSub(new Sub("sub1",t));
		System.out.println(t1);
		System.out.println();
		
		// DEBUG: test code for Sub toString()
		Sub s2 = new Sub("sub2",t);
		System.out.println(s1);
		System.out.println();
		
		// DEBUG: CSVWriter output
		CSVWriter.writeAssignments("data/assignments.csv", al);
		
		// DEBUG: test code for incorrect filename
		//CSVReader.readSubstitutes("myfile.csv");
		//System.out.println("Test output after incorrect filename");
		 */
	}
}
