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
public class AssignmentTest {
    
    public AssignmentTest() {
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
     * Test of addTask method, of class Assignment.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Task task = null;
        Assignment instance = null;
        instance.addTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMilestone method, of class Assignment.
     */
    @Test
    public void testAddMilestone() {
        System.out.println("addMilestone");
        Milestone milestone = null;
        Assignment instance = null;
        instance.addMilestone(milestone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeighting method, of class Assignment.
     */
    @Test
    public void testGetWeighting() {
        System.out.println("getWeighting");
        Assignment instance = null;
        double expResult = 0.0;
        double result = instance.getWeighting();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeighting method, of class Assignment.
     */
    @Test
    public void testSetWeighting() {
        System.out.println("setWeighting");
        double weighting = 0.0;
        Assignment instance = null;
        instance.setWeighting(weighting);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTasks method, of class Assignment.
     */
    @Test
    public void testGetTasks() {
        System.out.println("getTasks");
        Assignment instance = null;
        ArrayList<Task> expResult = null;
        ArrayList<Task> result = instance.getTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTasks method, of class Assignment.
     */
    @Test
    public void testSetTasks() {
        System.out.println("setTasks");
        ArrayList<Task> tasks = null;
        Assignment instance = null;
        instance.setTasks(tasks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMilestones method, of class Assignment.
     */
    @Test
    public void testGetMilestones() {
        System.out.println("getMilestones");
        Assignment instance = null;
        ArrayList<Milestone> expResult = null;
        ArrayList<Milestone> result = instance.getMilestones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMilestones method, of class Assignment.
     */
    @Test
    public void testSetMilestones() {
        System.out.println("setMilestones");
        ArrayList<Milestone> milestones = null;
        Assignment instance = null;
        instance.setMilestones(milestones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Assignment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Assignment instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
