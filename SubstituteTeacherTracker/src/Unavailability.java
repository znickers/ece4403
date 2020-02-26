
public class Unavailability {
	// JO: does an Unavailability need to know the Sub it belongs to?
	private Sub sub;
	private String date;
	
	public Unavailability(Sub sub, String date) {
		this.sub = sub;
		this.date = date;
	}
	
	public Sub getSub() {
		return sub;
	}
	
	public String getDate() {
		return date;
	}
	
	public String toString() {
		String str = "";
		str += "UNAVAILABILITY: "+date;
		return str;
	}
}
