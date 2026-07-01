

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SwitchTest.
 *
 * @author  (Moisés Montes Iglesias)
 * @version (23-10-2022)
 */
public class SwitchTest
{
    /**
     * Default constructor for test class SwitchTest
     */
    public SwitchTest()
    {
    }

    /**
     * Test que comprueba el método press cuando 
     * los valores son verdaderos
     */
    @Test
    public void pressInsideLimitsTrue(){
        Switch S = new Switch();
        S = new Switch();
        assertEquals(true, S.getSwitchPanel());
    }
    
    /**
     * Test que comprueba el método toString cuando 
     * los valores son verdaderos
     */
    @Test
    public void toStringInsideLimits(){
        Switch S = new Switch();
        S = new Switch();
        assertEquals(true, S.getSwitchPanel());
    }
}
