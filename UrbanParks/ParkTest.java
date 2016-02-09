import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing Park Class
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 8, 2016
 */
public class ParkTest {
	
	private Park myPark;
	
	@Before
	public void setUp() {
			
		myPark = new Park("South Park", "Tacoma", "Weiwei", "Shi");
	}
	
	@Test
	public void testConstructor() {
		assertEquals("South Park", myPark.getParkName());
		assertEquals("Tacoma", myPark.getLocation());
		assertEquals("Weiwei", myPark.getParkManagerFirstName());
		assertEquals("Shi", myPark.getParkManagerLastName());
	}
}
