package studyplanner.Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aidan on 03/05/2017.
 */
class ActivityTest {
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void updateCriteria() {
        Criterion c = new Criterion();
        Activity a = new Activity();

        a.updateCriteria(c);

        assertTrue(c.isMet());
    }

    @Test
    void add() {
        Activity a = new Activity();
        Criterion c = new Criterion();

        a.add(c);
        assertTrue(a.getCriteria().contains(c));
    }

    @Test
    void add1() {
        Activity a = new Activity();
        ArrayList<Criterion> cl = new ArrayList();
        Criterion c1 = new Criterion();cl.add(c1);
        Criterion c2 = new Criterion();cl.add(c2);
        Criterion c3= new Criterion();cl.add(c3);
        Criterion c4 = new Criterion();cl.add(c4);
        Criterion c5 = new Criterion();cl.add(c5);

        a.add(cl);

        int criteriaQuantity = 0;
        for (Criterion c:
             cl) {
            if(a.getCriteria().contains(c)) criteriaQuantity++;
        }

        assertEquals(criteriaQuantity, cl.size());


    }

}