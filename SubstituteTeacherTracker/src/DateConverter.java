
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {
	
	public int[] convertDate(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
	    DateTimeFormatter Weekformatter = DateTimeFormatter.ofPattern("ww"); //ISO Calendar ww - gives ISO week (1 to 52)
	    String ISOWeek = date.format(Weekformatter);
	    DateTimeFormatter Dayformatter = DateTimeFormatter.ofPattern("c"); //ISO Calendar 
	    String ISODay = date.format(Dayformatter);
	    int[] ISO = new int[2];
	    
	    ISO[0] = Integer.parseInt(ISOWeek);
	    ISO[1] = Integer.parseInt(ISODay);
	    return ISO;
	    
	    //Its treating Sunday as 1 and Saturday as 7, for the weekdays (2-6) the week is correct
	    //week is also correct for sunday but off by one for staturday. 
	}
}
