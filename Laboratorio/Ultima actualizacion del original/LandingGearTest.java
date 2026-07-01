

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LandingGearTest.
 *
 * @author  (Moisés Montes Iglesias)
 * @version (a version number or a date)
 */
public class LandingGearTest
{
    /**
     * Prueba del constructor sin parámetros
     * Se crea un tren de aterrizaje con palanca DOWN, y con 3 puntales desplegados
     */
    @Test
    public void constructorWithNoParams()
    {
        LandingGear lg1 = new LandingGear();
        
        assertEquals(LandingGear.LEVER_DOWN, lg1.getLever());
        
        assertNotNull(lg1.getLeft());
        assertEquals(WheelStrut.IS_DEPLOYED, lg1.getLeft().isDeployed());
        
        assertNotNull(lg1.getRight());
        assertEquals(WheelStrut.IS_DEPLOYED, lg1.getRight().isDeployed());
        
        assertNotNull(lg1.getNose());
        assertEquals(WheelStrut.IS_DEPLOYED, lg1.getNose().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever
     * 
     * 1- Estando la palanca bajada (LEVER_DOWN), dejarla bajada (LEVER_DOWN) -> queda igual
     */
    @Test
    public void testLeverAndMoveDown()
    {
        LandingGear lg1 = new LandingGear();
        
        lg1.moveLever(LandingGear.LEVER_DOWN);
        lg1.moveLever(LandingGear.LEVER_DOWN);
        
        assertEquals(LandingGear.LEVER_DOWN, lg1.getLever());
        assertTrue(lg1.getNose().isDeployed());
        assertTrue(lg1.getLeft().isDeployed());
        assertTrue(lg1.getRight().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever
     * 
     * 2- Estando la palanca subida (LEVER_UP), dejarla subida (LEVER_UP) -> queda igual
     */
    @Test
    public void testLvUpAndLvDown()
    {
        LandingGear lg1 = new LandingGear();
        
        lg1.moveLever(LandingGear.LEVER_UP);
        lg1.moveLever(LandingGear.LEVER_UP);
        
        assertEquals(LandingGear.LEVER_UP, lg1.getLever());
        assertFalse(lg1.getNose().isDeployed());      
        assertFalse(lg1.getLeft().isDeployed());       
        assertFalse(lg1.getRight().isDeployed());       
    }
    
    /**
     * Pruebas del método moveLever
     * 
     * 3- Estando la palanca bajada (LEVER_DOWN), subirla (LEVER_UP) -> subir la palanca
     */
    @Test
    public void testLvDownAndLvUp()
    {
        LandingGear lg1 = new LandingGear();
        
        lg1.moveLever(LandingGear.LEVER_DOWN);
        lg1.moveLever(LandingGear.LEVER_UP);
        
        assertEquals(LandingGear.LEVER_UP, lg1.getLever());
        assertFalse(lg1.getNose().isDeployed());
        assertFalse(lg1.getLeft().isDeployed());
        assertFalse(lg1.getRight().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever
     * 
     * 4- Estando la palanca subida (LEVER_UP), bajarla (LEVER_DOWN) -> bajar la palanca
     */
    @Test
    public void testLeverUpMoveLeverDown()
    {
        LandingGear lg1 = new LandingGear();
        
        lg1.moveLever(LandingGear.LEVER_UP);
        lg1.moveLever(LandingGear.LEVER_DOWN);
        
        assertEquals(LandingGear.LEVER_DOWN, lg1.getLever());
        assertTrue(lg1.getNose().isDeployed());
        assertTrue(lg1.getLeft().isDeployed());
        assertTrue(lg1.getRight().isDeployed());
    }
    
    
    /** 
     * Prueba del método toString
     * 
     * 1- El toString tiene que ser igual que el indicado. 
     */
    @Test
    public void getCorrectLandingGearToString()
    {
         LandingGear lg1 = new LandingGear();
        
         assertEquals("Lever: DOWN    Status: OK      Nose: ON        Left: ON        Right: ON", lg1.toString());
    }
}
