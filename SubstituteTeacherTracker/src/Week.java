
import java.util.ArrayList;

public class Week {
	private ArrayList<Day> days;
	
	public Week() {
		days = new ArrayList<Day>();
	}
	
	public void addDay(String dayOfWeek, String date) {
		days.add(new Day(dayOfWeek, date));
	}
	
	public Day getDay(int i) {
		return days.get(i);
	}
}
