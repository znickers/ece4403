
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
		updateStatus();
	}
	
	public void assignSub(SubList subList)
	{
		SubAssigner ass1 = new SubAssigner();
		sub = ass1.assignRandom(subList, teacher, date);
		updateStatus();
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
	
	private void updateStatus() {
		if(this.sub == null) {
			this.status = "UNASSIGNED";
		} else {
			this.status = "ASSIGNED";
		}
	}
	
	public String toString() {
		String str = "";
		if(status.equalsIgnoreCase("UNASSIGNED")) {
			str += "\n\nABSENCE\nTeacher: "+teacher.getName()+"\nDate: "+date+" "+period+
				   "\nLocation: "+school.getName()+"\nStatus: "+status;
		} else if(status.equalsIgnoreCase("ASSIGNED")) {
			str += "\n\nABSENCE\nTeacher: "+teacher.getName()+"\nDate: "+date+" "+period+
					   "\nLocation: "+school.getName()+"\nStatus: "+status+
				   "\nAssigned substitute: "+sub.getName();
		}
		return str;
	}
}
