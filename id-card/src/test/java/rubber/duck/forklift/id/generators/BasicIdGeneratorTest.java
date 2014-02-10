package rubber.duck.forklift.id.generators;

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
public class BasicIdGeneratorTest {
    
    private BasicIdGenerator generator;
    
    public BasicIdGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        generator = new BasicIdGenerator();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGenerate() {
        Identity id = generator.generate("test");
        Object data = id.getRepresentation();
        assertEquals(0, data);
    }
    
    @Test
    public void testGenerate2() {
        generator = new BasicIdGenerator(42);
        Identity id = generator.generate("test");
        Object data = id.getRepresentation();
        assertEquals(42, data);
    }
    
    @Test
    public void testCreate() {
        generator = new BasicIdGenerator(42);
        Identity id = generator.generate("test");
        Identity id2 = generator.create(42);
        assertTrue(id.match(id2));
        assertEquals(id, id2);
    }
}
