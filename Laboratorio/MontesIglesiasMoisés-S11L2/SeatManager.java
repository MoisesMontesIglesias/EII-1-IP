
/**
 * Gestor del pasaje de un avión
 * 
 * @author Profes-IP
 * @version 1.0
 */
public class SeatManager {
    public static final int SEATS_PER_ROW = 6;           
    public static final int MIN_FIRST_ROWS = 3;
    public static final int MIN_STD_ROWS = 4;
    public static final int MAX_FIRST_ROWS = 10;
    public static final int MAX_STD_ROWS = 40;
    private int firstRows;
    private int stdRows;
    private Person [][] seats;
   
    
    /**
     * Crea un gestor del pasaje estándar (con 3 filas de primera y 4 de turista
     */
    public SeatManager()  {
       setFirstRows(MIN_FIRST_ROWS);
       setStdRows(MIN_STD_ROWS);
       seats = new Person [getFirstRows()+getStdRows()][SEATS_PER_ROW];
    }
    
    /**
     * Crea un gestor del pasaje estándar (con tantas filas de primera y turista como se nos especifique)
     * @param firstRows Número de filas de primera clase
     * @param stdRows Número de filas de clase turista
     */
    public SeatManager(int firstRows, int stdRows)  {
        this();
        setFirstRows(firstRows);
        setStdRows(stdRows);
        seats = new Person[getFirstRows()+getStdRows()][SEATS_PER_ROW];
    }
    
    // Establece el número de filas de primera clase
    private void setFirstRows(int n) {
        checkParam(n>=MIN_FIRST_ROWS && n<=MAX_FIRST_ROWS, "Número invalido de filas de primera clase");
        firstRows = n;
    }
    
    // Establece el número de filas de clase turista
    private void setStdRows(int n) {
        checkParam(n>=MIN_STD_ROWS && n<=MAX_STD_ROWS, "Número invalido de filas de clase turista");
        stdRows = n;
    }
    
    /**
     * Devuelve en número de filas de primera clase
     * @return Número de filas de primera clase
     */
    public int getFirstRows() {
        return this.firstRows;
    }
    
    /**
     * Devuelve en número de filas de  clase turista
     * @return Número de filas de clase turista
     */
    public int getStdRows() {
        return this.stdRows;
    }
    
    /**
     * Verifica una condición relacionada con un parámetro
     * @param condition Condición booleana a cumplir. Si es falso, se genera una excepción
     * @param msg Mensaje que acompaña a la excepción
     * @throws Excepción de "Argumento Ilegal", con mensaje explicativo
     */
     private void checkParam(boolean condition, String msg) {
        //if (condition==false)
        if (!condition)
            throw new IllegalArgumentException(msg);
        
    }
    
    /**
     * 
     */
    public Person [][] getSeats(){
        Person[][] aux= new Person[seats.length][seats[0].length];
        for (int f = 0; f<seats.length; f++)
            for (int c = 0; c<seats[0].length; c++)
                aux[f][c] = seats[f][c];
        return aux;
    }

    /**
     * 
     */
    public Person [][] getSeatsMALA(){
        return seats;
    }
    
    /**
     * 
     */
    public Person getSeat(int f, int c){
        checkParam (f>=0 && f<numberOfRows(), "Número de fila inválido");
        checkParam (c>=0 && c<numberOfRows(), "Número de columna inválido");
        return seats[f][c];
        
    }
    
    private Person setSeat(Person p, int f, int c){
        checkParam (f>=0 && f<numberOfRows(), "Número de fila inválido");
        checkParam (c>=0 && c<numberOfRows(), "Número de columna inválido");
        return seats[f][c] = p;
    }
    
    /**
     * Número de filas del avión
     * @return número de filas del avión
     */
    public int numberOfRows(){
        return this.getFirstRows() + this.getStdRows();
        //return seats.length;
    }
    
    /**
     * Número de asientos por fila del avión
     * @return número de asientos por fila del avión
     */
    public int numberOfColumns(){
        return SEATS_PER_ROW;
        //return seats[0].length;
    }
    
    /**
     * Sienta a una persona en un asiento si este está vacío. La persona debe existir
     * @param p Persona a sentar
     * @param row Fila del asiento
     * @param column Columna del asiento
     * @return true si se ha conseguido sentar a la persona; false si es asiento estaba ocupado
     */
    public boolean bookSeat(Person p, int row, int column){
        checkParam(p!=null, "La persona tiene que existir");
        if(getSeat(row,column)!=null){
            return false;
        }else{
            setSeat(p,row,column);
            return true;
        }
    }
    
    /**
     * Libera un asiento del avión
     * @param row Fila del asiento
     * @param column Columna del asiento
     * @return Persona que ocupaba el asiento; null si estaba vacío
     */
    public Person releaseSeat(int row, int column){
        Person p = getSeat(row, column);
        setSeat(null, row, column);
        return p;
    }
    
    /**
     * Método print que muestre el estado de los asientos del avión
     */
    public void print(){
        System.out.print("  ");
        for (int c= 0; c<numberOfColumns(); c++){
            
        }
        
        
        System.out.println();
        for (int f=0; f<numberOfRows(); f++){
            System.out.print(String.format("%2d ",f));
            for (int c=0; c<numberOfColumns(); c++){
                if (getSeat(f,c)==null){
                    System.out.println("? ");
                } else{
                    System.out.println(sm.getSeat(f,c).getAge()<Person.ADULTHOOD_AGE?"C ":"X ");
                }
            }
            System.out.println();
            }
        }
    }
}