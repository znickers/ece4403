
public class Absence {
	private Teacher teacher;
	private String date;
	private Sub sub;
	private String status;
	
	public Absence(Teacher teacher, String date) {
		this.teacher = teacher;
		this.date = date;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public String getDate() {
		return date;
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
