

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SeatManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SeatManagerTest
{
    /**
     * Default constructor for test class SeatManagerTest
     */
    public SeatManagerTest()
    {
    }
    
    // @Test
    // public void pruebaTonta(){
        // SeatManager sm = new SeatManager();
        // System.out.println("El número de filas de primera es:" + sm.getFirstRows());
        // int v = sm.getFirstRows();
        // v = v*2;
        // System.out.println("El número de filas de primera es: " + sm.getFirstRows());
    // }
    
    // @Test
    // public void getSeatsMalo(){
        // SeatManager sm = new SeatManager();
        // Person[][] copia = sm.getSeatsMALA();
        // System.out.println("Malo");
        // System.out.println("Antes");
        // sm.print();
        // copia[1][1] = new Person();
        // System.out.println("Después");
        // sm.print();
    // }
    
    // @Test
    // public void getSeatsBueno(){
        // SeatManager sm = new SeatManager();
        // Person[][] copia = sm.getSeats();
        // System.out.println("Malo");
        // System.out.println("Antes");
        // sm.print();
        // copia[1][1] = new Person();
        // System.out.println("Después");
        // sm.print();
    // }
    
    /**
     * Test del conductor por defecto
     * Caso único
     */
    @Test
    public void defConstUniqCase(){
        SeatManager sm = new SeatManager();
        assertEquals(SeatManager.MIN_FIRST_ROWS, sm.getFirstRows());
        assertEquals(SeatManager.MIN_STD_ROWS, sm.getStdRows());
        assertEquals(SeatManager.MIN_FIRST_ROWS + SeatManager.MIN_STD_ROWS, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 1: stdRows correcto(valor mínimo) Verificamos los distintos casos de firstRows
     * Caso 1.1: firstRows = MIN
     */
    @Test
    public void paramConstCaso1_1(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MIN_STD_ROWS;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 1: stdRows correcto(valor mínimo) Verificamos los distintos casos de firstRows
     * Caso 1.2: firstRows = MAX
     */
    @Test
    public void paramConstCaso1_2(){
        int first = SeatManager.MAX_FIRST_ROWS;
        int std = SeatManager.MIN_STD_ROWS;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 1: stdRows correcto(valor mínimo) Verificamos los distintos casos de firstRows
     * Caso 1.3: firstRows = MAX/2
     */
    @Test
    public void paramConstCaso1_3(){
        int first = SeatManager.MAX_FIRST_ROWS/2;
        int std = SeatManager.MIN_STD_ROWS;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 1: stdRows correcto(valor mínimo) Verificamos los distintos casos de firstRows
     * Caso 1.4: firstRows < MIN
     */
    @Test
    public void paramConstCaso1_4(){
        int first = SeatManager.MIN_FIRST_ROWS-1;
        int std = SeatManager.MIN_STD_ROWS;
        
        try{
            SeatManager sm = new SeatManager(first,std);
        
            fail("Debería haber fallado, porque el número de filas de primea clase es erróneo");
        }catch(RuntimeException e){
            assertEquals("Número invalido de filas de primera clase", e.getMessage());
        }
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 1: stdRows correcto(valor mínimo) Verificamos los distintos casos de firstRows
     * Caso 1.5: firstRows > MAX
     */
    @Test
    public void paramConstCaso1_5(){
        int first = SeatManager.MAX_FIRST_ROWS+1;
        int std = SeatManager.MIN_STD_ROWS;
        
        try{
            SeatManager sm = new SeatManager(first,std);
        
            fail("Debería haber fallado, porque el número de filas de primea clase es erróneo");
        }catch(RuntimeException e){
            assertEquals("Número invalido de filas de primera clase", e.getMessage());
        }
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 2: firstRows correcto(valor mínimo) Verificamos los distintos casos de stdRows
     * Caso 2.1: stdRows = MIN
     */
    @Test
    public void paramConstCaso2_1(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MIN_STD_ROWS;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 2: firstRows correcto(valor mínimo) Verificamos los distintos casos de stdRows
     * Caso 2.2: stdRows = MAX
     */
    @Test
    public void paramConstCaso2_2(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MAX_STD_ROWS;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 2: firstRows correcto(valor mínimo) Verificamos los distintos casos de stdRows
     * Caso 2.3: stdRows = MAX/2
     */
    @Test
    public void paramConstCaso2_3(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MAX_STD_ROWS/2;
        
        SeatManager sm = new SeatManager(first,std);
        
        assertEquals(first, sm.getFirstRows());
        assertEquals(std, sm.getStdRows());
        assertEquals(first+std, sm.numberOfRows());
        assertEquals(SeatManager.SEATS_PER_ROW, sm.numberOfColumns());
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 2: firstRows correcto(valor mínimo) Verificamos los distintos casos de stdRows
     * Caso 2.4: stdRows < MIN
     */
    @Test
    public void paramConstCaso2_4(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MIN_STD_ROWS-1;
        try{
            SeatManager sm = new SeatManager(first,std);
        
            fail("Debería haber fallado, porque el número de filas de primea clase es erróneo");
        }catch(RuntimeException e){
            assertEquals("Número invalido de filas de clase turista", e.getMessage());
        }
    }
    
    /**
     * Test del constructor con parámetros 
     * Grupo 2: firstRows correcto(valor mínimo) Verificamos los distintos casos de stdRows
     * Caso 2.5: stdRows > MAX
     */
    @Test
    public void paramConstCaso2_5(){
        int first = SeatManager.MIN_FIRST_ROWS;
        int std = SeatManager.MAX_STD_ROWS+1;
        
        try{
            SeatManager sm = new SeatManager(first,std);
            fail("Debería haber fallado, porque el número de filas de primea clase es erróneo");
        }catch(RuntimeException e){
            assertEquals("Número invalido de filas de clase turista", e.getMessage());
        }
    }
    
    /**
     * Test de bookSeat
     * Grupo 1: Fila y columna correcta. Verificamos distintos casos de person
     * Caso 1.1 person == null
     */
    @Test
    public void bookSeatCaso1_1(){
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = SeatManager.SEATS_PER_ROW;
        Person person = null;
        SeatManager sm = new SeatManager();
        
        try{
            sm.bookSeat(person,row,col);
            fail("Debería haber fallado");
        } catch(RuntimeException e){
            assertEquals("La persona tiene que existir",e.getMessage());
        }
    }
    
    /**
     * Test de bookSeat
     * Grupo 1: Fila y columna correcta. Verificamos distintos casos de person
     * Caso 1.2 person == null; asiento libre
     */
    @Test
    public void bookSeatCaso1_2(){
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = SeatManager.SEATS_PER_ROW;
        Person person = new Person();
        SeatManager sm = new SeatManager();
        sm.bookSeat(person, row, col);
        
        assertEquals(true,sm.bookSeat(new Person(),row,col));
        assertEquals(person, sm.getSeat(row,col));
    }
    
    /**
     * Test de bookSeat
     * Grupo 1: Fila y columna correcta. Verificamos distintos casos de person
     * Caso 1.3 person == null; asiento ocupado
     */
    @Test
    public void bookSeatCaso1_3(){
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        Person person = new Person();
        SeatManager sm = new SeatManager();
        sm.bookSeat(person, row, col);
        //Ya tengo el asiento row, col ocupado
        assertEquals(false,sm.bookSeat(new Person(),row,col));
        assertEquals(person, sm.getSeat(row,col));
    }
    
    /**
     * Test de bookSeat
     * Grupo 1: Fila y columna correcta. Verificamos distintos casos de ocupación del asiento
     * Caso 1.1 asiento libre
     */
    @Test
    public void releaseSeatCaso1_1(){
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        Person person = null;
        SeatManager sm = new SeatManager();
        sm.bookSeat(person, row, col);
        
        assertEquals(null,sm.releaseSeat(row,col));
        assertEquals(null, sm.getSeat(row,col));
    }
    
    /**
     * Test de bookSeat
     * Grupo 1: Fila y columna correcta. Verificamos distintos casos de ocupación del asiento
     * Caso 1.2 asiento ocupado
     */
    @Test
    public void releaseSeatCaso1_2(){
        int row = SeatManager.MIN_FIRST_ROWS;
        int col = 0;
        Person p = new Person();
        SeatManager sm = new SeatManager();
        sm.bookSeat(p, row, col);
        
        assertEquals(p,sm.releaseSeat(row,col));
        assertEquals(null, sm.getSeat(row,col));
    }
    
    @Test
    public void testPrint(){
        SeatManager sm = new SeatManager();
        sm.bookSeat(new Person(34),0,1);
        sm.bookSeat(new Person(5),1,2);
        sm.bookSeat(new Person(12),1,5);
        sm.bookSeat(new Person(66),1,3);
        sm.bookSeat(new Person(44),3,4);
        sm.bookSeat(new Person(1),6,2);
        sm.print();
    }
}

