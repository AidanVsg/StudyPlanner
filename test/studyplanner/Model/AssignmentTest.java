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
public class AssignmentTest {
    
    public AssignmentTest() {
    }
    
//    Assignment testClass;
//    double weighting;
//    ArrayList<Task> tasks;
//    ArrayList<Milestone> milestones;                              //!!!!!!!!!!!!!!!!!PROBLEM HERE, WHO WORKED ON THIS
                                                                    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//    
//    @BeforeClass
//    public static void setUpClass() {
//        testClass = new Assignment(weighting, tasks, milestones);
//    }
//    
    public static Task addTaskTest(String type,ArrayList<Criterion> criteria, 
              ArrayList<Activity> activityHistory, ArrayList<Task> dependentOn,
              String name, String desc, Date start, Date end){
        return new Task(type, criteria, activityHistory, dependentOn, name, desc,
                        start, end);        
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
