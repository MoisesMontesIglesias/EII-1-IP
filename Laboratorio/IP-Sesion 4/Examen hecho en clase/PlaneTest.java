

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
        try{
            Plane pl = new Plane();
            assertEquals(null, pl.getPilot());
            // assertNull(pl.getPilot());
            assertEquals('A', pl.getIdentifier());
            assertEquals(0, pl.getFuel()); 
        }
        catch (RuntimeException e){
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 1: Caso único
     */
    @Test
    public void setIdentifierInsideLimits(){
        try{
           Plane pl = new Plane();
            pl.setIdentifier('J');
            assertEquals('J',pl.getIdentifier()); 
        }
        catch (RuntimeException e){
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setFuel. 
     * 1.- Dentro de límites
     */
    @Test
    public void setFuelInsideLimits(){
        try{
            Plane pl = new Plane();
            pl.setFuel(2500);
            assertEquals(2500,pl.getFuel());
        }
        catch (RuntimeException e) {
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de ser un hombre de 40 años
     */
    @Test
    public void setPilotMale(){
        try{
            Plane pl = new Plane();
            pl = new Plane(40);
            assertEquals(40,pl.getPilot());
        }
        catch(RuntimeException e) {
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de no cumplir la edad por tener menos de la esperada
     */
    @Test
    public void setPilotMaleBelowLimits(){
        try{
            Plane pl = new Plane();
            pl = new Plane(8);
            assertEquals(8,pl.getPilot());
        }
        catch(RuntimeException e) {
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de no cumplir la edad por tener más de la requerida
     */
    @Test
    public void setPilotMaleAboveLimits(){
        try{
            Plane pl = new Plane();
            pl = new Plane(67);
            assertEquals(67,pl.getPilot());
        }
        catch(RuntimeException e) {
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de ser una mujer de 20 años
     */
    @Test
    public void setPilotFemale(){
        try{
            Plane pl = new Plane();
            pl = new Plane(20);
            assertEquals(20,pl.getPilot());
        }
        catch (RuntimeException e){
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de no cumplir la edad por tener más de la requerida
     */
    @Test
    public void setPilotFemaleBelowLimits(){
        try{
            Plane pl = new Plane();
            pl = new Plane(11);
            assertEquals(11,pl.getPilot());
        }
        catch (RuntimeException e){
            assertEquals(null, e.getMessage());
        }
    }
    
    /**
     * Prueba del método setPilot para el caso de no cumplir la edad por tener más de la requerida
     */
    @Test
    public void setPilotFemaleAboveLimits(){
        try{
            Plane pl = new Plane();
            pl = new Plane(79);
            assertEquals(79,pl.getPilot());
        }
        catch (RuntimeException e){
            assertEquals(null, e.getMessage());
        }
    }
}
