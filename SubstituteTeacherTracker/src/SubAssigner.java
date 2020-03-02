import java.util.ArrayList;
import java.util.Random;

public class SubAssigner
{	
	// DESC: method to assign subs to all absences
	public void assignSubs(AbsenceList absences, SubList subs) {
		// TODO: assign subs to each absence
		for(Absence absence : absences) {
			boolean available = true;
			System.out.println("ABSENCE:");
			System.out.println(absence);
			System.out.println();
			// TODO: check for conflicts between subs and absences
			// unavailabilities, blacklist, half-day, same period scheduled
			
			// iterate thru subs and 
			SubList availableSubs = new SubList();
			for(Sub sub : subs) {
				// TODO: check for previously assigned absences at same period
				available = checkAssignmentConflict(absence,sub);
				if(!available) {
					System.out.println("DEBUG: Previous assignment date conflicts with absence date.");
					break;
				}
				
				// TODO: check unavailabilities for conflicts
				available = checkUnavailabilityConflict(absence,sub);
				if(!available) {
					System.out.println("DEBUG: Sub unavailability date conflicts with absence date.");
					break;
				}
				
				// TODO: check blacklist for conflicts
				available = checkBlacklistConflict(absence,sub);
				if(!available) {
					System.out.println("DEBUG: Sub school blacklist conflicts with absence location.");
					break;
				}
				
				// TODO: check half-day for conflicts
				// JO: this feature may be complicated... need to know school on specific date...
				// JO: HashMap?
				// JO: also not worth checking until a Sub has been assigned an Absence
//				available = checkHalfDayConflict(absence,sub);
//				if(!available) {
//					break;
//				}
				
				// TODO: make list of subs who are available
				if(available) {
					availableSubs.add(sub);
				}
			}
			
			System.out.println("AVAILABLE SUBS:");
			System.out.println(availableSubs);
			System.out.println();
			
			// TODO: assign sub based on priority hierarchy
			// priority hierarchy (highest to lowest) - full day, on-call, preferred, teachables, random
			
			// TODO: assign based on full day
			// JO: this feature may be complicated... need to know school on specific date...
			// JO: HashMap?
			// JO: also not worth checking until a Sub has been assigned an Absence
			
			// TODO: assign based on on-call
//			availableSubs = assignByOnCall(absence,availableSubs);
			
			// TODO: assign based on preferred
//			assigned = assignByPreferred(absence,availableSubs);
			
			// TODO: assign based on teachables
			// JO: skip if assigned via preferred
			SubList teachableSubs = assignByTeachables(absence,availableSubs);
			System.out.println("TEACHABLE SUBS:");
			System.out.println(teachableSubs);
			System.out.println();
			if(teachableSubs.size() == 1) {
				absence.setSub(teachableSubs.get(0));
				continue;
			} else if(!teachableSubs.isEmpty()) {
				availableSubs = teachableSubs;
			} // if empty do nothing
			
			// TODO: assign based on random
			// JO: skip if assigned via preferred
			assignRandom(absence,availableSubs);
		}
	}
	
	// DESC: helper method to check for conflicts with previous Absence assignments
	private boolean checkAssignmentConflict(Absence absence, Sub sub)
	{
		boolean available = true;
		for(Absence assignedAbsence: sub.getAssignedAbsences())
			if(absence.getDate().equalsIgnoreCase(assignedAbsence.getDate()) && absence.getPeriod().equalsIgnoreCase(assignedAbsence.getPeriod())) {
				available = false;
				break;
			}
		return available;
	}
	
	// DESC: helper method to check for conflicts with Sub Unavailabilities
	private boolean checkUnavailabilityConflict(Absence absence, Sub sub) {
		boolean available = true;
		for(Unavailability u : sub.getUnavailabilities()) {
			if(u.getDate().equalsIgnoreCase(absence.getDate()) && u.getPeriod().equalsIgnoreCase(absence.getPeriod())) {
				available = false;
				break;
			}
		}
		return available;
	}
	
	// DESC: helper method to check for conflicts with Sub blacklist
	private boolean checkBlacklistConflict(Absence absence, Sub sub) {
		boolean available = true;
		for(School school : sub.getBlacklist()) {
			if(school.getName().equalsIgnoreCase(absence.getSchool().getName())) {
				available = false;
				break;
			}
		}
		return available;
	}
	
	private SubList assignByTeachables(Absence absence, SubList subList)
	{
		SubList suitableSubs = new SubList();
		ArrayList<Integer> subsPriority = new ArrayList<Integer>(); 
		int compatibility; 		//ZAC: Field to represent teacher-substitute compatibility.
		int largestComp = -1; 	//ZAC: Field to store largest compatibility value thus far.
		
		for(Sub sub: subList)
		{
			compatibility = sub.compareTo(absence.getTeacher());
			subsPriority.add(compatibility);
			if(compatibility>largestComp)
			{
				largestComp = compatibility;
			}
		}
		for(int i=0;i<subList.size();i++) {
			if(subsPriority.get(i) == largestComp) {
				suitableSubs.add(subList.get(i));
			}
		}
		return suitableSubs;
	}
	
	private void assignRandom(Absence absence, SubList subList)
	{
		if(subList.isEmpty()) {
			System.out.println("\nNo subs available to assign to absence.");
		} else {
			Random subIndex = new Random();
			absence.setSub(subList.get(subIndex.nextInt(subList.size())));
		}
	}
	
//	private int compareTo(Sub sub,Teacher teacher)
//	{
//		int compatibility = 0; //ZAC: Integer value to represent teacher-substitute compatibility. Higher value represents better compatibility.
//		ArrayList<String> teacherTeachables = teacher.getTeachables();
//		for(String teachable: teacherTeachables)
//		{
//			if(sub.getTeachables().contains(teachable))
//				compatibility++; //ZAC: If teacher and substitute share a common teachable, compatibility value will increase by 1.
//		}
//		return compatibility;
//	}
}
