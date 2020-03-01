import java.util.Random;

public class SubAssigner
{
	private Sub assignedSub;
	
	public Sub assignByTeachables(SubList subList, Teacher teacher, String date)
	{
		int compatibility; //ZAC: Field to represent teacher-substitute compatibility.
		int largestComp = -1; //ZAC: Field to store largest compatibility value thus far.
		for(Sub sub: subList)
		{
			compatibility = sub.compareTo(teacher);
			if(compatibility>largestComp)
			{
				if(sub.checkConflict(date) == false)
				{
					largestComp = compatibility;
					assignedSub = sub;
				}
			}
		}
		return assignedSub;
	}
	
	public Sub assignRandom(SubList subList, Teacher teacher, String date)
	{
		SubList availableSubs = new SubList();
		for(Sub sub: subList) //ZAC: Construct new SubList of available substitutes for the given date.
		{
			if(sub.checkConflict(date) == false)
			{
				availableSubs.add(sub);
			}
		}
		if(availableSubs.size() == 1)
				assignedSub = availableSubs.get(0);
		else
		{
			Random subIndex = new Random();
			assignedSub = availableSubs.get(subIndex.nextInt(availableSubs.size()));
		}
		return assignedSub;
	}
}
