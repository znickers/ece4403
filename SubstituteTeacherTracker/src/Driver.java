

public class Driver {

	public static void main(String[] args) {
		Test test = new Test();
		int[] isodate = new int[2];
		
		isodate = test.convertDate(2020, 02, 24);
		System.out.println("ISO week is: " + isodate[0] + "\nISO Day is: " + isodate[1]);
		
	}
}