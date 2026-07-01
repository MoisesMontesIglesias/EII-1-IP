

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
    {
    }
    
    /**
     * Prueba del método setAge. 
     * 1.- Dentro de límites
     */
    @Test
    public void setAgeInsideLimits(){
        Person p = new Person();
        // Person p;
        
        // p = new Person();
        p.setAge(30);
        assertEquals(30,p.getAge());
    }
    
    /**
     * Prueba del método setAge. 
     * 2.- Debajo de límites
     */
    @Test
    public void setAgeBelowLimits(){
        Person p = new Person();
        // Person p;
        
        // p = new Person();
        try {
            p.setAge(-1);
            fail("Debería haber fallado dado que la edad es -1");
        }
        catch(RuntimeException e){
            assertEquals("La edad no puede ser negativa", e.getMessage());
        }
    }
    
    /**
     * Prueba del método setAge. 
     * 3.- Encima de límites
     */
    @Test
    public void setAgeAboveLimits(){
        Person p = new Person();
        try {
            p.setAge(Person.MAX_AGE);
            fail("Debería haber fallado dado que la edad no puede ser mayor de 120");
        }
        catch(RuntimeException e){
            assertEquals("La edad no puede ser mayor de 120", e.getMessage());
        }
    }
}
