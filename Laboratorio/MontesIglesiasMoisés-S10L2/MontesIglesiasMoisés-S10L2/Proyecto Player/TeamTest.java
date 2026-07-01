

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TeamTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TeamTest
{
    /**
     * Default constructor for test class TeamTest
     */
    public TeamTest()
    {
    }

    /**
     * Test sobre el constructor, para una lista vacía y otra no vacía
     */
    @Test
    public void Constructor(){
        Player p = new Player("Riesgo",13);
        Player p1 = new Player("Escalante", 5);
        // Casos Positivos:
        // Caso 1: Lista vacía
        Team t = new Team();
        t.add(p);
        assertEquals(1,t.getTeam().size());
        assertTrue(t.getTeam().contains(p));
        
        // Caso 2: Lista no vacía
        t.add(p1);
        assertEquals(2,t.getTeam().size());
        assertTrue(t.getTeam().contains(p1));
        assertTrue(t.getTeam().contains(p));
        
        //Caso negativo: Añadimos un elemento nulo
        try{
            t.add(null);
        } catch(RuntimeException e){
            
        }
    }
}
