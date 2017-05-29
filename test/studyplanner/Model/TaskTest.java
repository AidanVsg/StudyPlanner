/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TaskTest {
    
    public TaskTest() {
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
     * Test of getType method, of class Task.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Task instance = new Task();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Task.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Task instance = new Task();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCriteria method, of class Task.
     */
    @Test
    public void testGetCriteria() {
        System.out.println("getCriteria");
        Task instance = new Task();
        ArrayList<Criterion> expResult = null;
        ArrayList<Criterion> result = instance.getCriteria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCriteria method, of class Task.
     */
    @Test
    public void testSetCriteria() {
        System.out.println("setCriteria");
        ArrayList<Criterion> criteria = null;
        Task instance = new Task();
        instance.setCriteria(criteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivityHistory method, of class Task.
     */
    @Test
    public void testGetActivityHistory() {
        System.out.println("getActivityHistory");
        Task instance = new Task();
        ArrayList<Activity> expResult = null;
        ArrayList<Activity> result = instance.getActivityHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivityHistory method, of class Task.
     */
    @Test
    public void testSetActivityHistory() {
        System.out.println("setActivityHistory");
        ArrayList<Activity> activityHistory = null;
        Task instance = new Task();
        instance.setActivityHistory(activityHistory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependencies method, of class Task.
     */
    @Test
    public void testGetDependencies() {
        System.out.println("getDependencies");
        Task instance = new Task();
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getDependencies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDependencies method, of class Task.
     */
    @Test
    public void testSetDependencies() {
        System.out.println("setDependencies");
        ArrayList<Task> dependencies = null;
        Task instance = new Task();
        instance.setDependencies(dependencies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Task.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Task instance = new Task();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
