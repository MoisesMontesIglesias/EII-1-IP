
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
    /**
 * Clase de prueba para el Puente Levadizo
 *
 * @author IP-Profes
 * @version 2021
 */

public class BasculeBridgeTest
{
       
   /**
    *  Pruebas del constructor sin parámetros
    *  Caso único: se crea un puente con la inclinación por defecto.
    */ 
   
   @Test
   public void basculeBridgeWithoutParams() {
       BasculeBridge basculeBridge = new BasculeBridge();
       assertEquals(BasculeBridge.DEFAULT_SLOPE, basculeBridge.getSlope());
   }
    
   /*
    * Pruebas del constructor con parámetro 
    * Casos positivos
    *  1: Puente con inclinación dentro del rango
    *  2: Puente con inclinación en el límite inferior
    *  3: Puente con inclinación en el límite superior
    *  Casos negativos
    *  4: Puente con inclinación en el límite por debajo del límite inferior
    *  5: Puente con inclinación en el límite por debajo del límite inferior
    */
   /**
    *  Pruebas del constructor con parámetro 
    *  Caso positivo 1: Puente con inclinación dentro del rango
    */ 
   
    @Test
    public void constructorSlopeInsideLimits() {
        int slope = (BasculeBridge.MAX_SLOPE + BasculeBridge.MIN_SLOPE) / 2;
        
        BasculeBridge basculeBridge = new BasculeBridge(slope);
        assertEquals(slope, basculeBridge.getSlope());
    }
    
    /**
    *  Pruebas del constructor con parámetro 
    *  Caso positivo 2: Puente con inclinación en el límite inferior
    */ 
    @Test
    public void constructorSlopeInLowerLimit() {
        int slope = BasculeBridge.MIN_SLOPE;
        
        BasculeBridge basculeBridge = new BasculeBridge(slope);
        assertEquals(slope, basculeBridge.getSlope());
    }
    
    /**
    *  Pruebas del constructor con parámetro 
    *  Caso positivo 3: Puente con inclinación en el límite superior
    */ 
    @Test
    public void constructorSlopeInUpperLimit() {
        int slope = BasculeBridge.MAX_SLOPE;
        
        BasculeBridge basculeBridge = new BasculeBridge(slope);
        assertEquals(slope, basculeBridge.getSlope());
    }
    
    //          PRUEBAS NEGATIVAS
    /**
    *  Pruebas del constructor con parámetro 
    *  Caso negativo 1: Puente con inclinación en el límite por debajo del límite inferior
    */ 
    @Test
    public void constructorSlopeBelowLowerLimit() {  
        int slope = BasculeBridge.MIN_SLOPE - 1;
        String msg = "Inclinación no válida";
        try {
             BasculeBridge basculeBridge = new BasculeBridge(slope);
             fail();
        }
        catch (Exception e){
            assertEquals(msg, e.getMessage());   
        }
    }
    
    //          PRUEBAS NEGATIVAS
    /**
    *  Pruebas del constructor con parámetro 
    *  Caso negativo 2: Puente con inclinación en el límite por debajo del límite inferior
    */ 
    @Test
    public void constructorSlopeAboveUpperLimit() {  
        int slope = BasculeBridge.MAX_SLOPE + 1;
        String msg ="Inclinación no válida";
        try {
             BasculeBridge basculeBridge = new BasculeBridge(slope);
             fail();
        }
        catch (Exception e){
            assertEquals(msg, e.getMessage());   
        }
    }
    
    /*
     * PRUEBAS DE RaiseBridge.
     * Caso 1: Subimos dentro del rango
     * Caso 2: Subimos  hasta límite
     * Caso 3: Subimos algo intermedio
     * Caso 4: Subimos más de la cuenta
     * Caso 5: subimos un número negativo
     */
    /**
     * PRUEBAS DE RaiseBridge.
     * Caso 1: Subimos dentro del rango
     */
    @Test
    public void raiseBridgeInsideLimit() {
        int inc = 10; 
        int slope = 10;
        
        BasculeBridge b = new BasculeBridge();
        b.raiseBridge(inc);
        assertEquals(slope, b.getSlope());        
    }
    
    /**
     * PRUEBAS DE RaiseBridge.
     * Caso 2: Subimos  hasta límite
     */
    @Test
    public void raiseBridgeUntilLimit() {
        int inc = BasculeBridge.MAX_SLOPE; 
        int slope=BasculeBridge.MAX_SLOPE;
        
        BasculeBridge b = new BasculeBridge();
        b.raiseBridge(inc);
        assertEquals(slope, b.getSlope());
        
    }
    
     /**
     * PRUEBAS DE RaiseBridge.
     * Caso 3: Subimos algo intermedio
     */
    
    @Test
    public void raiseBridgeLessThanLimit() {
        int inc = BasculeBridge.MAX_SLOPE - 10; 
        int slope = BasculeBridge.MAX_SLOPE;
        
        BasculeBridge b = new BasculeBridge(10);
        b.raiseBridge(inc);
        assertEquals(slope, b.getSlope());
        
    }
    
    /**
     * PRUEBAS DE RaiseBridge.
     * Caso 4: Subimos más de la cuenta
     */
    
    @Test
    public void raiseBridgeMoreThanLimit() {
        int inc = BasculeBridge.MAX_SLOPE+10; 
        
        BasculeBridge b = new BasculeBridge();
        try {
            b.raiseBridge(inc);
            fail();
        }
        catch (Exception e) {
            assertEquals("Inclinación no válida", e.getMessage());
        }
        
    }
     
    /**
     * PRUEBAS DE raiseBridge.
     * Caso 5: subimos un número negativo
     */
    
    @Test
    public void  raiseBridgeNegative() {
        int inc = -1;
        int slope = BasculeBridge.MAX_SLOPE-10;
        try{
            BasculeBridge b = new BasculeBridge(slope);
            b.raiseBridge(inc);
             fail("Esperaba excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("Incremento debe ser positivo", e.getMessage());
        }
        
    }
          
          
    
    
   /**
     * PRUEBAS DE dropBridge.
     * Caso 1: Bajamos dentro del rango
     */
    @Test
    public void dropBridgeInsideLimits() {
        int inc = 10; 
        int slope = 50;
        
        BasculeBridge b = new BasculeBridge(BasculeBridge.MAX_SLOPE);
        b.dropBridge(inc);
        assertEquals(slope, b.getSlope());
        
    }
    
    /**
     * PRUEBAS DE dropBridge.
     * Caso 2: bajamos dentro hasta el rango
     */
    @Test
    public void dropBridgeUntilLimit() {
        int inc = BasculeBridge.MAX_SLOPE; 
        int slope = 0;
        
        BasculeBridge b = new BasculeBridge(BasculeBridge.MAX_SLOPE);
        b.dropBridge(inc);
        assertEquals(slope, b.getSlope());
        
    }
    
     /**
     * PRUEBAS DE dropBridge.
     * Caso 3: Bajamos algo intermedio
     */
    
    @Test
    public void  dropBridgeLessThanLimit() {
        int inc = BasculeBridge.MAX_SLOPE - 10; 
        int slope = BasculeBridge.MIN_SLOPE;
        
        BasculeBridge b = new BasculeBridge(BasculeBridge.MAX_SLOPE-10);
        b.dropBridge(inc);
        assertEquals(slope, b.getSlope());
        
    }
    
    /**
     * PRUEBAS DE dropBridge.
     * Caso 4: Bajamos más de la cuenta
     */
    
    @Test
    public void dropBridgeMoreThanLimit() {
        int inc = BasculeBridge.MAX_SLOPE + 10; 
        
        BasculeBridge b = new BasculeBridge(BasculeBridge.MAX_SLOPE);
        try {
            b.raiseBridge(inc);
            fail();
        }
        catch (Exception e) {
            assertEquals("Inclinación no válida", e.getMessage());
        }
        
    }
        
    
    /**
     * PRUEBAS DE dropBridge.
     * Caso 5: Bajamos un número negativo
     */
    
    @Test
    public void  dropBridgeNegative() {
        int inc = -1;
        int slope = BasculeBridge.MAX_SLOPE - 10;
        try{
            BasculeBridge b = new BasculeBridge(slope);
            b.dropBridge(inc);
            fail("Esperaba excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("Decremento debe ser positivo", e.getMessage());
        }
        
    }
}

