
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolList {
	private ArrayList<School> schools;
	
	public SchoolList() {
		schools = new ArrayList<School>();
	}
	
	public void addSchool(School school) {
		schools.add(school);
	}
	
	// TODO: test method
	// JO: there might be a better way to implement this
	// JO: might need to catch exception
	public void removeSchool(School school) {
		schools.remove(school);
	}
	
	// TODO: test method
	// JO: again, might be a better way to implement this
	// JO: any call to this method will need to check for null return
	// DESC: get a specific School from the SchoolList
	public School getSchool(School school) {
		Iterator<School> is = schools.iterator();
		School s;
		School foundSchool = null;
		
		while(is.hasNext()) {
			s = is.next();
			
			if(s.getName().equals(school.getName())) {
				foundSchool = s;
				break;
			}
		}
		
		return foundSchool;
	}
}
