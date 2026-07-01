

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
    
    /**
     * Pruebas del constructor por defecto
     * Caso 1: Caso único
     */
    @Test
    public void setIdentifierInsideLimits(){
        Plane pl = new Plane();
        pl.setIdentifier('J');
        assertEquals('J',pl.getIdentifier());
    }
    
    /**
     * Prueba del método setAge. 
     * 1.- Dentro de límites
     */
    @Test
    public void setFuelInsideLimits(){
        Plane pl = new Plane();

        pl.setFuel(2500);
        assertEquals(2500,pl.getFuel());
    }
    
    /**
     * Pruebas del método fly
     * 1.- Si el avión tiene combustible restarle 1 al valor del
     * combustible y devolver true
     */
    @Test
    public void flyWithFuel()
    { 
        Plane p1 = new Plane();
       
        p1.setFuel(2345);
        assertEquals(true, p1.fly());
        assertEquals(2344, p1.getFuel());
        assertEquals(10,p1.getPositionFromX());
        assertEquals(1,p1.getSpeedFromX());
        assertEquals(-1,p1.getPositionFromY());
        assertEquals(-1,p1.getSpeedFromY());
    }
    
    /**
     * Pruebas del método accelerate
     * 1.- La aceleración dentro de los límites permitidos
     */
    @Test
    public void accelerateInsideLimits(){
        Plane p1 = new Plane();
        
        p1.setSpeedFromX(0);
        p1.setSpeedFromY(-1);
        assertEquals(0, p1.getSpeedFromX());
        assertEquals(-1, p1.getSpeedFromY());
    }
    
    /**
     * Pruebas del método toString
     * 1.- Si el avión tiene combustible restarle 1 al valor del
     * combustible y devolver true
     */
    @Test
    public void toString1()
    { 
        Plane p1 = new Plane();
        assertEquals(null, p1.getPilot());
        assertEquals('A', p1.getIdentifier());
        assertEquals(false, p1.fly());
        assertEquals(0, p1.getFuel());
        assertEquals(10,p1.getPositionFromX());
        assertEquals(1,p1.getSpeedFromX());
        assertEquals(0,p1.getPositionFromY());
        assertEquals(-1,p1.getSpeedFromY());
    }
    
    /**
     * 
     */
    @Test
    public void flyRight2(){ // caso 1: se crea un avión con combustible
        Person person1 = new Person();
        Plane plane1 = new Plane(person1,'A',Plane.MIN_FUEL + 10);
        assertEquals(0,plane1.getPositionFromX());
        assertEquals(0,plane1.getPositionFromY());
        plane1.accelerate(-1, 1);
        assertEquals(true, plane1.fly());
        assertEquals(-1,plane1.getPositionFromX());
        assertEquals(1,plane1.getPositionFromY());
        assertEquals(false, plane1.fly());
        assertEquals(0,plane1.getPositionFromX());
        assertEquals(1,plane1.getPositionFromY());
        assertEquals(10,plane1.getFuel());
    }
}
