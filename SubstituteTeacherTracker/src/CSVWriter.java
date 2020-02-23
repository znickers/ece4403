
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVWriter {
	private static CSVPrinter csvPrinter;
	
	// TODO: finish writeAssignment() method
	// DESC: outputs sub assignments to assignments.csv
	public static void writeAssignments(String filename) {
		try {
			csvPrinter = new CSVPrinter(new FileWriter(filename), CSVFormat.EXCEL.withHeader("name", "phone number", "email"));
			
			// TODO: write sub assignments to assignments.csv
			
			// TEMP: example output write from class resources
			csvPrinter.printRecord("Aaron Tabor", "123-4567", "aaron.tabor@unb.ca");
			csvPrinter.printRecord("Ian Smith", "765-4321", "ian.smith@unb.ca");
			
		} catch(IOException ioe) {
			System.out.println("Error writing assignments.csv");
			ioe.printStackTrace();
		}
	}
}
