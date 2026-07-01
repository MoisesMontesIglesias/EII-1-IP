

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PlaneTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlaneTest
{
    /**
     * Default constructor for test class PlaneTest
     */
    public PlaneTest()
    {
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 1: Caso único
     */
    @Test
    public void constructorDefaultUniqCase(){
        Plane pl = new Plane();
        assertEquals(null, pl.getPilot());
        // assertNull(pl.getPilot());
        assertEquals('A', pl.getIdentifier());
        assertEquals(0, pl.getFuel());
    }
    
}
