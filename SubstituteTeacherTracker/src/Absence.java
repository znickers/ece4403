
public class Absence{
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
	
	//ZAC: Logic to assign substitute to absence based on teacher-substitute compatibility.
	//ZAC: May need a try/catch block for the case that subList is empty.
	public void assignSub(SubList subList)
	{
		Sub assignedSub = null;
		int largest = -1; //Lowest possible compatibility value is 0. This -1 ensures a substitute will be assigned, provided subList is not empty.
		for(Sub sub: subList)
		{
			if(sub.compareTo(this.teacher)>largest)
			{
				assignedSub = sub;
				largest = assignedSub.compareTo(this.teacher);
			}
		}
		this.sub = assignedSub;
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
	
	public void setSub(Sub sub) {
		this.sub = sub;
		updateStatus();
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
