

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
        assertEquals(pl.DEFAULT_PILOT, pl.getPilot());
        // assertNull(pl.getPilot());
        assertEquals(pl.DEFAULT_IDENTIFIER, pl.getIdentifier());
        assertEquals(pl.DEFAULT_FUEL, pl.getFuel());
        assertEquals(pl.MIN_X, pl.getPositionFromX());
        assertEquals(pl.MIN_Y, pl.getPositionFromY());
        assertEquals(0, pl.getSpeedFromX());
        assertEquals(0, pl.getSpeedFromY());
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 1: Caso único
     */
    @Test
    public void constructorDefaultXSpeedYSpeedCase(){
        Plane pl = new Plane();
        assertEquals(0, pl.getSpeedFromX());
        assertEquals(0, pl.getSpeedFromY());
    }
    
    /**
     * Prueba del método con todos los parámetros por defecto menos el piloto
     */
    @Test
    public void constructorPilot(){
        Person pilot = new Person();
        Plane pl = new Plane(pilot);
        assertEquals(pilot, pl.getPilot());
    }
    
    /**
     * Prueba del método con todos los parámetros por defecto 
     * teniendo el piloto el valor null
     */
    @Test
    public void constructorPilotNull(){
        Person pilot = null;
        Plane pl = new Plane(null);
        assertEquals(null, pl.getPilot());
    }
    
    /**
     * Pruebas del constructor por defecto
     * Caso 1: Caso único
     */
    @Test
    public void setIdentifierInsideLimits(){
        char identifier = 'J';
        Plane pl = new Plane(identifier);
        assertEquals('J',pl.getIdentifier());
    }
    
    /**
     * Prueba del método setAge. 
     * 1.- Dentro de límites
     */
    @Test
    public void setFuelInsideLimits(){
        int fuel = 2500;
        Plane pl = new Plane(fuel);
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
        int fuel = 2345;
        Plane p1 = new Plane(fuel);
        
        assertEquals(true, p1.fly());
        assertEquals(2344, p1.getFuel());
        assertEquals(0,p1.getPositionFromX());
        assertEquals(0,p1.getSpeedFromX());
        assertEquals(0,p1.getPositionFromY());
        assertEquals(0,p1.getSpeedFromY());
    }
    
    /**
     * Pruebas del método fly
     * 2.- Si el avión no tiene combustible devolver false 
     * y no realizar ningún cambio
     */
    @Test
    public void flyWithoutFuel()
    { 
        int fuel = 0;
        Plane p1 = new Plane(0);
        assertEquals(false, p1.fly());
        assertEquals(0, p1.getFuel());
        assertEquals(0,p1.getPositionFromX());
        assertEquals(0,p1.getSpeedFromX());
        assertEquals(0,p1.getPositionFromY());
        assertEquals(0,p1.getSpeedFromY());
    }    
    
    /**
     * Pruebas del método fly
     * 2. Si el avión excede el valor del combustible devolver false
     */
    @Test
    public void flyWithOverFuel()
    {
        int fuel = 100000;
        try{
            Plane p1 = new Plane(fuel);
            assertEquals(100000, p1.getFuel());
            fail("Debería haber fallado");
        }catch(RuntimeException e){
            assertEquals("Combustible fuera de rango", e.getMessage());
        }
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
        assertEquals(0, p1.getFuel());
        assertEquals(0,p1.getPositionFromX());
        assertEquals(0,p1.getSpeedFromX());
        assertEquals(0,p1.getPositionFromY());
        assertEquals(0,p1.getSpeedFromY());
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
        plane1.accelerate(0, 0);
        assertEquals(true, plane1.fly());
        assertEquals(0,plane1.getPositionFromX());
        assertEquals(0,plane1.getPositionFromY());
        assertEquals(true, plane1.fly());
        assertEquals(0,plane1.getPositionFromX());
        assertEquals(0,plane1.getPositionFromY());
        assertEquals(8,plane1.getFuel());
    }
    
    /**
     * Pruebas del método accelerate
     * 1.- La aceleración dentro de los límites permitidos
     */
    @Test
    public void accelerateInsideLimits(){
        int xSpeed = Plane.MIN_XSPEED;
        int ySpeed = Plane.MAX_YSPEED;
        Plane p1 = new Plane (xSpeed, ySpeed);
        assertEquals(xSpeed, p1.getSpeedFromX());
        assertEquals(ySpeed, p1.getSpeedFromY());
    }
    
    /**
     * Pruebas del método accelerate
     * 1.- La velocidad de X es correcta pero la de Y se halla fuera de los límites
     */
    @Test
    public void accelerateXInButYNot(){
        int ySpeed = Plane.MAX_YSPEED + 17;
        try{
            Plane p1 = new Plane (Plane.MIN_XSPEED,ySpeed);
            assertEquals(ySpeed, p1.getSpeedFromY());
            fail("Debería haber fallado");
        } catch(RuntimeException e){
            assertEquals("Velocidad del eje Y fuera del rango", e.getMessage());
        }
    }  
}
