

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
            assertEquals("Valor incorrecto de la presión", e.getMessage());
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
           assertEquals("Valor incorrecto de la presión", e.getMessage());
       }
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 1: Todo bien (presión máxima > 0; presión > 0 y menor justo justo que presión máxima)
     *      Caso 1bis: Todo bien (presión máxima > 0; presión > 0 y bastante menor que presión máxima)
     * Caso 2: Todo bien (presión máxima > 0; presión = 0)
     * Caso 3: Todo bien (presión máxima > 0; presión igual que presión máxima)
     * Caso 4: Todo bien (presión máxima = 0; presión = 0)
     * Casos negativos:
     * Caso 5: Presión máxima correcta: presión > presión máxima
     * Caso 6: Presión máxima correcta: presión < 0
     * Caso 7: Presión máxima < 0; presión indiferente
     */
    
    /**
     * Prueba del constructor con parámetros
     * Caso 1: Todo bien (presión máxima > 0; presión > 0 y menor justo justo que presión máxima)
     */
    @Test
    public void paramConsPMgt0Pgt0(){
        double pm = 1000, p = pm-0.01;
        Wheel w = new Wheel(pm, p);
        assertEquals(pm, w.getMaxPressure());
        assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 1bis: Todo bien (presión máxima > 0; presión > 0 y bastante menor que presión máxima)
     */
    @Test 
    public void paramConsPMgt0Pgt0bis(){
        double pm = 1000, p = pm-100;
        Wheel w = new Wheel(pm, p);
        assertEquals(pm, w.getMaxPressure());
        assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 2: Todo bien (presión máxima > 0; presión = 0)
     */
    @Test 
    public void paramConsPMgt0Peq0(){
        double pm = 1000, p = 0;
        Wheel w = new Wheel(pm, p);
        assertEquals(pm, w.getMaxPressure());
        assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 3: Todo bien (presión máxima > 0; presión igual que presión máxima)
     */
    @Test 
    public void paramConsPMgt0PeqPM(){
        double pm = 1000, p = pm;
        Wheel w = new Wheel(pm, p);
        assertEquals(pm, w.getMaxPressure());
        assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 4: Todo bien (presión máxima = 0; presión = 0)
     */
    @Test 
    public void paramConsPMeq0Peq0(){
        double pm = 0, p = 0;
        Wheel w = new Wheel(pm, p);
        assertEquals(pm, w.getMaxPressure());
        assertEquals(p, w.getPressure());
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 5: Presión máxima correcta: presión > presión máxima
     */
    @Test 
    public void paramConsPMltPM0(){
        double pm = 1000, p = pm+100;
        try{
            Wheel w = new Wheel(pm, p);
            fail("Debería haber fallado, pues la presión es incorrecta");
        }
        catch(RuntimeException e){
            assertEquals("Valor incorrecto de la presión", e.getMessage());
        }
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 6: Presión máxima correcta: presión < 0
     */
    @Test 
    public void paramConsPlt0(){
        double pm = 1000, p = -100;
        try{
            Wheel w = new Wheel(pm, p);
            fail("Debería haber fallado, pues la presión es incorrecta");
        }
        catch(RuntimeException e){
            assertEquals("Valor incorrecto de la presión", e.getMessage());
        }
    }
    
    /**
     * Prueba del constructor con parámetros
     * Caso 7: Presión máxima < 0; presión indiferente
     */
    @Test 
    public void paramConsPMlt0(){
        double pm = -1000, p = pm+100;
        try{
            Wheel w = new Wheel(pm, p);
            fail("Debería haber fallado, pues la presión es incorrecta");
        }
        catch(RuntimeException e){
            assertEquals("Valor incorrecto de la presión máxima", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método test
     * Caso 1. Rueda operativa(P>PM*umbral/100)
     * Caso 2. Rueda operativa(P=PM*umbral/100)
     * Caso 3. Rueda no operativa(P un poco menor PM*umbral/100)
     * Caso 4. Rueda no operativa(P bastante menor PM*umbral/100)
     */
    
    /**
     * Pruebas del método test
     * Caso 1. Rueda operativa(P>PM*umbral/100)
     */
    @Test
    public void testOKPgtThres(){
        double pm = 1000, p = pm*(double) Wheel.THRESHOLD/100 + 0.1;
        Wheel w = new Wheel(pm, p);
        assertTrue(w.test());
    }
    
    /**
     * Pruebas del método test
     * Caso 2. Rueda operativa(P=PM*umbral/100)
     */
    @Test
    public void testOKPeqThres(){
        double pm = 1000, p = pm;
        Wheel w = new Wheel(pm, p);
        assertTrue(w.test());
    }
    
    /**
     * Pruebas del método test
     * Caso 3. Rueda operativa(P un poco menor PM*umbral/100)
     */
    @Test
    public void testOKPbltThres(){
        double pm = 1000, p = pm + 0.01;
        try{
            Wheel w = new Wheel(pm, p);
            fail("Debería haber fallado, pues la presión es incorrecta");
        }
        catch(RuntimeException e){
            assertEquals("Valor incorrecto de la presión", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método test
     * Caso 4. Rueda operativa(P bastante menor PM*umbral/100)
     */
    @Test
    public void testOKPltThres(){
        double pm = 1000, p = pm + 100;
        try{
            Wheel w = new Wheel(pm, p);
            fail("Debería haber fallado, pues la presión es incorrecta");
        }
        catch(RuntimeException e){
            assertEquals("Valor incorrecto de la presión", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método toString
     * Caso 1: Test positivo
     * Caso 2: Test negativo
     */
    
    /**
     * Pruebas del método toString
     * Caso 1: Test positivo
     */
    @Test 
    public void toStringTrue(){
        double pm = 1000, p = 900;
        Wheel w = new Wheel(pm, p);
        assertEquals("MaxP: 1000.0 Mb - Pressure: 900.0 Mb - Percentage: 90.0 - Test: true", w.toString());        
    }
    
    /**
     * Pruebas del método toString
     * Caso 2: Test neagtivo
     */
    @Test 
    public void toStringFalse(){
        double pm = 1000, p = 100;
        Wheel w = new Wheel(pm, p);
        assertEquals("MaxP: 1000.0 Mb - Pressure: 100.0 Mb - Percentage: 10.0 - Test: false", w.toString());        
    }
}
