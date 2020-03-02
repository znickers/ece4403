
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.*;

public class CSVReader {
	private static CSVParser csvParser;
	
	// DESC: read absences from absences.csv
	public static AbsenceList readAbsences(String filename) {
		AbsenceList absenceList = new AbsenceList();
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			// DESC: parse thru entries in absences.csv
			for (CSVRecord record : csvParser) {
				String name = "";
				String startDate = "";
				String startPeriod = "";
				String endDate = "";
				String endPeriod = "";
				String location = "";
				String str_teachables = "";
				try {
					name = record.get("name");
					startDate = record.get("start_date");
					startPeriod = record.get("start_period");
					endDate = record.get("end_date");
					endPeriod = record.get("end_period");
					location = record.get("location");
					str_teachables = record.get("teachables");
				} catch(IllegalArgumentException iae) {
					System.out.println("EXCEPTION: Incorrect header formatting in absences.csv.");
					System.out.println(iae.getMessage());
					System.exit(101);
				}
				
				// DEBUG: output csvParser results
				System.out.println("Absence Record: "+name+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod+" | "+location+" | "+str_teachables);
				
				School school = new School(location);
				ArrayList<String> al_teachables = new ArrayList<String>();
				al_teachables.addAll(Arrays.asList(str_teachables.toLowerCase().split("/")));
				Teacher teacher = new Teacher(name,school,al_teachables);
				
				if((!startDate.equalsIgnoreCase(endDate)) || (!startPeriod.equalsIgnoreCase(endPeriod))) {		// extended absences
					// TEMP: reminder println to implement feature
					System.out.println("\nExtended absence read.");
					
					// JO: deferred Extended Absence handling to helper method, thought it'd make this method easier to read
					readExtendedAbsence(absenceList,teacher,school,startDate,startPeriod,endDate,endPeriod);
					
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
			System.out.println(ioe.getMessage());
			System.exit(100);		// JO: close program if file not found, could find more elegant method to handle this
		}
		return absenceList;
	}
	
	// DESC: read substitutes from substitutes.csv
	public static SubList readSubstitutes(String filename) {
		SubList subList = new SubList();
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in substitutes.csv
			for (CSVRecord record : csvParser) {
				String name = "";
				String str_teachables = "";
				String str_blacklist = "";
				try {
					name = record.get("name");
					str_teachables = record.get("teachables");
					str_blacklist = record.get("blacklist");
				} catch(IllegalArgumentException iae) {
					System.out.println("EXCEPTION: Incorrect header formatting in substitutes.csv.");
					System.out.println(iae.getMessage());
					System.exit(111);
				}
				
				// DEBUG: output csvParser results
				System.out.println("Substitute Record: "+name+" | "+str_teachables+" | "+str_blacklist);

				ArrayList<String> al_teachables = new ArrayList<String>();
				al_teachables.addAll(Arrays.asList(str_teachables.toLowerCase().split("/")));
				Sub sub = new Sub(name,al_teachables);
				
				// TODO: set sub's blacklist
				SchoolList blacklist = new SchoolList();
				ArrayList<String> al_blacklist = new ArrayList<String>();
				al_blacklist.addAll(Arrays.asList(str_blacklist.split("/")));
				for(String schoolName : al_blacklist) {
					blacklist.add(new School(schoolName));
				}
				sub.setBlacklist(blacklist);
				
				subList.add(sub);
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find substitutes.csv");
			System.out.println(ioe.getMessage());
			System.exit(110);		// JO: close program if file not found, could find more elegant method to handle this
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
				System.out.println("\nUnavailability Record: "+subName+" | "+startDate+" | "+startPeriod+" | "+endDate+" | "+endPeriod);
				
				// TODO: assign unavailabilities to Sub
				Sub unSub = new Sub("",new ArrayList<String>());
				for(Sub sub : subList) {
					if(sub.getName().equalsIgnoreCase(subName)) {
						unSub = sub;
					}
				}
				if(unSub.getName().equalsIgnoreCase("")) {
					System.out.println("No Sub in system with name '"+subName+"' to assign unavailability to.");
					continue;
				}
//				System.out.println("DEBUG - Registered sub: "+subName);
				
				// JO: REFACTOR into readUnavailabilities
				if((!startDate.equalsIgnoreCase(endDate)) || (!startPeriod.equalsIgnoreCase(endPeriod))) {		// extended absences
					// TODO: generate individual unavailabilities and add to an unavailabilitiesList
					
					// TEMP: reminder println to implement feature
					System.out.println("DEBUG - Extended sub unavailability read.");
					
					readExtendedUnavailability(unSub,startDate,startPeriod,endDate,endPeriod);
				} else if(startDate.equalsIgnoreCase(endDate) && startPeriod.equalsIgnoreCase(endPeriod)) {		// single absence
					System.out.println("DEBUG - Single sub unavailability read.");		// DEBUG: println statement
					
					unavailability = new Unavailability(startDate,startPeriod);
					UnavailabilityList ul = unSub.getUnavailabilities();
					boolean duplicate = checkDuplicateUnavailability(unSub,startDate,startPeriod);
					if(!duplicate) {
						unSub.addUnavailability(unavailability);
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
				String teacherName = "";
				String subName = "";
				try {
					teacherName = record.get("teacher");
					subName = record.get("preferred substitute");
				} catch(IllegalArgumentException iae) {
					System.out.println("EXCEPTION: Incorrect header formatting in preferred.csv.");
					System.out.println(iae.getMessage());
					System.exit(131);
				}
				
				// DEBUG: output csvParser results
				System.out.println("Preferred Record: "+teacherName+" | "+subName);
				
				// TODO: assign preferred Sub to Teacher
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find preferred.csv");
			ioe.printStackTrace();
			System.exit(130);		// JO: close program if file not found, could find more elegant method to handle this
		}
	}
	
	// TODO: finish reading on-call contracts
	// DESC: read on-call contracts from oncalls.csv
	public static void readOnCalls(String filename) {
		try {
			csvParser = new CSVParser(new FileReader(filename), CSVFormat.EXCEL.withFirstRecordAsHeader());
			
			// DESC: parse thru entries in oncalls.csv
			for (CSVRecord record : csvParser) {
				String subName = "";
				String location = "";
				try {
					subName = record.get("substitute");
					location = record.get("on-call contract location");
				} catch(IllegalArgumentException iae) {
					System.out.println("EXCEPTION: Incorrect header formatting in oncalls.csv.");
					System.out.println(iae.getMessage());
					System.exit(141);
				}
				
				// DEBUG: output csvParser results
				System.out.println("On-Call Record: "+subName+" | "+location);
				
				// TODO: assign on-call contract to Sub
			}
			csvParser.close();
		} catch(IOException ioe) {
			System.out.println("Unable to find oncalls.csv");
			ioe.printStackTrace();
			System.exit(140);		// JO: close program if file not found, could find more elegant method to handle this
		}
	}
	
	// DESC: creates single period Absences from an extended Absence range and adds them to an AbsenceList
	private static void readExtendedAbsence(AbsenceList absenceList,Teacher teacher,School school,String startDate,String startPeriod,String endDate,String endPeriod) {
		DateConverter dateconvert = new DateConverter();
		int[] ISOStart = dateconvert.convertDateString(startDate);
		int[] ISOEnd = dateconvert.convertDateString(endDate);
		
		int extendedAbsence = ((ISOEnd[0] - ISOStart[0])*7) + (ISOEnd[1] - ISOStart[1] +1);
		
		for(int i = 0; i < extendedAbsence; i++) {
			if((i == 0) && (startPeriod.equals("PM"))){
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
			}
			else if((i == 0) && (startPeriod.equals("AM"))) {
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
				startPeriod = "PM";
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
			}
			else if((i == (extendedAbsence - 1)) && endPeriod.equals("AM")) {
				startDate = endDate;
				startPeriod = endPeriod;
				System.out.println(endPeriod);
				
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
			}
			else if( i > 0) {

				startDate = dateconvert.addADay(startDate);
				int[] CurrentDay = dateconvert.convertDateString(startDate);
				
				if(CurrentDay[1] == 1 || CurrentDay[1] == 7) {
					continue;
				}
				
				startPeriod = "AM";
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
				startPeriod = "PM";
				absenceList.add(new Absence(teacher,startDate,startPeriod,school));
			}
		}
		
		System.out.println("Number of Days in extended absence: " + extendedAbsence + "\n");
	}
	
	// DESC: creates single period Unavailabilities from an extended Unavailability range and adds them to a Sub's unavailabilities
	private static void readExtendedUnavailability(Sub sub,String startDate,String startPeriod,String endDate,String endPeriod) {
		DateConverter dateconvert = new DateConverter();
		int[] ISOStart = dateconvert.convertDateString(startDate);
		int[] ISOEnd = dateconvert.convertDateString(endDate);
		
		int extendedUnavailability = ((ISOEnd[0] - ISOStart[0])*7) + (ISOEnd[1] - ISOStart[1] +1);
		
		boolean duplicate = false;
		
		for(int i = 0; i < extendedUnavailability; i++) {
			if((i == 0) && (startPeriod.equals("PM"))){
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
			}
			else if((i == 0) && (startPeriod.equals("AM"))) {
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
				startPeriod = "PM";
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
			}
			else if((i == (extendedUnavailability - 1)) && endPeriod.equals("AM")) {
				startDate = endDate;
				startPeriod = endPeriod;
				System.out.println(endPeriod);
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
			}
			else if( i > 0) {

				startDate = dateconvert.addADay(startDate);
				int[] CurrentDay = dateconvert.convertDateString(startDate);
				
				if(CurrentDay[1] == 1 || CurrentDay[1] == 7) {
					continue;
				}
				
				startPeriod = "AM";
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
				startPeriod = "PM";
				duplicate = checkDuplicateUnavailability(sub,startDate,startPeriod);
				if(!duplicate) {
					sub.addUnavailability(new Unavailability(startDate,startPeriod));
				}
			}
		}
		System.out.println("Number of Days in extended unavailability: " + extendedUnavailability + "\n");
	}
	
	// DESC: checks for an existing Unavailability in a Sub's unavailabilities at a given a date
	private static boolean checkDuplicateUnavailability(Sub sub,String startDate,String startPeriod) {
		boolean duplicate = false;				// prevent duplicate unavailabilities from being assigned
		UnavailabilityList ul = sub.getUnavailabilities();
		for(int i=0;i<ul.size();i++) {
			if(ul.get(i).getDate().equalsIgnoreCase(startDate) && ul.get(i).getPeriod().equalsIgnoreCase(startPeriod)) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}
	
}
