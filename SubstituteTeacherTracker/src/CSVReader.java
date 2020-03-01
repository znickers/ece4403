
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.*;

public class CSVReader {
	private static CSVParser csvParser;
	
	// TODO: finish reading absences
	// DESC: read absences from absences.csv
	public static AbsenceList readAbsences(String filename) {
		AbsenceList absenceList = new AbsenceList();
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
				String str_teachables = record.get("teachables");
				
				// DEBUG: output csvParser results
				System.out.println("Absence Record: "+name+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod+" | "+location+" | "+str_teachables);
				
				// TODO: create an absence
				School school = new School(location);
				ArrayList<String> al_teachables = new ArrayList<String>();
				al_teachables.addAll(Arrays.asList(str_teachables.toLowerCase().split(" ")));
				Teacher teacher = new Teacher(name,school,al_teachables);
				
				if((!startDate.equalsIgnoreCase(endDate)) || (!startPeriod.equalsIgnoreCase(endPeriod))) {		// extended absences
					// TODO: generate individual absences and add to the absenceList
					
					// TEMP: reminder println to implement feature
					System.out.println("Extended absence read.");
				} else if(startDate.equalsIgnoreCase(endDate) && startPeriod.equalsIgnoreCase(endPeriod)) {		// single absence
					absenceList.add(new Absence(teacher,startDate,startPeriod,school));
				} else {	// invalid date input
					// JO: thought this should be considered, could assume all dates are input correctly
					// JO: cases - startDate happens after endDate, incorrect format, incorrect entry
					
					// TODO: handle invalid inputs
					System.out.println("Invalid absence date entered.");
				}
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find absences.csv");
			ioe.printStackTrace();
			System.exit(10);		// JO: close program if file not found, could find more elegant method to handle this
		}
		return absenceList;
	}
	
	// TODO: finish reading absences
	// DESC: read substitutes from substitutes.csv
	public static SubList readSubstitutes(String filename) {
		SubList subList = new SubList();
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in substitutes.csv
			for (CSVRecord record : csvParser) {
				String name = record.get("name");
				String blacklist = record.get("blacklist");
				String str_teachables = record.get("teachables");
				
				// DEBUG: output csvParser results
				System.out.println("Substitute Record: "+name+" | "+blacklist+" | "+str_teachables);

				// TODO: create a substitute
				ArrayList<String> al_teachables = new ArrayList<String>();
				al_teachables.addAll(Arrays.asList(str_teachables.toLowerCase().split(" ")));
				Sub sub = new Sub(name,al_teachables);
				
				// TODO: set sub's blacklist
				
				subList.add(sub);
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find substitutes.csv");
			ioe.printStackTrace();
			System.exit(11);		// JO: close program if file not found, could find more elegant method to handle this
		}
		return subList;
	}
	
	// TODO: finish reading on-call contracts
	// DESC: read unavailabilities from unavailabilities.csv
	public static void readUnavailabilities(String filename, SubList subList) {
		Unavailability unavailability;
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in unavailabilities.csv
			for (CSVRecord record : csvParser) {
				String subName = "";
				String startDate = "";
				String startPeriod = "";
				String endDate = "";
				String endPeriod = "";
				try {
					subName = record.get("substitute_name");
					startDate = record.get("start_date");
					startPeriod = record.get("start_period");
					endDate = record.get("end_date");
					endPeriod = record.get("end_period");
				} catch(IllegalArgumentException iae) {
					System.out.println("EXCEPTION: Incorrect header formatting in unavailabilities.csv.");
					System.out.println(iae.getMessage());
					System.exit(121);
				}
				
				// DEBUG: output csvParser results
				System.out.println("Unavailability Record: "+subName+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod);
				
				// TODO: assign unavailabilities to Sub
				
				// JO: REFACTOR into readUnavailabilities
				if((!startDate.equalsIgnoreCase(endDate)) || (!startPeriod.equalsIgnoreCase(endPeriod))) {		// extended absences
					// TODO: generate individual unavailabilities and add to an unavailabilitiesList
					
					// TEMP: reminder println to implement feature
					System.out.println("Extended sub unavailabilities read.");
				} else if(startDate.equalsIgnoreCase(endDate) && startPeriod.equalsIgnoreCase(endPeriod)) {		// single absence
					System.out.println("Single sub unavailability read.");		// DEBUG: println statement
					unavailability = new Unavailability(startDate+" "+startPeriod);
					for(Sub sub : subList) {
						if(sub.getName().equalsIgnoreCase(subName)) {
							sub.addUnavailability(unavailability);
//							unavailability.setSub(sub);		// JO: might not need to do this. Only accessing Unavailabilities thru Subs
							break;
						}
					}
				} else {	// invalid date input
					// JO: thought this should be considered, could assume all dates are input correctly
					// JO: cases - startDate happens after endDate, incorrect format, incorrect entry
					
					// TODO: handle invalid inputs
					System.out.println("Invalid sub unavailability date entered.");
				}
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("EXCEPTION: Unable to find unavailabilities.csv");
			System.out.println(ioe.getMessage());
			System.exit(120);		// JO: close program if file not found, could find more elegant method to handle this
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
				
				// DEBUG: output csvParser results
				System.out.println("Preferred Record: "+teacherName+" | "+subName);
				
				// TODO: assign preferred Sub to Teacher
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find preferred.csv");
			ioe.printStackTrace();
			System.exit(13);		// JO: close program if file not found, could find more elegant method to handle this
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
				
				// DEBUG: output csvParser results
				System.out.println("On-Call Record: "+subName+" | "+location);
				
				// TODO: assign on-call contract to Sub
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find oncalls.csv");
			ioe.printStackTrace();
			System.exit(14);		// JO: close program if file not found, could find more elegant method to handle this
		}
	}
}
