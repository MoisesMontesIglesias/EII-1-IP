

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelTest.
 *
 * @author  (Moisés Montes Iglesias)
 * @version (23-10-2022)
 */
public class WheelTest
{
    /**
     * Pruebas para un constructor sin parámetros
     * Utilizará valores base o estándar
     */
    @Test
    public void constructorWithNoParameters(){
        Wheel w = new Wheel();
        assertEquals(Wheel.STANDARD_PRESSURE, w.getPressure());
        assertEquals(Wheel.STANDARD_MAX_PRESSURE, w.getMaxPressure());
    }
    
    /**
     * Prueba de un constructor con la presión máxima > 0 y 
     * presión dentro de los límites
     */
    @Test
    public void constructorWithParameters(){
       double mP = Wheel.STANDARD_MAX_PRESSURE - 100;
       double p = Wheel.STANDARD_PRESSURE - 100;
       Wheel w = new Wheel(mP,p);
       assertEquals(mP, w.getMaxPressure());
       assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba para cuando la presión sea máxima
     */
    @Test
    public void constructorWithMaxPressure(){
        double p = Wheel.STANDARD_MAX_PRESSURE;
        Wheel w = new Wheel(1000,p);
        assertEquals(p, w.getPressure());
        assertEquals(Wheel.STANDARD_MAX_PRESSURE,w.getMaxPressure());
    }
    
    /**
     * Prueba del constructor para una presión máxima menor que 0
     */
    @Test
    public void constructorWithMaxPressureLowerThan0(){
        double mP = Wheel.STANDARD_MAX_PRESSURE - 2000;
        try {
            Wheel w = new Wheel(1000, mP);
            fail("Esperaba error");
        }
        catch(RuntimeException e){
            assertEquals("La presión no puede dar un valor negativo", e.getMessage());
        }
    }
    
    /**
     * Prueba del constructor para una presión máxima mayor que 1000
     */
    @Test
    public void constructorWithMaxPressureHigherThan1000(){
       double mP = Wheel.STANDARD_MAX_PRESSURE + 2000;
       try {
           Wheel w = new Wheel(1000,mP);
           fail("Esperaba error");
       } 
       catch (RuntimeException e){
           assertEquals("La presión no puede tener un valor mayor del máximo posible", e.getMessage());
       }
    }
}
