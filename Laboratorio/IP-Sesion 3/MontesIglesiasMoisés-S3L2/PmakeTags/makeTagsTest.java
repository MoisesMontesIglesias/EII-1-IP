

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class makeTagsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class makeTagsTest
{
    /**
     * Default constructor for test class makeTagsTest
     */
    public makeTagsTest()
    {
    }
    
    /**
     * Prueba del Ejercicio. 
     */
    @Test
    public void setmakeTags(){
        makeTags m = new makeTags();
        m.getName();
        assertEquals("<"+">"+"</"+">",m.getName());
    }
}

