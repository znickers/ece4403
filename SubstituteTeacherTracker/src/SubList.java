
import java.util.ArrayList;
import java.util.Iterator;

public class SubList {
	private ArrayList<Sub> subs;
	
	public SubList() {
		subs = new ArrayList<Sub>();
	}
	
	public void addSub(Sub sub) {
		subs.add(sub);
	}
	
	// TODO: test method
	// JO: there might be a better way to implement this
	// JO: might need to catch exception
	public void removeSub(Sub sub) {
		subs.remove(sub);
	}
	
	// TODO: test method
	// JO: again, might be a better way to implement this
	// JO: any call to this method will need to check for null return
	// DESC: get a specific Sub from the SubList
	public Sub getSub(Sub sub) {
		Iterator<Sub> is = subs.iterator();
		Sub s;
		Sub foundSub = null;
		
		while(is.hasNext()) {
			s = is.next();
			
			if(s.getName().equals(sub.getName())) {
				foundSub = s;
				break;
			}
		}
		
		return foundSub;
	}
}
