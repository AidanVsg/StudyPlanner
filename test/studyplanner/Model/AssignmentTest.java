/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    Assignment testClass;
    double weighting;
    ArrayList<Task> tasks;
    Milestone milestones;
    
    @BeforeClass
    public static void setUpClass() {
        testClass = new Assignment(weighting, tasks, milestones);
    }
    
    public static addTaskTest(String type,Criterion criteria, 
                        Activity activityHistory, ArrayList <Task> dependentOn){
        return new Task(type, criteria, activityHistory, dependentOn);        
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
