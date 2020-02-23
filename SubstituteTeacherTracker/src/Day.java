public class Day {
	private final String DAYOFWEEK;
	private final String DATE;
	private AbsenceList absences;
	
	public Day(String dayOfWeek, String date) {
		this.DAYOFWEEK = dayOfWeek;
		this.DATE = date;
		absences = new AbsenceList();
	}
	
	public String getDayofWeek() {
		return DAYOFWEEK;
	}
	
	public String getDate() {
		return DATE;
	}
	
	public AbsenceList getAbsenceList() {
		return absences;
	}
}
