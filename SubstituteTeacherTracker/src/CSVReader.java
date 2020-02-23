
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVReader {
	private static CSVParser csvParser; //new CSVParser(new FileReader("contacts.csv"), CSVFormat.EXCEL.withFirstRecordAsHeader());
	
	public CSVReader() {//throws IOException {
		//csvParser = new CSVParser(new FileReader("contacts.csv"), CSVFormat.EXCEL.withFirstRecordAsHeader());
	}
	
	// TODO: finish reading absences
	// maybe change return type...
	public static void readAbsences() {
		try {
			csvParser = new CSVParser(new FileReader("absences.csv"), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// TODO: figure out csv structure and parse accordingly
			for (CSVRecord record : csvParser) {
				// example reading from class resources
				// Change allll of this
				String name = record.get("name");
				String phoneNumber = record.get("phone number");
				String email = record.get("email");
				System.out.println("CSV Record: " + name + " | " + phoneNumber + " | " + email);
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find absences.csv");
			ioe.printStackTrace();
		}
	}
	
	public static void readSubstitutes() {
		try {
			csvParser = new CSVParser(new FileReader("substitutes.csv"), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// TODO: figure out csv structure and parse accordingly
			for (CSVRecord record : csvParser) {
				// example reading from class resources
				// Change allll of this
				String name = record.get("name");
				String phoneNumber = record.get("phone number");
				String email = record.get("email");
				System.out.println("CSV Record: " + name + " | " + phoneNumber + " | " + email);
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find substitutes.csv");
			ioe.printStackTrace();
		}
	}
}
