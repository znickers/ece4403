import java.util.ArrayList;
import java.util.Random; 
  
public class AssignSub { 
	static ArrayList<String> sameDate = new ArrayList<String>();
	static ArrayList<Sub> sameSub = new ArrayList<Sub>();
	//SubList subList; 
	//CSVReader.readSubstitutes("data/substitutes.csv");
	
	// SIE: all preferences/conditions here (absences, teachables, etc)
	
	// SIE: make sure the subs arent being assigned to two of the same periods
	public int checkDate(Absence ab) {
		int date = 1;
		for(int i = 0; i < sameDate.size(); i++) {
			if(ab.getDate().equals(sameDate.get(i))) {
				date = 0;
			}
		}
		sameDate.add(ab.getDate());
		return date;
	}
		
	// SIE: select a random sub (based on index)
	public Sub randomSub(SubList sl) {
		Random randomSub = new Random();
		Sub rSub = sl.get(randomSub.nextInt(sl.size()));
		return rSub;
	}
    
	// take sub out of list so that they cant be assigned twice
	public SubList checkSub(SubList sl) {
		if(sl.size() == 1) {
			return sl;
		}else {
			for(int i = 0; i < sl.size(); i++) {
				for(int j = 0; j < sameSub.size(); j++) {
					if(sl.get(i) == sameSub.get(j)) {
						sl.remove(i);
					}
				}
			}
			return sl;
		}
	}
	
	/*public void setSubList(SubList sl) {
		for(int i = 0; i < sub.size(); i++) {
			sl.add(sub.get(i));
		}
	}
	*/
	
	// SIE: NOTE - this works as long as the date is always changing, and
	// for the first grouping of absences on the same day. Does not work when
	// there are more absences than subs, or when there are multiple absences 
	// in a day
    public Sub getSub(SubList sl, Absence ab) 
    { 	
       	Sub assignedSub;
       	
       	if(checkDate(ab) == 0) {
    		assignedSub = randomSub(checkSub(sl));
    		sameSub.add(assignedSub);
    	}else {
    		sl.addAll(sameSub);
    		sameSub.clear();
    		assignedSub = randomSub(sl);
    		sameSub.add(assignedSub);
    	}
		sameDate.add(ab.getDate());
		//System.out.println(sameSub);
		/*System.out.println("SubList:");
		for(Sub s : sub) {
			System.out.println(s);
			System.out.println();
		}*/
    	return assignedSub;
    }
}