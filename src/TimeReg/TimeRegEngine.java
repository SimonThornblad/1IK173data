package TimeReg;

public class TimeRegEngine {
	TimeRegStore store = null;
	final double HoursPerMonth = 160.0;
	
	public TimeRegEngine(TimeRegStore trs) {
		store = trs;
	}
	
	public double getChargeability(String userId, int year, int month) {
		double sumChargeableHours = 0;
		TimeRegEntity[] entities = store.getMonthlyRegs(userId, year, month);
		
		for( TimeRegEntity tre:entities) {
			sumChargeableHours += tre.isChargeable() ? tre.getHoursWorked() : 0;
		}
		
		return sumChargeableHours/HoursPerMonth;
	}
	
}
