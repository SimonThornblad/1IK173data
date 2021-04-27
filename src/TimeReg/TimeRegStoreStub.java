package TimeReg;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TimeRegStoreStub extends TimeRegStore {
	
	List<TimeRegEntity> entries = null;
	
	public TimeRegStoreStub() {
		entries = new ArrayList<TimeRegEntity>();
	}
	
	public void addTimeRegEntries(String userId, String projId, float hoursWorked,
			boolean isChargeable, Date date) {
		TimeRegEntity tre = new TimeRegEntity(userId, projId, hoursWorked, isChargeable, date);
		entries.add(tre);
	}
	
	@Override
	public TimeRegEntity[] getMonthlyRegs(String userId, int year, int month) {
		TimeRegEntity[] arr = new TimeRegEntity[entries.size()];		
		return entries.toArray(arr);
	}
}
