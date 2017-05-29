package studyplanner.Model;

import java.io.File;
import java.util.ArrayList;
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
public class StudyProfileTest {
    
    public StudyProfileTest() {
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
     * Test of getName method, of class StudyProfile.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        StudyProfile instance = new StudyProfile();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModules method, of class StudyProfile.
     */
    @Test
    public void testGetModules() {
        System.out.println("getModules");
        StudyProfile instance = new StudyProfile();
        ArrayList<Module> expResult = null;
        ArrayList<Module> result = instance.getModules();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfiles method, of class StudyProfile.
     */
    @Test
    public void testGetProfiles() {
        System.out.println("getProfiles");
        StudyProfile instance = new StudyProfile();
        HashSet<StudyProfile> expResult = null;
        HashSet<StudyProfile> result = instance.getProfiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class StudyProfile.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        StudyProfile instance = new StudyProfile();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class StudyProfile.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        StudyProfile profiles = null;
        StudyProfile instance = new StudyProfile();
        instance.add(profiles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class StudyProfile.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StudyProfile instance = new StudyProfile();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InitialiseStudyProfile method, of class StudyProfile.
     */
    @Test
    public void testInitialiseStudyProfile() {
        System.out.println("InitialiseStudyProfile");
        StudyProfile profile = null;
        File file = null;
        StudyProfile.InitialiseStudyProfile(profile, file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateStudyProfile method, of class StudyProfile.
     */
    @Test
    public void testUpdateStudyProfile() {
        System.out.println("UpdateStudyProfile");
        StudyProfile profile = null;
        File file = null;
        StudyProfile.UpdateStudyProfile(profile, file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StudyProfile.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] argv = null;
        StudyProfile.main(argv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
