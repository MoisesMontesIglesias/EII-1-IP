

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LampTest.
 *
 * @author  (Moisés Montes Iglesias)
 * @version (23-10-2022)
 */
public class LampTest
{
    /**
     * Default constructor for test class LampTest
     */
    public LampTest()
    {
    }

    /**
     * Test que comprueba el método turnOn cuando 
     * los valores son verdaderos
     */
    @Test
    public void turnOnInsideLimitsTrue(){
        Lamp L = new Lamp();
        L = new Lamp();
        assertEquals(true, L.getLamp());
    }
    
    /**
     * Test que comprueba el método turnOff cuando 
     * los valores son verdaderos
     */
    @Test
    public void turnOffInsideLimitsTrue(){
        Lamp L = new Lamp();
        L = new Lamp();
        assertEquals(true, L.getLamp());
    }
    
    /**
     * Test que comprueba el método toString cuando 
     * los valores son verdaderos
     */
    @Test
    public void toStringInsideLimits(){
        Lamp L = new Lamp();
        L = new Lamp();
        assertEquals(true, L.getLamp());
    }
}
