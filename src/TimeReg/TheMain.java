package TimeReg;

public class TheMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeRegStoreStub_Bad storeBad = new TimeRegStoreStub_Bad();
		TimeRegStore store = new TimeRegStore();
		
		TimeRegEngine engine1 = new TimeRegEngine( store);
		
		TimeRegEngine engine2 = new TimeRegEngine( storeBad);

	}

}
