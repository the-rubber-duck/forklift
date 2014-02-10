package rubber.duck.forklift.id.cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rubber.duck.forklift.id.Identity;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

/**
 *
 * @author Peter C
 */
public class BasicIdentityTest {
    
    private BasicIdentity id1;
    private BasicIdentity id2;
    
    public BasicIdentityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        id1 = new BasicIdentity(1);
        id2 = new BasicIdentity(2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        Identity test = new BasicIdentity(1);
        assertTrue(id1.match(test));
    }
    
    @Test
    public void test2() {
        assertFalse(id1.match(id2));
    }
    
    @Test
    public void test3() {
        Integer rep = id1.getRepresentation();
        assertEquals((Integer) 1, rep);
    }
}