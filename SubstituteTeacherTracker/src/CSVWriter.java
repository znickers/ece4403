
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVWriter {
	private static CSVPrinter csvPrinter;
	
	public CSVWriter() {
		
	}
	
	// TODO: finish writeAssignment() method
	public static void writeAssignments() {
		try {
			csvPrinter = new CSVPrinter(new FileWriter("assignments.csv"), CSVFormat.EXCEL.withHeader("name", "phone number", "email"));
			
			// TODO: write sub assignments to assignments.csv
			
			// example output writing from class resources
			csvPrinter.printRecord("Aaron Tabor", "123-4567", "aaron.tabor@unb.ca");
			csvPrinter.printRecord("Ian Smith", "765-4321", "ian.smith@unb.ca");
			
		} catch(IOException ioe) {
			System.out.println("Error writing assignments.csv");
			ioe.printStackTrace();
		}
	}
}
