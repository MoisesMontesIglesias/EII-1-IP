import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class SeatManagerTest.
 *
 * @author  Moisés Montes Iglesias
 * @version 22-11-2022
 */
public class SeatManagerTest
{
    /**
     * Prueba del constructor sin parámetros
     */
    @Test
    public void constructorWithoutParamsOfSeatManager()
    {
        SeatManager sm = new SeatManager();
        
        assertEquals(SeatManager.MIN_FIRST_ROWS, sm.getFirstRows());
        assertEquals(SeatManager.MIN_STANDARD_ROWS, sm.getStandardRows());
        assertEquals(SeatManager.MIN_FIRST_ROWS + SeatManager.MIN_STANDARD_ROWS, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 1- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 1.1: firstRows = MIN
     */
    @Test
    public void paramConstCaso1_1()
    {
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MAX_STANDARD_ROWS;
        
        SeatManager sm = new SeatManager(first, std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStandardRows());
        assertEquals(first + std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 1- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 1.2: firstRows = MAX
     */
    @Test
    public void paramConstCaso1_2()
    {
        int first = SeatManager.MAX_FIRST_ROWS;
        int std = SeatManager.MAX_STANDARD_ROWS;
        
        SeatManager sm = new SeatManager(first, std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStandardRows());
        assertEquals(first + std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
   
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 1- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 1.3: firstRows = MAX / 2
     */
    @Test
    public void paramConstCaso1_3()
    {
        int first = SeatManager.MAX_FIRST_ROWS/2;
        int std = SeatManager.MAX_STANDARD_ROWS;
        
        SeatManager sm = new SeatManager(first, std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStandardRows());
        assertEquals(first + std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 1- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 1.4: firstRows < MIN
     */
    @Test
    public void paramConstCaso1_4()
    {
        int first = SeatManager.MIN_FIRST_ROWS-1;
        int std = SeatManager.MIN_STANDARD_ROWS;
        try {
            SeatManager sm = new SeatManager(first, std);
            fail("Deberia haber fallado porque el número de filas de primera es incorrecto");
        } catch (RuntimeException e) {
            assertEquals("Filas en primera fuera de límites", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 1- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 1.5: firstRows > MAX
     */
    @Test
    public void paramConstCaso1_5()
    {
        int first = SeatManager.MAX_FIRST_ROWS + 1;
        int std = SeatManager.MIN_STANDARD_ROWS;
        try {
            SeatManager sm = new SeatManager(first, std);
            fail("Deberia haber fallado porque el número de filas de primera es incorrecto");
        } catch (RuntimeException e) {
            assertEquals("Filas en primera fuera de límites", e.getMessage());
        }
    }
    
    /**
     * Pruebas del constructor con parámetros
     * 
     * Casos de uso:
     * Grupo 2- StandardRows correcto, (valor mínimo). Verificamos los distintos casos de firstRows
     * Caso 2.1: StandardRows = MIN
     */
    @Test
    public void paramConstCaso2_1()
    {
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MIN_STANDARD_ROWS;
        
        SeatManager sm = new SeatManager(first, std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStandardRows());
        assertEquals(first + std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Pruebas del método bookSeat
     * Grupo1: fila y columna correcta, verificamos distintos casos de person
     * Caso 1.1: person == null
     */
    @Test
    public void bookSeatConstCaso1_1()
    {
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = SeatManager.SEATS_PER_ROW;
        Person person = null;
        SeatManager sm = new SeatManager();
        try {
            sm.bookSeat(person, row, col);
            fail("Debería haber fallado");
        } catch (RuntimeException e){
            assertEquals("Esperaba persona en lugar de null", e.getMessage());
        }
    }
    
    /**
     * Pruebas del método bookSeat
     * Grupo1: fila y columna correcta, verificamos distintos casos de person
     * Caso 1.2: person != null; asiento libre
     */
    @Test
    public void bookSeatConstCaso1_2()
    {
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = SeatManager.SEATS_PER_ROW;
        Person person = new Person();
        SeatManager sm = new SeatManager();
        
        try {
            sm.bookSeat(person, row, col);
            fail("Debería haber fallado");
        } catch (RuntimeException e){
            assertEquals("Columna fuera de límites", e.getMessage());
        }
        //assertEquals(true, sm.bookSeat(person,row,col));
        //assertEquals(person, sm.getSeats(row,col));
    }
    
    /**
     * Pruebas del método bookSeat
     * Grupo1: fila y columna correcta, verificamos distintos casos de person
     * Caso 1.3: person != null; asiento ocupado
     */
    @Test
    public void bookSeatConstCaso1_3()
    {
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        Person person = new Person();
        SeatManager sm = new SeatManager();
        sm.bookSeat(person, row,col);
        // Ya tengo el asiento row, col ocupado
        
        assertEquals(false, sm.bookSeat(new Person(), row,col));
        assertEquals(person, sm.getSeat(row,col));
    }
    
    /**
     * Pruebas del método releaseSeat
     * grupo 1: fila y columna correcta. verificamos distintos casos de ocupacion del asiento
     * caso 1.1; asiento libre
     */
    @Test
    public void releaseSeatConstCaso1_1()
    {
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        SeatManager sm = new SeatManager();

        
        assertEquals(null, sm.releaseSeat(row,col));
        assertEquals(null, sm.getSeat(row,col));
    }
    
    /**
     * Pruebas del método releaseSeat
     * grupo 1: fila y columna correcta. verificamos distintos casos de ocupacion del asiento
     * caso 1.2; asiento ocupado
     */
    @Test
    public void releaseSeatConstCaso1_2()
    {
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        Person person = new Person();
        SeatManager sm = new SeatManager();
        sm.bookSeat(person, row, col);        //para ocupar el asiento        
        assertEquals(person, sm.releaseSeat(row,col));
        assertEquals(null, sm.getSeat(row,col));
    }
    
    public void testPrint()
    {
        SeatManager sm = new SeatManager(6,10);
        sm.bookSeat(new Person(34), 0,1);
        sm.bookSeat(new Person(5), 1,2);
        sm.bookSeat(new Person(12), 1,5);
        sm.bookSeat(new Person(66), 1,3);
        sm.bookSeat(new Person(44), 3,4);
        sm.bookSeat(new Person(1), 6,2);
        sm.print();
    }
    
    /**
     * Pruebas del getYoungestPeople
     * Caso 1: avión vacío
     */
    @Test
    public void getYoungestPeopleEmptyPlane(){
        SeatManager sm = new SeatManager();
        ArrayList<Person> result = sm.getYoungestPeople();
        assertNotNull(result);;
        assertEquals(0, result.size());
    }
    
    // /**
     // * Pruebas del getYoungestPeople
     // * Caso 2 :Avión con pasajeros, varios con edad mínima
     // */
    // @Test
    // public void getYoungestPeopleNotEmptyPlane(){
        // Random r = new Random();
        // SeatManager sm = new SeatManager();
        // ArrayList<Person> result = sm.getYoungestPeople();
        
        // Person p1 = new Person(10);
        // Person p2 = new Person(10);
        // Person p3 = new Person(10);
        
        
        // sm.bookSeat(p1, 0 ,0);
        // sm.bookSeat(p2, sm.numberOfRows()-1, sm.numberOfColumns()-1);
        // sm.bookSeat(p3, 2 ,3);
        
        
        // for (int i = 0; i<10; i++){
            // int row = r.nextInt(sm.numberOfRows());
            // int col = r.nextInt(sm.numberOfColumns());
            // sm.bookSeat(new Person(20+i), row, col);
        // }
        // ArrayList<Person> esult = sm.getYoungestPeople();
        
        // assertNotNull(result);
        // assertEquals(3, result.size());
        // assertTrue(result.contains(p1));
        // assertTrue(result.contains(p2));
        // assertTrue(result.contains(p3));
    // }
}