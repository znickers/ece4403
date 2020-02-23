
import java.util.ArrayList;
import java.util.Iterator;

public class TeacherList {
	private ArrayList<Teacher> teachers;
	
	public TeacherList() {
		teachers = new ArrayList<Teacher>();
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	// TODO: test method
	// JO: there might be a better way to implement this
	// JO: might need to catch exception
	public void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
	}
	
	// TODO: test method
	// JO: again, might be a better way to implement this
	// JO: any call to this method will need to check for null return
	// DESC: get a specific Teacher from the TeacherList
	public Teacher getTeacher(Teacher teacher) {
		Iterator<Teacher> it = teachers.iterator();
		Teacher t;
		Teacher foundTeacher = null;
		
		while(it.hasNext()) {
			t = it.next();
			
			if(t.getName().equals(teacher.getName())) {
				foundTeacher = t;
				break;
			}
		}
		
		return foundTeacher;
	}
}
