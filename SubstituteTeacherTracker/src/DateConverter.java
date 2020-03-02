
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.text.ParseException;
import java.util.Calendar;

public class DateConverter {

	public int[] convertDateString(String givenDate) {
		
		//Connor - pass in a string in the form day-month-year ex: 20-Nov-2019 Retruns a day and week integer
		String[] values = givenDate.split("-");
		int day = Integer.parseInt(values[0]);
		int year = Integer.parseInt(values[2]);
		
		DateTimeFormatter MonthString = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = MonthString.parse(values[1]);
		int month = accessor.get(ChronoField.MONTH_OF_YEAR);
		
		LocalDate date = LocalDate.of(year, month, day);
	    DateTimeFormatter Weekformatter = DateTimeFormatter.ofPattern("ww"); //ISO Calendar ww - gives ISO week (1 to 52)
	    String ISOWeek = date.format(Weekformatter);
	    DateTimeFormatter Dayformatter = DateTimeFormatter.ofPattern("c"); //ISO Calendar
	    String ISODay = date.format(Dayformatter);
	    int[] ISO = new int[2];

	    ISO[0] = Integer.parseInt(ISOWeek);
	    ISO[1] = Integer.parseInt(ISODay);
	    return ISO;

	    //Connor - Its treating Sunday as 1 and Saturday as 7, for the weekdays (2-6) the week is correct
	}
	
	public String addADay(String OldDate) {
		//Connor - Adds a single day to any date string input
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(dateFormat.parse(OldDate));
		}
		catch(ParseException pe){
			System.out.println("EXCEPTION: Unable to parse date in DateConverter.");
			System.out.println(pe.getMessage());
			pe.printStackTrace();
			System.exit(300);
		}
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String NewDate = dateFormat.format(cal.getTime());
		
		return NewDate;
	}
}
