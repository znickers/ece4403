
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVWriter {
	private static CSVPrinter csvPrinter;
	
	// DESC: outputs sub assignments to assignments.csv
	public static void writeAssignments(String filename, AbsenceList absences) {
		try {
			csvPrinter = new CSVPrinter(new FileWriter(filename), CSVFormat.EXCEL.withHeader("absent_teacher","assigned_substitute","location","date","period"));
			
			for(Absence ab : absences) {
				if(ab.getStatus().equalsIgnoreCase("ASSIGNED")) {
					csvPrinter.printRecord(ab.getTeacher().getName(),ab.getSub().getName(),ab.getSchool().getName(),ab.getDate(),ab.getPeriod());
				}
			}
			csvPrinter.close();
			
		} catch(IOException ioe) {
			System.out.println("Error writing assignments.csv");
			ioe.printStackTrace();
			System.exit(20);
		}
	}
}
