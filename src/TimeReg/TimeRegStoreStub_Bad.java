package TimeReg;

import java.util.Date;

public class TimeRegStoreStub_Bad extends TimeRegStore {

	@Override
	public TimeRegEntity[] getMonthlyRegs(String userId, int year, int month) {
		TimeRegEntity[] entries = new TimeRegEntity[1];

		entries[0] = new TimeRegEntity(userId, "p1", 2, true, new Date(2020,1,5));
		
		return entries;
	}
}
