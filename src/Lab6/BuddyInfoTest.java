package Lab6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	BuddyInfo buddy;

	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("Andre", "riverside", "613");
		buddy.setAge(18);
	}

	@Test
	public void testGetName() {
		assertEquals(buddy.getName(), "Andre");
	}
	
	@Test
	public void testSetName() {
		buddy.setName("Mian");
		assertEquals("Mian", buddy.getName());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(buddy.getAddress(), "riverside");
	}
	
	@Test
	public void testSetAddress() {
		buddy.setAddress("carleton");
		assertEquals("carleton", buddy.getAddress());
	}
	
	@Test
	public void testGetPhoneNum() {
		assertEquals(buddy.getPhoneNumber(), "613");
	}
	
	@Test
	public void testSetPhoneNum() {
		buddy.setPhoneNumber("123");
		assertEquals("123", buddy.getPhoneNumber());
	}
	
	@Test
	public void testGetAge() {
		assertEquals(buddy.getAge(), 18);
	}
	
	@Test
	public void testSetAge() {
		buddy.setAge(12);
		assertEquals(12, buddy.getAge());
	}
	
	@Test
	public void testIsOver18(){
		assertTrue(buddy.isOver18());
	}
	
	@Test
	public void testToString(){
		assertEquals(buddy.toString(), "Andre riverside 613");
	}
	
	@Test
	public void testEquals(){
		BuddyInfo buddy2 = new BuddyInfo("Andre", "riverside", "613");
		assertTrue(buddy.equals(buddy2));
	}
	
	@Test
	public void testGreet(){
		assertEquals(buddy.greet(), "Hello Andre");
	}
	
	@Test
	public void testCopyConstructor(){
		assertTrue(buddy.equals(new BuddyInfo(buddy)));
	}

}
