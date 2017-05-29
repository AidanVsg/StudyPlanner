package studyplanner.Model;

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
public class CriterionTest {
    
    public CriterionTest() {
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
     * Test of updateTask method, of class Criterion.
     */
    @Test
    public void testUpdateTask() {
        System.out.println("updateTask");
        Task t = null;
        Criterion instance = null;
        instance.updateTask(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Criterion.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Criterion instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Criterion.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Criterion instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Criterion.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Criterion instance = null;
        CriterionType expResult = null;
        CriterionType result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Criterion.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        CriterionType type = null;
        Criterion instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMet method, of class Criterion.
     */
    @Test
    public void testIsMet() {
        System.out.println("isMet");
        Criterion instance = null;
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMet method, of class Criterion.
     */
    @Test
    public void testSetMet() {
        System.out.println("setMet");
        boolean met = false;
        Criterion instance = null;
        instance.setMet(met);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Criterion.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Criterion instance = null;
        double expResult = 0.0;
        double result = instance.getValue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Criterion.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        double value = 0.0;
        Criterion instance = null;
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnitOfMeasure method, of class Criterion.
     */
    @Test
    public void testGetUnitOfMeasure() {
        System.out.println("getUnitOfMeasure");
        Criterion instance = null;
        String expResult = "";
        String result = instance.getUnitOfMeasure();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnitOfMeasure method, of class Criterion.
     */
    @Test
    public void testSetUnitOfMeasure() {
        System.out.println("setUnitOfMeasure");
        String unitOfMeasure = "";
        Criterion instance = null;
        instance.setUnitOfMeasure(unitOfMeasure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Criterion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Criterion instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
