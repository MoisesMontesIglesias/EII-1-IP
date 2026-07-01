import java.util.Random;
import java.util.*;

/**
 * Gestor de asientos del avión
 * 
 * @author Moisés Montes Iglesias 
 * @version 22-11-22
 */
public class SeatManager
{
    public static final int SEATS_PER_ROW = 6;
    
    public static final int MIN_FIRST_ROWS = 3;
    public static final int MAX_FIRST_ROWS = 10;
    
    public static final int MIN_STANDARD_ROWS = 4;
    public static final int MAX_STANDARD_ROWS = 40;
    
    
    private int firstRows;      //número de filas en primera
    private int standardRows;   //número de filas en turista
    private Person[][] seats;   //matriz de asientos con personas
    
    /**
     * Constructor sin parámetros 
     */
    public SeatManager()
    {
        setFirstRows(MIN_FIRST_ROWS);
        setStandardRows(MIN_STANDARD_ROWS);
        seats = new Person[getFirstRows() + getStandardRows()][SEATS_PER_ROW];
    }
    
    /**
     * Crea un gestor del pasaje estándar(con 3 filas de primera y 4 de turista) con un número
     * determinado de pasajeros ya sentados
     * @param n Número de pasajeros a sentar en el avión
     */
    public SeatManager(int n){
        this();
        checkParam(n<=numberOfRows() * numberOfColumns(), "Demasiados pasajeros");        
        Random r = new Random();
        for ( int i = 0; i<n; i++){
            int row = r.nextInt(numberOfRows());
            int col = r.nextInt(numberOfColumns());
            while(bookSeat(new Person() ,row, col) == false)
            row = r.nextInt(numberOfRows());
            col = r.nextInt(numberOfColumns() );
        }
    }
    
    /**
     * Constructor que recibe filas de primera y de turista
     * 
     * @param firstRows, de tipo int
     * @param standardRows, de tipo int
     */
    public SeatManager(int firstRows, int standardRows)
    {
        this();
        setFirstRows(firstRows);
        setStandardRows(standardRows);
        seats = new Person[getFirstRows() + getStandardRows()][SEATS_PER_ROW];
    }

    
    /*
     * Asigna valor a firstRows
     * 
     * @param firstRows, de tipo int
     */
    private void setFirstRows(int firstRows)
    {
        checkParam(firstRows >= MIN_FIRST_ROWS && firstRows <= MAX_FIRST_ROWS, "Filas en primera fuera de límites");
        this.firstRows = firstRows;
    }
    
    /**
     * Método que devuelve el número de filas en primera 
     * 
     * @retun firstRows, número de filas de primera clase, de tipo int
     */
    public int getFirstRows()
    {
        return firstRows;
    }
    
    /*
     * Asigna valor a standardRows
     * 
     * @param standardRows, de tipo int
     */
    private void setStandardRows(int standardRows)
    {
        checkParam(standardRows >= MIN_STANDARD_ROWS && standardRows <= MAX_STANDARD_ROWS, "Filas en turista fuera de límites");
        this.standardRows = standardRows;
    }
    
    /**
     * Método que devuelve el número de filas en primera 
     * 
     * @retun standardRows, número de filas de clase turista, de tipo int
     */
    public int getStandardRows()
    {
        return standardRows;
    }
    
    /**
     * Mete a la persona p en la posición [f,c] del array seats
     */
    private void setSeats(Person p, int f, int c)
    {
        checkParam(f >= 0 && f < numberOfRows(), "Número de filas fuera de límites");
        checkParam(c >= 0 && c < numberOfColumns(), "Número de columnas fuera de límites");
        seats [f][c] = p;
    }
    
     /*
     * Crea matriz de dimensiones recibidas como parámetro
     * 
     * @param rows
     */
    public Person getSeat(int f, int c)
    {
        checkParam(f >= 0 && f < numberOfRows(), "Número de filas fuera de límites");
        checkParam(c >= 0 && c < numberOfColumns(), "Número de columnas fuera de límites");
        return seats [f][c];
    }
    
    // public Person [][] getSeats() 
    // {
        // Person [][] aux = new Person [seats.length][seats[0].length];
        // for ( int f=0; f<seats.length; f++)
            // for(int c=0; c<seats.length; f++)
                // aux [f][c]=seats[f][c];
        // return aux;
    // }
    
    
    
    /**
     * Número de filas del avión
     * 
     * @return número de filas
     */
    public int numberOfRows()
    {
        return this.getFirstRows() + this.getStandardRows();
        // return seats.length;
    }
    
    /**
     * Número de columnas del avión
     * 
     * @return número de columnas
     */
    public int numberOfColumns()
    {
        return SEATS_PER_ROW;
        //return seats[0].length;
    }
    
    /**
     * Reserva un asiento para la persona que recibe como parámetro en la posición recibida como 
     * parámetro siempre que el asiento esté libre
     * 
     * @param p, persona a reservar
     * @param row, fila de la reserva
     * @param column, columna de la resrva
     * 
     * @return true si ha podido reservar, y false si estaba ocupado
     */
    public boolean bookSeat(Person p, int row, int column)
    {
        checkParam(p != null, "Esperaba persona en lugar de null");
        checkParam(row >= 0  && row < seats.length, "Fila fuera de límites");
        checkParam(column >= 0  && column < seats[0].length, "Columna fuera de límites");
        if(getSeat(row, column) != null) {
            return false;
        } else {
            setSeats(p, row, column);
            return true;
        }
    }   
    
    /**
     * Método que deja libre un asiento. Si el asiento está ocupado devuelve la persona que está sentada y si el asiento 
     * está libre devuelve null
     *
     * @param row, fila de la reserva
     * @param column, columna de la resrva
     * 
     * @return p, de tipo Person si el asiento está ocupado 
     */
    public Person releaseSeat(int row, int column)
    {
        Person p = getSeat(row, column);
        setSeats(null, row, column);
        return p;
    }
    
    /**
     * Método que muestra el estado de los asientos del avión
     * Una X para un adulto, una C, para un niño, un ? para un asiento libre
     */
    public void print()
    {
        System.out.print("  ");
        for(int c = 0; c < numberOfColumns(); c++) {
            System.out.print(String.format("%2d",c));
        }
        System.out.println();
        for(int f = 0; f < numberOfRows(); f++) {
            System.out.print(String.format("%2d ",f));
            for(int c = 0; c < numberOfColumns(); c++) {
                if(getSeat(f,c) == null) {
                    System.out.print("? ");
                } else {
                    System.out.print(getSeat(f,c).getAge()<Person.ADULTHOOD_AGE?"C ":"X ");
                }
            }
            System.out.println();
        }
    }
    
    // Devuelve la edad más baja de pasajeros en el avión; -1 si no hay pasajeros
    private int minAge(){
        int min = Person.MAX_AGE;
        for (int i = 0; i<numberOfRows(); i++){
            for ( int j = 0; j<numberOfColumns(); j++){
                Person p = getSeat(i,j);
                if (p != null && p.getAge()<min){
                    min = p.getAge();
                }
            }
        }
        if (min == Person.MAX_AGE){
            return -1;
        }else {
            return min;
        }
    }
    
    /**
     * Devuelve una lista con los pasajeros de menor edad del avión
     * @return Pasajeros con edad mínima en el avión
     */
    public ArrayList<Person> getYoungestPeople(){
        ArrayList<Person> lista = new ArrayList <Person>();
        int min = minAge();
        
        for (int i = 0; i<numberOfRows(); i++){
            for(int j =  0; j<numberOfColumns(); j++){
                Person p = getSeat(i,j);
                if ( p!= null && p.getAge() == min){
                    lista.add(p);
                }
            }
        }
        return lista;
    }   
    
    public ArrayList<Person> childrenPassengers(){
        ArrayList<Person> lista = new ArrayList<Person>();
        for (int i = 0; i<numberOfRows(); i++){
            for(int j =  0; j<numberOfColumns(); j++){
                Person p = getSeat(i,j);
                if ( p!= null && p.getAge()<Person.ADULTHOOD_AGE){
                    lista.add(p);
                }
            }
        }
        return lista;
    }
    
    /*
     * Método que comprueba una condición recibida.
     * Si no se cumple se lanza una excepción y se muestra un mensaje genérico.
     * 
     * @param  condition condición que va a comprobar si se cumple
     * 
     */
    private void checkParam(boolean condition,String message)
    {
        if (!condition) {
            throw new IllegalArgumentException (message);
        }
    }
}
