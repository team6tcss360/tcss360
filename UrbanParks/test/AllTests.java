package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FileIOTest.class, JobListTest.class, JobTest.class, ParkListTest.class,
        ParkTest.class, UserListTest.class, UserTest.class })
public class AllTests {

}
