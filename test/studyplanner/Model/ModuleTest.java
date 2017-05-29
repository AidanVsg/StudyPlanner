package studyplanner.Model;

import java.util.HashSet;
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
public class ModuleTest {
    
    public ModuleTest() {
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
     * Test of getName method, of class Module.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Module instance = new Module();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class Module.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Module instance = new Module();
        String expResult = "";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignments method, of class Module.
     */
    @Test
    public void testGetAssignments() {
        System.out.println("getAssignments");
        Module instance = new Module();
        HashSet<Assignment> expResult = null;
        HashSet<Assignment> result = instance.getAssignments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Module.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Module instance = new Module();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCode method, of class Module.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "";
        Module instance = new Module();
        instance.setCode(code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Module.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Assignment assignment = null;
        Module instance = new Module();
        instance.add(assignment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Module.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Module instance = new Module();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
