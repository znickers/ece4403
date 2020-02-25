
public class School {
	private String name;
	private TeacherList teachers;
	
	public School(String name) {
		this.name = name;
		teachers = new TeacherList();
	}
	
	public String getName() {
		return name;
	}
	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	// JO: might need to catch exception
	public void removeTeacher(Teacher teacher) {
		teachers.remove(teacher);
	}
	
	public String toString() {
		String str = "School: "+name;
		
		if(!teachers.isEmpty()) {
			str += "\nTeachers:";
			for(Teacher t : teachers) {
				str += "\n"+t.getName();
			}
		}
		return str;
	}
}
