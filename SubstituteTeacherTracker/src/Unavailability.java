
public class Unavailability {
	private String date;
	private String period;
	
	public Unavailability(String date, String period) {
		this.date = date;
		this.period = period;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public String toString() {
		return "UNAVAILABILITY: "+date+" "+period;
	}
}
