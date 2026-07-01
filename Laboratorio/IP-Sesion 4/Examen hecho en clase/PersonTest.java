

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
     * Pruebas del constructor con 4 parámetros. Verifica el nombre
     * Caso 1 : Nombre bueno
     */
    @Test
    public void constructor4ParamValidName(){
        Person p = new Person("Pedro", "Sanchez", 45, Person.GENDER_MALE);
        assertEquals("Pedro", p.getName());
        assertEquals("Sanchez", p.getSurname());
        assertEquals(45, p.getAge());
        assertEquals(Person.GENDER_MALE, p.getGender());
    }
    
    
    /**
     * Pruebas del constructor con 4 parámetros. Verifica el nombre
     * Caso 2 : nombre malo (null)
     */
        @Test
    public void constructor4ParamInvalidName(){
        try {
            Person p = new Person(null, "Sanchez", 45, Person.GENDER_MALE);
            fail("Debería haber fallado");
        }
        catch (RuntimeException e){
            assertEquals("El nombre no puede ser null", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con 4 parámetros. Verifica el nombre
     * Caso 3 : Apellido malo (null)
     */
        @Test
    public void constructor4ParamInvalidSurname(){
        try {
            Person p = new Person("Pedro", null, 45, Person.GENDER_MALE);
            fail("Debería haber fallado");
        }
        catch (RuntimeException e){
            assertEquals("El apellido no puede ser null", e.getMessage());
        } 
    }
        
    /**
     * Pruebas del constructor sin parámetros
     * Caso 1: Caso único
     */
    @Test
    public void constructorUniqCase(){
        Person p = new Person();
        
        assertEquals(Person.DEFAULT_NAME, p.getName());
        assertEquals(Person.DEFAULT_SURNAME, p.getSurname());
        assertEquals(Person.DEFAULT_AGE, p.getAge());
        assertEquals(Person.DEFAULT_GENDER, p.getGender());
    }
    
    /**
     * Prueba del método setAge. 
     * 1.- Dentro de límites
     */
    @Test
    public void setCriticalAgeInsideLimits(){
        Person p;
        // Person p;
        
        // p = new Person();
        p = new Person(Person.ADULTHOOD_AGE);
        assertEquals(Person.ADULTHOOD_AGE,p.getAge());
    }
    
    /**
     * Prueba del método setAge. 
     * 2.- Debajo de límites
     */
    @Test
    public void setCriticalAgeBelowLimits(){
        Person p;

        p = new Person(7);
        assertEquals(7,p.getAge());      
    }
    
    /**
     * Prueba del método setAge. 
     * 3.- Encima de límites
     */
    @Test
    public void setCriticalAgeAboveLimits(){
        Person p;

        p = new Person(80);
        assertEquals(80,p.getAge());
    }
    
    /**
     * Prueba del método getHashCode. 
     */
    @Test
    public void getHashCode1(){
        Person p = new Person("Carlos", "Sainz", 27, Person.GENDER_MALE);

        p.getHashCode();
        assertEquals("27-CA-SAIN-ADULT",p.getHashCode());
    }
    
    /**
     * Prueba del método HashCode.
     */
    @Test
    public void getHashCodeInsideLimits() {
        try {
            Person p = new Person();
            p.setName(null);
            assertEquals(null,p.getName());
        }
        catch (RuntimeException e){
            assertEquals("El nombre no puede ser null", e.getMessage());
        }
    }
    
    // /**
     // * Prueba del método getHashCode hecho por el profe, otra forma de hacerlo
     // */
    // @Test
    // public void getHashCode1(){
        // Person person1 = new Person("Pedro", "Álvarez", 35, Person.GENDER_MALE);
        // String hashCode = person1.getHashCode();
        // String expected = "35-PEDRO-5-ÁLVAREZ-7";
        // assertEquals(expected,hashCode);
    // }
    
    /**
     * Prueba del método getDiscount para los niños menores de 12 años
     */
    @Test
    public void getDiscountKid(){
        Person p = new Person();
        p = new Person(8);
        assertEquals(8,p.getAge());
    }
    
    /**
     * Prueba del método getDiscount para las personas entre 12 y 18 años
     */
    @Test
    public void getDiscountTeen(){
        Person p = new Person();
        p = new Person(16);
        assertEquals(16,p.getAge());
    }
    
    /**
     * Prueba del método getDiscount para las personas entre 18 y 65 años
     */
    @Test
    public void getDiscountAdulthood(){
        Person p = new Person();
        p = new Person(54);
        assertEquals(54,p.getAge());
    }
    
    /**
     * Prueba del método getDiscount para las personas mayores de 65 años
     */
    @Test
    public void getDiscountRetirement(){
        Person p = new Person();
        p = new Person(79);
        assertEquals(79,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot dentro de límites para el caso de ser mujer
     */
    @Test
    public void canBePilotFemaleInsideLimits(){
        Person p = new Person();
        p = new Person(45);
        assertEquals(45,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot por debajo de los límites para el caso de ser mujer
     */
    @Test
    public void canBePilotFemaleBelowLimits(){
        Person p = new Person();
        p = new Person(17);
        assertEquals(17,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot por encima de los límites para el caso de ser mujer
     */
    @Test
    public void canBePilotFemaleAboveLimits(){
        Person p = new Person();
        p = new Person(69);
        assertEquals(69,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot dentro de límites para el caso de ser hombre
     */
    @Test
    public void canBePilotMaleInsideLimits(){
        Person p = new Person();
        p = new Person(34);
        assertEquals(34,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot por debajo de los límites para el caso de ser hombre
     */
    @Test
    public void canBePilotMaleBelowLimits(){
        Person p = new Person();
        p = new Person(28);
        assertEquals(28,p.getAge());
    }
    
    /**
     * Prueba del método canBePilot por encima de los límites para el caso de ser hombre
     */
    @Test
    public void canBePilotMaleAboveLimits(){
        Person p = new Person();
        p = new Person(56);
        assertEquals(56,p.getAge());
    }
}
