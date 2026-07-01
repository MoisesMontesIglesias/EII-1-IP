

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ControlPanelTest.
 *
 * @author  (Moisés Montes Iglesias)
 * @version (23-10-2022)
 */
public class ControlPanelTest
{
    /**
     * Default constructor for test class ControlPanelTest
     */
    public ControlPanelTest()
    {
    }

    /**
     * Constructor para comprobar el método press para el caso true
     */
    @Test
    public void pressInsideLimitsTrue(){
        ControlPanel CP = new ControlPanel();
        CP = new ControlPanel();
        assertEquals(true, CP.s.getSwitchPanel());
    }
}
