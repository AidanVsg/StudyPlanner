package studyplanner.Model;

import java.util.Date;
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
public class ObjectiveTest {
    
    public ObjectiveTest() {
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
     * Test of getName method, of class Objective.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Objective instance = new Objective();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Objective.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Objective instance = new Objective();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Objective.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Objective instance = new Objective();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Objective.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Objective instance = new Objective();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStart method, of class Objective.
     */
    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Objective instance = new Objective();
        Date expResult = null;
        Date result = instance.getStart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStart method, of class Objective.
     */
    @Test
    public void testSetStart() {
        System.out.println("setStart");
        Date start = null;
        Objective instance = new Objective();
        instance.setStart(start);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnd method, of class Objective.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Objective instance = new Objective();
        Date expResult = null;
        Date result = instance.getEnd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnd method, of class Objective.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        Date end = null;
        Objective instance = new Objective();
        instance.setEnd(end);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDone method, of class Objective.
     */
    @Test
    public void testIsDone() {
        System.out.println("isDone");
        Objective instance = new Objective();
        boolean expResult = false;
        boolean result = instance.isDone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsDone method, of class Objective.
     */
    @Test
    public void testSetIsDone() {
        System.out.println("setIsDone");
        boolean isDone = false;
        Objective instance = new Objective();
        instance.setIsDone(isDone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Objective.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Objective instance = new Objective();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
