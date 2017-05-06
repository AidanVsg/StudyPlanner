package studyplanner.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author aidan
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    Task testClass;
    String type;
    ArrayList<Criterion> criteria;
    ArrayList<Activity> activityHistory;
    ArrayList <Task> dependentOn;
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        testClass = new Task(type,criteria,activityHistory,dependentOn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
