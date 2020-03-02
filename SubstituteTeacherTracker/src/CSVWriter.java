
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVWriter {
	private static CSVPrinter csvPrinter;
	
	// DESC: outputs sub assignments to assignments.csv
	public static void writeAssignments(String filename, AbsenceList absences) {
		try {
			csvPrinter = new CSVPrinter(new FileWriter(filename), CSVFormat.EXCEL.withHeader("assigned_substitute","absent_teacher","location","date","period"));
			
			for(Absence ab : absences) {
				if(ab.getStatus().equalsIgnoreCase("ASSIGNED")) {
					csvPrinter.printRecord(ab.getSub().getName(),ab.getTeacher().getName(),ab.getSchool().getName(),ab.getDate(),ab.getPeriod());
				}
			}
			csvPrinter.close();
			
		} catch(IOException ioe) {
			System.out.println("Error writing assignments.csv");
			System.out.println(ioe.getMessage());
			System.exit(200);
		}
	}
}
