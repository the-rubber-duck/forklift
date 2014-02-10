package rubber.duck.forklift.id.collections;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rubber.duck.forklift.id.Identity;
import rubber.duck.forklift.id.generators.BasicIdGenerator;
import rubber.duck.forklift.id.generators.IdentityGenerator;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

/**
 *
 * @author Peter C
 */
public class IdentityMapWrapperTest {
    
    private IdentityMapWrapper<Identity, String> instance;
    private final IdentityGenerator generator = new BasicIdGenerator();
    
    public IdentityMapWrapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Map<Identity, String> map = new HashMap<>();
        map.put(generator.generate("testing"), "testing");
        instance = new IdentityMapWrapper<>(generator, map);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        String test = instance.get(0);
        assertEquals("testing", test);
    }
    
    @Test
    public void test2() {
        try {
            String test = instance.get("asdasdk");
            fail("Fails, should always throw an exception.");
        } catch (Exception ex) {}
    }
}