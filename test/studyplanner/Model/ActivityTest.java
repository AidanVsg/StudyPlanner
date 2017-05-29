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
public class ActivityTest {
    
    public ActivityTest() {
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
     * Test of updateCriterion method, of class Activity.
     */
    @Test
    public void testUpdateCriterion() {
        System.out.println("updateCriterion");
        Criterion c = null;
        Activity instance = new Activity();
        instance.updateCriterion(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Activity.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Activity.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Activity instance = new Activity();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Activity.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Activity instance = new Activity();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Activity.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Activity instance = new Activity();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Activity.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Activity instance = new Activity();
        Double expResult = null;
        Double result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Activity.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Double value = null;
        Activity instance = new Activity();
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCriteria method, of class Activity.
     */
    @Test
    public void testGetCriteria() {
        System.out.println("getCriteria");
        Activity instance = new Activity();
        ArrayList<Criterion> expResult = null;
        ArrayList<Criterion> result = instance.getCriteria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Activity.
     */
    @Test
    public void testAdd_Criterion() {
        System.out.println("add");
        Criterion criteria = null;
        Activity instance = new Activity();
        instance.add(criteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Activity.
     */
    @Test
    public void testAdd_ArrayList() {
        System.out.println("add");
        ArrayList<Criterion> criteria = null;
        Activity instance = new Activity();
        instance.add(criteria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
