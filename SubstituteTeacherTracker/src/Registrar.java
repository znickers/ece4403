
public class Registrar {
	
	// DEBUG: test driver
	public static void main(String[] args) {
		
		// DEBUG: test code for CSVReader
		CSVReader.readAbsences("absences.csv");
		CSVReader.readSubstitutes("substitutes.csv");
		CSVReader.readPreferred("preferred.csv");
		CSVReader.readOnCalls("oncalls.csv");
	}
}
