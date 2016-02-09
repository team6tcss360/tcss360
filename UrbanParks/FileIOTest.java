import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the class that reads and saves data to files for the Urban Parks 
 * application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 7, 2016
 */
public class FileIOTest {

    /** 
     * Contains a copy of the actual Urban Parks data file.
     */
    private static final String FILE_ORIGINAL_COPY = "UrbanParks/UrbanParksDataCopy.txt";
    
    /** 
     * Contains a copy of the actual Urban Parks data file.
     */
    private static final String FILE_WORKING_COPY = "UrbanParks/UrbanParksDataTest.txt";
    
    /** 
     * Contains an empty Urban Parks data file.
     */
    private static final String FILE_EMPTY = "UrbanParks/UrbanParksDataTestEmpty.txt";
    
    /**
     * A file name with a typo (so that it is not found).
     */
    private static final String FILE_TYPO = "UrbanParks/UrbanParksDDKJHKDJ.txt";
    
    /**
     * A FileIO object with expected contents.
     */
    private FileIO workingFileIO;
    
    /**
     * A FileIO object with no contents.
     */
    private FileIO emptyFileIO;
    
    /**
     * Contains the users that Urban Parks application will use.
     */
    private UserList users;

    /**
     * Contains the jobs that Urban Parks application will use.
     */
    private JobList jobs;
    
    /**
     * Contains the parks that Urban Parks application will use.
     */
    private ParkList parks;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        users = new UserList();
        jobs = new JobList();  
        parks = new ParkList(); 
        users.add(new Volunteer("Mary","Williams","mwilliams@gmail.com","1234567899"));
        users.add(new Volunteer("Victor","Volunteereli","v@v.com","1234567854"));
        users.add(new StaffMember("John","Smith","johnsmith@gmail.com","1234567890"));
        users.add(new StaffMember("Steve","Staffy","s@s.com","1234567380"));
        users.add(new ParkManager("George","Wilson","geogew@gmail.com","9876543210"));
        users.add(new ParkManager("Peter","Parker","p@p.com","9876547590"));
        parks.add(new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "George", "Wilson"));
        jobs.add(new Job(1, "20160301", "20160301", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0, null));   
//        emptyFileIO = new FileIO(FILE_EMPTY);
        workingFileIO = new FileIO(FILE_WORKING_COPY);
    }

//    /**
//     * Test method for {@link FileIO#FileIO(java.lang.String)}.
//     * Test FileIO constructor with a file that does not exist (has a typo).
//     * This should cause a FileNotFoundException.
//     */
//    @Test (expected = FileNotFoundException.class)
//    public void testFileIOFileNotFound() {
//        FileIO typo = new FileIO(FILE_TYPO);
//    }
    
    /**
     * Test method for {@link FileIO#save(UserList, JobList, ParkList)} and
     * {@link FileIO#load()}.
     */
    @Test
    public void testSaveLoad() {
        workingFileIO.save(users, jobs, parks);
        workingFileIO = new FileIO(FILE_WORKING_COPY);
        UserList loadedUsers = workingFileIO.getUsers(); 
        JobList loadedJobs = workingFileIO.getJobs();   
        ParkList loadedParks = workingFileIO.getParks();
        assertEquals(loadedUsers, users);
        assertEquals(loadedJobs, jobs);
        assertEquals(loadedParks, parks);
    }

    /**
     * Test method for {@link FileIO#getUsers()}.
     */
    @Test
    public void testGetUsers() {
        workingFileIO.save(users, jobs, parks);
        workingFileIO = new FileIO(FILE_WORKING_COPY);
        UserList loadedUsers = workingFileIO.getUsers();
        assertEquals(loadedUsers, users);
    }

    /**
     * Test method for {@link FileIO#getJobs()}.
     */
    @Test
    public void testGetJobs() {
        workingFileIO.save(users, jobs, parks);
        workingFileIO = new FileIO(FILE_WORKING_COPY);
        JobList loadedJobs = workingFileIO.getJobs();   
        assertEquals(loadedJobs, jobs);
    }

    /**
     * Test method for {@link FileIO#getParks()}.
     */
    @Test
    public void testGetParks() {
        workingFileIO.save(users, jobs, parks);
        workingFileIO = new FileIO(FILE_WORKING_COPY); 
        ParkList loadedParks = workingFileIO.getParks();
        assertEquals(loadedParks, parks);
    }
}
