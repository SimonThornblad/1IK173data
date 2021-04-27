package TimeReg;

import java.util.Date;
import java.util.List;

import TimeReg.TimeRegStoreStub;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TimeRegEngineTest {

	@Test
	void testGetChargeability() {
		TimeRegStoreStub stub = new TimeRegStoreStub();
		TimeRegEngine cut = new TimeRegEngine(stub);
		
		stub.addTimeRegEntries("john", "p1", 2, true, new Date(2020,1,1));
		stub.addTimeRegEntries("john", "p1", 2, false, new Date(2020,1,2));
		stub.addTimeRegEntries("john", "p1", 2, true, new Date(2020,1,3));
		
		assertEquals(0.025, cut.getChargeability("john", 2020, 1));		
		
	}
	
	@Test
	void testGetChargeability_Mockito() {
		TimeRegStore trs = mock(TimeRegStore.class);
		TimeRegEngine cut = new TimeRegEngine(trs);
		
		when(trs.getMonthlyRegs("john", 2020, 1))
			.thenReturn( new TimeRegEntity[] {
				new TimeRegEntity("john", "p1", 2, true, new Date(2020,1,1)),
				new TimeRegEntity("john", "p1", 2, false, new Date(2020,1,2)),
				new TimeRegEntity("john", "p1", 2, true, new Date(2020,1,3)),				
			});
		
		assertEquals(0.025, cut.getChargeability("john", 2020, 1));	
	}
	
	
	@Test
	void testGetChargeability_Mockito2() {
		// Setup
		TimeRegStore trs = mock(TimeRegStore.class);
		TimeRegEngine cut = new TimeRegEngine(trs);

		when(trs.getMonthlyRegs("john", 2019, 1))
				.thenReturn(new TimeRegEntity[] { new TimeRegEntity("john", "p1", 2, true, new Date(2019, 1, 1)),
						new TimeRegEntity("john", "p1", 2, false, new Date(2019, 1, 2)),
						new TimeRegEntity("john", "p1", 2, true, new Date(2019, 1, 3)), });

		// Recording
		cut.getChargeability("john", 2019, 1);
		
		// Verify
		verify(trs).getMonthlyRegs("john", 2019, 1);

	}

	@Test
	void testGetChargeability_InOrderVerify() {
		List singleMock = mock(List.class);

		 singleMock.add("was added first");
		 singleMock.add("was added second");

		 InOrder inOrder = inOrder(singleMock);

		 /*
		  * Check so that add("was added first") was called
		  * before add("was added second")
		  */
		 inOrder.verify(singleMock).add("was added first");
		 inOrder.verify(singleMock).add("was added second");

	}	
	
	@Test
	void testGetChargeability_badTestData() {
		TimeRegStoreStub stub = new TimeRegStoreStub();
		TimeRegEngine cut = new TimeRegEngine(stub);
		
		stub.addTimeRegEntries("john", "p1", 2, true, new Date(2020,1,1));
		stub.addTimeRegEntries("john", "p1", 2, false, new Date(2020,1,2));
		/*
		 *  Nedanstående 'entry' är ett felaktigt testdata då månaden är
		 *  satt till 2. Detta medför att assertEquals() rapporterar 'fail'.
		 *  Testet är alltså felaktigt utfört!
		 */
		stub.addTimeRegEntries("john", "p1", 2, true, new Date(2020,2,3));
		
		assertEquals(0.0125, cut.getChargeability("john", 2020, 1));		
	}
}
