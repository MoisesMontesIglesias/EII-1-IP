

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TreeTest.
 *
 * @author  Moisés Montes Iglesias
 * @version 02/10/2022
 */
public class TreeTest
{
    /**
     * Default constructor for test class TreeTest
     */
    public TreeTest()
    {
    }
    
    /**
     * Prueba del método setNumberOfFlowers
     * Entre los límites 
     */
    @Test
    public void setNumberOfFlowersInsideLimits(){
        Tree t = new Tree();
        t.setNumberOfFlowers(8);
        assertEquals(8,t.getNumberOfFlowers());
    }
    
    /**
     * Prueba del método setNumberOfFlowers
     * Por encima de los límites
     */
    @Test
    public void setNumberOfFlowersAboveLimits(){
        Tree t = new Tree();
        try{
            t.setNumberOfFlowers(20);
            fail("Debe fallar porque el máximo es 12, y por lo tanto está fuera de límites");
        }
        catch(RuntimeException e){
            assertEquals("La cantidad de flores/frutas no puede ser negativa o mayor de 12", e.getMessage());
        }
    }
    
    /**
     * Prueba del método setNumberOfFlowers
     * Por debajo de los límites
     */
    @Test
    public void setNumberOfFlowersBelowLimits(){
        Tree t = new Tree();
        try{
            t.setNumberOfFlowers(-8);
            fail("Debe fallar porque el mínimo de flores es 0, y por lo tanto está fuera de límites");
        }
        catch(RuntimeException e){
            assertEquals("La cantidad de flores/frutas no puede ser negativa o mayor de 12", e.getMessage());
        }
    }
}
