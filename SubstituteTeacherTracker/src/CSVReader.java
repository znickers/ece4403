
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.*;

public class CSVReader {
	private static CSVParser csvParser;
	
	// TODO: finish reading absences
	// DESC: read absences from absences.csv
	public static void readAbsences(String filename) {
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in absences.csv
			for (CSVRecord record : csvParser) {
				String name = record.get("name");
				String startDate = record.get("start_date");
				String startPeriod = record.get("start_period");
				String endDate = record.get("end_date");
				String endPeriod = record.get("end_period");
				String location = record.get("location");
				String teachables = record.get("teachables");
				
				// DEBUG CODE: output csvParser results
				System.out.println("Absence Record: "+name+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod+" | "+location+" | "+teachables);
				
				// TODO: create an absence
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find absences.csv");
			ioe.printStackTrace();
		}
	}
	
	// TODO: finish reading absences
	// DESC: read substitutes from substitutes.csv
	public static void readSubstitutes(String filename) {
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in substitutes.csv
			for (CSVRecord record : csvParser) {
				String name = record.get("name");
				String startDate = record.get("start_date");
				String startPeriod = record.get("start_period");
				String endDate = record.get("end_date");
				String endPeriod = record.get("end_period");
				String blacklist = record.get("blacklist");
				String teachables = record.get("teachables");
				
				// DEBUG CODE: output csvParser results
				System.out.println("Substitute Record: "+name+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod+" | "+blacklist+" | "+teachables);
				
				// TODO: create a substitute
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find substitutes.csv");
			ioe.printStackTrace();
		}
	}
	
	// TODO: finish reading preferred subs
	// DESC: read preferred substitutes from preferred.csv
	public static void readPreferred(String filename) {
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in preferred.csv
			for (CSVRecord record : csvParser) {
				String teacherName = record.get("teacher");
				String subName = record.get("preferred substitute");
				
				// DEBUG CODE: output csvParser results
				System.out.println("Preferred Record: "+teacherName+" | "+subName);
				
				// TODO: assign preferred Sub to Teacher
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find preferred.csv");
			ioe.printStackTrace();
		}
	}
	
	// TODO: finish reading on-call contracts
	// DESC: read on-call contracts from oncalls.csv
	public static void readOnCalls(String filename) {
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in oncalls.csv
			for (CSVRecord record : csvParser) {
				String subName = record.get("substitute");
				String location = record.get("on-call contract location");
				
				// DEBUG CODE: output csvParser results
				System.out.println("On-Call Record: "+subName+" | "+location);
				
				// TODO: assign on-call contract to Sub
			}
			
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find oncalls.csv");
			ioe.printStackTrace();
		}
	}
}
