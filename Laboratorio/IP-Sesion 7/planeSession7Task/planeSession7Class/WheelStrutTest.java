

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelStrutTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WheelStrutTest
{
    /**
     * Default constructor for test class WheelStrutTest
     */
    public WheelStrutTest()
    {
    }

    /**
     * Pruebas del constructor por defecto
     * Caso único
     */
    @Test
    public void defConstUniq(){
        WheelStrut ws = new WheelStrut();
        
        assertEquals(WheelStrut.IS_DEPLOYED, ws.isDeployed());
        assertNotNull(ws.getLeftWheel());
        assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getLeftWheel().getMaxPressure());
        assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getLeftWheel().getPressure());
        
        assertNotNull(ws.getRightWheel());
        assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getLeftWheel().getMaxPressure());
        assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getLeftWheel().getPressure());
    }
}
