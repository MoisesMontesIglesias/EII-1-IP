

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
     * Prueba del constructor sin parámetros. el cual tendrá un tren de aterriza con palanca predefinida DOWN y con los 3 puntales desplegados
     */
    @Test
    public void ConstructorWithNoParams()
    {
        LandingGear lg = new LandingGear();
        assertEquals(LandingGear.LEVER_DOWN, lg.getLever());
        assertNotNull(lg.getLeft());
        assertEquals(WheelStrut.IS_DEPLOYED, lg.getLeft().isDeployed());
        assertNotNull(lg.getRight());
        assertEquals(WheelStrut.IS_DEPLOYED, lg.getRight().isDeployed());
        assertNotNull(lg.getNose());
        assertEquals(WheelStrut.IS_DEPLOYED, lg.getNose().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever. Estando bajada la palanca, debe quedarse bajada
     */
    @Test
    public void testWithLvAndMoveDown()
    {
        LandingGear lg = new LandingGear();
        
        lg.moveLever(LandingGear.LEVER_DOWN);
        lg.moveLever(LandingGear.LEVER_DOWN);
        
        assertEquals(LandingGear.LEVER_DOWN, lg.getLever());
        assertTrue(lg.getNose().isDeployed());
        assertTrue(lg.getLeft().isDeployed());
        assertTrue(lg.getRight().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever. Estando subida la palanca, debe quedarse subida
     */
    @Test
    public void testWithLvUpAndLvDown()
    {
        LandingGear lg = new LandingGear();
        
        lg.moveLever(LandingGear.LEVER_UP);
        lg.moveLever(LandingGear.LEVER_UP);
        
        assertEquals(LandingGear.LEVER_UP, lg.getLever());
        assertFalse(lg.getNose().isDeployed());      
        assertFalse(lg.getLeft().isDeployed());       
        assertFalse(lg.getRight().isDeployed());       
    }
    
    /**
     * Pruebas del método moveLever. Estando bajada la palanca, debemos subirla
     */
    @Test
    public void testLvDownAndLvUp()
    {
        LandingGear lg = new LandingGear();
        
        lg.moveLever(LandingGear.LEVER_DOWN);
        lg.moveLever(LandingGear.LEVER_UP);
        
        assertEquals(LandingGear.LEVER_UP, lg.getLever());
        assertFalse(lg.getNose().isDeployed());
        assertFalse(lg.getLeft().isDeployed());
        assertFalse(lg.getRight().isDeployed());
    }
    
    /**
     * Pruebas del método moveLever. Sabiendo que la palanca está subida, debemos bajarla
     */
    @Test
    public void testNoOk(){
        WheelStrut nose = new WheelStrut(5); nose.getWheel(0).changePressure(0);
        WheelStrut right = new WheelStrut(5);
        WheelStrut left = new WheelStrut(12);
    }
        
        // lg.moveLever(LandingGear.LEVER_UP);
        // lg.moveLever(LandingGear.LEVER_DOWN);
        
        // assertEquals(LandingGear.LEVER_DOWN, lg.getLever());
        // assertTrue(lg.getNose().isDeployed());
        // assertTrue(lg.getLeft().isDeployed());
        // assertTrue(lg.getRight().isDeployed());
    
    @Test
    public void testOk(){
        LandingGear lg = new LandingGear();
        assertTrue(lg.test());
    }
    
    /** 
     * Prueba del método toString el cual debe ser igual al mostrado
     */
    @Test
    public void getCorrectLandingGearToString()
    {
         LandingGear lg = new LandingGear();
        
         assertEquals("Lever: DOWN    Status: OK      Nose: ON        Left: ON        Right: ON", lg.toString());
    }
}
