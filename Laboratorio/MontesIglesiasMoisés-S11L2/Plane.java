
/**
 * Write a description of class Plain here.
 * 
 * @Moisés Montes Iglesias 
 * @04/10/2022
 */
public class Plane
{
    private Person pilot;
    private char identifier;
    private int fuel;
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;
    private int row;
    private int column;
    private LandingGear landingGear;
    Person seats[][];
    
    public final static char ADULT = 'X';
    public final static char CHILD = 'C';
    public final static char EMPTY = '?';
    
    public final static Person DEFAULT_PILOT = null;
    public final static char DEFAULT_IDENTIFIER = 'A';
    public final static int DEFAULT_FUEL = 0;
    
    public static final char MIN_IDENTIFIER = 'A';
    public static final char MAX_IDENTIFIER = 'Z';
    
    public static final int MIN_FUEL = 0;
    public static final int MAX_FUEL = 5000;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano X
     */
    public final static int MAX_X = 10;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano X
     */
    public final static int MIN_X = 0;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano Y
     */
    public final static int MAX_Y = 10;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano Y
     */
    public final static int MIN_Y = 0;
    
    /**
     * Valor máximo de la velocidad en el eje X
     */
    public final static int MAX_XSPEED = 1;
    
    /**
     * Valor mínimo de la velocidad en el eje X
     */
    public final static int MIN_XSPEED = -1;
    
    /**
     * Valor máximo de la velocidad en el eje Y
     */
    public final static int MAX_YSPEED = 1;
    
    /**
     * Valor mínimo de la velocidad en el eje Y
     */
    public final static int MIN_YSPEED = -1;
    
    /**
     * Constructor con valores por defecto para todos los atributos
     */
    public Plane(){
        setPilot(null);
        setIdentifier(MIN_IDENTIFIER);
        setFuel(MIN_FUEL);
        setPositionFromX(MIN_X);
        setPositionFromY(MIN_Y);
        setSpeedFromX(0);
        setSpeedFromY(0);
        this.setLandingGear(new LandingGear());
        seats = new Person[8][6];
    }
    
    /**
     * Constructor que recibe todos los parámetros
     * @param pilot piloto del avión
     * @param identifier identificador del avión
     * @param fuel cantidad de combustible (en litros) del avión
     * @param positionFromX posición en el eje x
     * @param positionFromY posición en el eje y
     * @param speedFromX velocidad en el eje x
     * @param speedFromY velocidad en el eje y
     */
    public Plane(Person pilot, char identifier, int fuel, int positionFromX,
    int positionFromY, int speedFromX, int speedFromY){
        this();
        setPilot(pilot);
        setIdentifier(identifier);
        setFuel(fuel);
        setPositionFromX(positionFromX);
        setPositionFromY(positionFromY);
        setSpeedFromX(speedFromX);
        setSpeedFromY(speedFromY);
    }
    
    /**
     * Constructor que recibe dos parámetros
     * @param speedFromX velocidad en el eje x
     * @param speedFromY velocidad en el eje y
     */
    public Plane(int speedFromX, int speedFromY){
        this();
        setSpeedFromX(speedFromX);
        setSpeedFromY(speedFromY);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el piloto
     * @param pilot Piloto del avión
     */
    public Plane(Person pilot){
        this();
        setPilot(pilot);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el identificador
     * @param pilot Piloto del avión
     */
    public Plane(char identifier){
        this();
        setIdentifier(identifier);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el combustible
     * @param pilot Piloto del avión
     */
    public Plane(int fuel){
        this();
        setFuel(fuel);
    }
    
    /**
     * Constructor con 3 parámetros, uno para cada atributo
     * @param pilot piloto del avión
     * @param identifier identificador del avión
     * @param fuel cantidad de combustible (en litros) del avión
    */
    public Plane(Person pilot, char identifier, int fuel){
        this();
        this.setPilot(pilot);
        this.setIdentifier(identifier);
        this.setFuel(fuel);
        this.setLandingGear(new LandingGear());
    }
    
    private void setLandingGear(LandingGear lg){
        checkParam(lg!=null, "El tren de aterrizaje debe existir");
        this.landingGear = lg;
    }
    
    public LandingGear getLandingGear(){
        return this.landingGear;
    }
    
    private void setColumn(int column){
        checkParam(column>0, "La columna debe existir y ser >=1");
        this.column = column;
    }
    
    /**
     * Recibir cantidad de columnas
     */
    public int getColumn(int n){
        return this.column;
    }
    
    private void setRow(int row){
        checkParam(row>0, "La fila debe existir y ser >=1");
        this.row = row;
    }
    
    /**
     * Recibir cantidad de filas
     */
    public int getRow(int n){
        return this.row;
    }
    
    private void setPilot(Person pilot){
        this.pilot = pilot;
    }
    
    /**
     * Recibir nombre de la persona
     */
    public Person getPilot(){
        return this.pilot;
    }
    
    private void setIdentifier(char identifier){
        checkParam(identifier >= MIN_IDENTIFIER && identifier <= MAX_IDENTIFIER, "Identificador fuera del rango");
        this.identifier = identifier;
    }
    
    /**
     * Recibir identificador
     */
    public char getIdentifier(){
        return this.identifier;
    }
    
    private void setFuel(int fuel){
        checkParam(fuel >= MIN_FUEL && fuel <= MAX_FUEL, "Combustible fuera de rango");
        this.fuel = fuel;
    }
    
    /**
     * Recibir valor de gasolina
     */
    public int getFuel(){
        return this.fuel;
    }
    
    private void checkParam(boolean condition, String msg){
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Método getDataPilot que devolverá NO PILOT en el caso de que no haya piloto.
     * En caso de que si haya piloto, devolvera la información contenida en el getHashCode 
     */
    private String getDataPilot()
    {
        if(pilot != null){
            return pilot.getHashCode();
        } else {
            return "NO PILOT";
        }
    }
    
    /**
     * Método que en el caso de haber combustible reducirá 1 valor al combustible
     * devolviendo true e indicando que el avión podrá volar
     */
    public boolean fly()
    {
        if(fuel > MIN_FUEL){
            if (getPositionFromX() + getSpeedFromX() >= MAX_X){
                setPositionFromX(getPositionFromX());
            }
            else{
                setPositionFromX(getPositionFromX() + getSpeedFromX());
            }
            if (getPositionFromY() + getSpeedFromY() >= MAX_Y){
                setPositionFromY(getPositionFromY());
            }
            else{
                setPositionFromY(getPositionFromY() + getSpeedFromY());
            }
            setFuel(getFuel() - 1);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Método toString que devuelve el valor del identificador, de la gasolina y aplica el método del getHashCode
     * separado por guiones
     */
    public String toString(){
        return getIdentifier() + "-" + getFuel() + "-" + getDataPilot() +
        "-(" + getPositionFromX() + "," + getPositionFromY() + ")-(" + 
        getSpeedFromX() + "," + getSpeedFromY() + ")";
    }
    
    private void setPositionFromX(int xPos)
    {
        checkParam(xPos >= MIN_X && xPos <= MAX_X, "Posición del eje X fuera del rango");
        this.xPos = xPos;
    }
    
    /**
     * Método que devuelve la posición X del avión
     */
    public int getPositionFromX()
    {
        return this.xPos;
    }
    
    private void setPositionFromY(int yPos)
    {
        checkParam(xPos >= MIN_Y && xPos <= MAX_Y, "Posición del eje Y fuera del rango");
        this.yPos = yPos;
    }
    
    /**
     * Método que devuelve la posición Y del avión
     */
    public int getPositionFromY()
    {
        return this.yPos;
    }
    
    private void setSpeedFromX(int xSpeed)
    {
        checkParam(xSpeed >= MIN_XSPEED && xSpeed <= MAX_XSPEED, "Velocidad del eje X fuera del rango");         
        this.xSpeed = xSpeed;
    }
    
    /**
     * Método que devuelve la velocidad X del avión
     */
    public int getSpeedFromX()
    {
        return this.xSpeed;
    }
    
    private void setSpeedFromY(int ySpeed)
    {
        checkParam(ySpeed >= MIN_YSPEED && ySpeed <= MAX_YSPEED,"Velocidad del eje Y fuera del rango");
        this.ySpeed = ySpeed;
    }
    
    /**
     * Método que devuelve la velocidad Y del avión
     */
    public int getSpeedFromY()
    {
        return this.ySpeed;
    }
    
    /**
     * Pedirá la velocidad del avión tanto en el eje X como en el Y
     */
    public void accelerate(int xSpeed, int ySpeed){
        if (xSpeed >= MIN_XSPEED && xSpeed <= MAX_XSPEED && ySpeed >= MIN_YSPEED && ySpeed <= MAX_YSPEED){
            getSpeedFromX();
            getSpeedFromY();
        }    
    }
    
    /**
     * Método bookSeat que permite o no sentar a una persona en el avión.
     * Si consigue sentar a la persona, devolverá true, en caso contrario, false.
     * @param person Persona que se va a sentar
     * @param row Número de la fila de asientos
     * @param column Número de la columna de asientos
     */
    public boolean bookSeat(Person person, int row, int column){
        checkParam(person != null, "La persona debe existir"); 
        checkParam(row<=8 && row >=0, "Debe haber, al menos, 1 fila; y como máximo, 8"); 
        checkParam(column<=6 && column >=0, "Debe haber, al menos, 1 columna; y como máximo, 8"); 
        if (seats[row][column] == null){
            seats[row][column] = person;
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Método releaseSeat que nos permite dejar un asiento libre, si está ocupado, devuelve
     * el objeto que ocupaba el asiento
     * @param row Número de la fila de asientos
     * @param column Número de la columna de asientos
     */
    public Person releaseSeat(int row, int column){
        checkParam(row<=8 && row >=0, "Debe haber, al menos, 1 fila; y como máximo, 8"); 
        checkParam(column<=6 && column >=0, "Debe haber, al menos, 1 columna; y como máximo, 8"); 
        if (seats[row][column] == null){
            throw new RuntimeException("No hay nadie en el asiento, puede sentarse");
        } else{
            Person person = seats[row][column];
            seats[row][column] = null;
            return person;
        }
    }
    
    /**
     * Método print que enseña el estado de los asientos del avión. (X --> adulto, C --> niño,
     * ? --> asiento libre)
     */
    public void print(){
        for (int i = 0; i<row; i++){
            System.out.println("  0 1 2 3 4 5");
            System.out.println("0 ");
            System.out.println("1 ");
            System.out.println("2 ");
            System.out.println("3 ");
            System.out.println("4 ");
            System.out.println("5 ");
            System.out.println("6 ");
            System.out.println("7 " +i);
            this.getRow(i); 
        }
        for (int i = 0; i<column; i++){
            System.out.println("  0 1 2 3 4 5");
            System.out.println("0 ");
            System.out.println("1 ");
            System.out.println("2 ");
            System.out.println("3 ");
            System.out.println("4 ");
            System.out.println("5 ");
            System.out.println("6 ");
            System.out.println("7 " +i);
            this.getColumn(i); 
        }
    }
}