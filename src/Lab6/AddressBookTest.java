package Lab6;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook address;
	private BuddyInfo buddy1, buddy2;

	@Before
	public void setUp() throws Exception {
		address = new AddressBook();
		buddy1 = new BuddyInfo("Andre", "riverside", "613");
		buddy2 = new BuddyInfo("Mian", "riverside2", "724");
	}

	@Test
	public void testSize() {
		assertEquals(address.size(), 0);
	}
	
	@Test
	public void testAddBuddy(){
		address.addBuddy(buddy1);
		address.addBuddy(buddy2);
		assertEquals(2, address.size());
	}
	
	@Test
	public void testRemoveBuddy(){
		address.addBuddy(buddy1);
		address.addBuddy(buddy2);
		address.removeBuddy(0);
		assertEquals(1, address.size());
	}
	
	@Test
	public void testClear(){
		address.addBuddy(buddy1);
		address.addBuddy(buddy2);
		address.clear();
		assertEquals(0, address.size());
	}
	
	@Test
	public void testGetBuddy(){
		List<BuddyInfo> list = new ArrayList<BuddyInfo>();
		list.add(buddy1);
		list.add(buddy2);
		address.addBuddy(buddy1);
		address.addBuddy(buddy2);
		assertEquals(list, address.getBuddy());
	}

}
