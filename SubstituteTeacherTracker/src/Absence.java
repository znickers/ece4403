
public class Absence {
	private Teacher teacher;
	private String date;
	private String period;
	private School school;
	private Sub sub;
	private String status;
	
	public Absence(Teacher teacher, String date, String period, School school) {
		this.teacher = teacher;
		this.date = date;
		this.period = period;
		this.school = school;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPeriod() {
		return period;
	}
	
	// JO: thought Absences should have a reference to the school the Absence is at
	// JO: added this in for now
	public School getSchool() {
		return school;
	}
	
	public Sub getSub() {
		return sub;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setSub(Sub sub) {
		this.sub = sub;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
