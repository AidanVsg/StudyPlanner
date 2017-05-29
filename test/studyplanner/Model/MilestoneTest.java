package studyplanner.Model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ioakim
 */
public class MilestoneTest {
    
    public MilestoneTest() {
    }
    
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

    /**
     * Test of getTasks method, of class Milestone.
     */
    @Test
    public void testGetTasks() {
        System.out.println("getTasks");
        Milestone instance = new Milestone();
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTasks method, of class Milestone.
     */
    @Test
    public void testSetTasks() {
        System.out.println("setTasks");
        ArrayList<Task> tasks = null;
        Milestone instance = new Milestone();
        instance.setTasks(tasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class Milestone.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task task = null;
        Milestone instance = new Milestone();
        boolean expResult = false;
        boolean result = instance.addTask(task);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class Milestone.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        Task task = null;
        Milestone instance = new Milestone();
        boolean expResult = false;
        boolean result = instance.removeTask(task);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Milestone.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Milestone instance = new Milestone();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
