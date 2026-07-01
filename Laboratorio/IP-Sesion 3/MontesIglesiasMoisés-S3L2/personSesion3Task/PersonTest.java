

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest.
 *
 * @author  Moisés Montes Iglesias
 * @version 02/10/2022
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
    public void setCriticalAgeInsideLimits(){
        Person p = new Person();
        // Person p;
        
        // p = new Person();
        p.setAge(18);
        assertEquals(18,p.getAge());
    }
    
    /**
     * Prueba del método setAge. 
     * 2.- Debajo de límites
     */
    @Test
    public void setCriticalAgeBelowLimits(){
        Person p = new Person();

        p.setAge(7);
        assertEquals(7,p.getAge());
    }
    
    /**
     * Prueba del método setAge. 
     * 3.- Encima de límites
     */
    @Test
    public void setCriticalAgeAboveLimits(){
        Person p = new Person();

        p.setAge(80);
        assertEquals(80,p.getAge());
    }
    
    /**
     * Prueba del método getHashCode. 
     */
    @Test
    public void getHashCode1(){
        Person p = new Person("Carlos", "Sainz", 27, Person.GENDER_MALE);

        p.getHashCode();
        assertEquals("27-CARLOS-6-SAINZ-5",p.getHashCode());
    }
}
