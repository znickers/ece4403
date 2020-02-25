
import java.util.ArrayList;

public class Calendar {
	private ArrayList<Week> weeks;
	private String startDay;
	
	public Calendar(String startDay) {
		weeks = new ArrayList<Week>();
		this.startDay = startDay;
		
		initializeWeeks();
	}
	
	// TODO: test method
	// DESC: add a new Absence
	public void addAbsence(int week, int day, String period, Teacher teacher) {
		// JO: tried to make this method readable while keeping it compact
		Day d = weeks.get(week).getDay(day);
		
		AbsenceList al = d.getAbsenceList();
		
		al.add(new Absence(teacher,d.getDate(),period,teacher.getSchool()));
	}
	
	// TODO: finish and test method
	// DESC: initializes the weeks in the calendar
	private void initializeWeeks() {
		String dayOfWeek;
		String date;
		int weekIndex = 0;
		
		// create and add all Weeks
		for(int i=0;i<52;i++) {
			weeks.add(new Week());
		}
		
		// JO: (364/7)=52, would need another week for 365 days
		// JO: kinda iffy on this init, gonna leave it in as a start
		// TODO: correctly determine dates using startDay
		// DESC: create and add all Days to Weeks
		for(int i=0;i<364;i++) {
			weekIndex = i % 52;
			switch(i%7) {
				case 0:
					dayOfWeek = "Monday";
					// TODO: need to set the correct date
					date = "";		// TEMP: placeholder for real date
					weeks.get(weekIndex).addDay(dayOfWeek, date);
					break;
				case 1:
					dayOfWeek = "Tuesday";
					// TODO: need to set the correct date
					date = "";		// TEMP: placeholder for real date
					weeks.get(weekIndex).addDay(dayOfWeek, date);
					break;
				case 2:
					dayOfWeek = "Wednesday";
					// TODO: need to set the correct date
					date = "";		// TEMP: placeholder for real date
					weeks.get(weekIndex).addDay(dayOfWeek, date);
					break;
				case 3:
					dayOfWeek = "Thursday";
					// TODO: need to set the correct date
					date = "";		// TEMP: placeholder for real date
					weeks.get(weekIndex).addDay(dayOfWeek, date);
					break;
				case 4:
					dayOfWeek = "Friday";
					// TODO: need to set the correct date
					date = "";		// TEMP: placeholder for real date
					weeks.get(weekIndex).addDay(dayOfWeek, date);
					break;
				default:
			}
		}
	}
}
