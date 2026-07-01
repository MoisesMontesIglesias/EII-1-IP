

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
        int n = 10;
        WheelStrut ws = new WheelStrut(n);
        
        assertEquals(WheelStrut.IS_DEPLOYED, ws.isDeployed());
        assertEquals(n, ws.numberOfWheels());
        for (int i = 0; i<n; i++){
            assertNotNull(ws.getWheel(i));
            assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getWheel(i).getMaxPressure());
            assertEquals(WheelStrut.BOEING_737_PRESSURE, ws.getWheel(i).getPressure());
        }
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso único
     */
    @Test
    public void defConstZero(){
        int n = 0;
        try{
            WheelStrut ws = new WheelStrut(n);
            fail("Debería haber fallado");
        }
        catch(RuntimeException e){
             assertEquals("El puntal tiene que tener ruedas", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso único
     */
    @Test
    public void defConstNegativo(){
        int n = -4;
        try{
            WheelStrut ws = new WheelStrut(n);
            fail("Debería haber fallado");
        }
        catch(RuntimeException e){
             assertEquals("El puntal tiene que tener ruedas", e.getMessage());
        }
    }
    
    /**
     * 
     */
    @Test
    public void testLeftFail(){
        int n = 16;
        for (int i = 0; i<n; i++){
            WheelStrut ws = new WheelStrut(n);
            ws.getWheel(i).changePressure(0);
            assertFalse(ws.test());
        }

    }
    
    @Test
    public void toStringOkRetracted(){
        int n = 4;
        WheelStrut ws = new WheelStrut(n);
        ws.retract();
        assertEquals("Deployed: false - Test: true [0: true] [1: true] [2: true] [3: true]", ws.toString());
    }
    
    @Test
    public void toString1RuedaMal(){
        int n = 4;
        WheelStrut ws = new WheelStrut(n);
        ws.getWheel(1).changePressure(0);
        assertEquals("Deployed: true - Test: false [0: true] [1: false] [2: true] [3: true]", ws.toString());
    }
    

    // @Test
    // public void wheelStrutRetracted(){
        // boolean retracted = true;
        // WheelStrut ws = new WheelStrut(retracted);
        // ws.retract();
        // assertEquals(false, ws.isDeployed());
    // }
    
    // @Test
    // public void WheelStrutNotRetract(){
        // boolean retracted = false;
        // WheelStrut ws = new WheelStrut(retracted);
        // ws.retract();
        // assertEquals(false, ws.isDeployed());
    // }
    
    
    
}
