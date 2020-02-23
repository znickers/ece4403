
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
		teachers.addTeacher(teacher);
	}
	
	// JO: might need to catch exception
	public void removeTeacher(Teacher teacher) {
		teachers.removeTeacher(teacher);
	}
}
