package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ParkManager;

public class ParkManagerTest {
	ParkManager newPM;
	
	@Before
	public void initialize(){
		newPM = new ParkManager("Michael", "Ford", null, null);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
