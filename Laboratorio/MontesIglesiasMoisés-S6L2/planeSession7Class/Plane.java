
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
    public final static int MIN_X = 10;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano Y
     */
    public final static int MAX_Y = 10;
    
    /**
     * Valor máximo de la coordenada que ocupa el avión en el plano Y
     */
    public final static int MIN_Y = 10;
    
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
        setSpeedFromX(MAX_XSPEED);
        setSpeedFromY(MIN_YSPEED);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el piloto
     * @param pilot Piloto del avión
     */
    public Plane(Person pilot){
        this();
        setPilot(pilot);
        setSpeedFromX(MAX_XSPEED);
        setSpeedFromY(MIN_YSPEED);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el identificador
     * @param pilot Piloto del avión
     */
    public Plane(char identifier){
        this();
        setIdentifier(identifier);
        setSpeedFromX(MAX_XSPEED);
        setSpeedFromY(MIN_YSPEED);
    }
    
    /**
     * Constructor con valores por defecto para todos los atributos, salvo el combustible
     * @param pilot Piloto del avión
     */
    public Plane(int fuel){
        this();
        setFuel(fuel);
        setSpeedFromX(MAX_XSPEED);
        setSpeedFromY(MIN_YSPEED);
    }
    
    /**
     * Constructor con 3 parámetros, uno para cada atributo
     * @param pilot piloto del avión
     * @param identifier identificador del avión
     * @param fuel cantidad de combustible (en litros) del avión
    */
    public Plane(Person pilot, char identifier, int fuel){
        this();
        setPilot(pilot);
        setIdentifier(identifier);
        setFuel(fuel);
        setSpeedFromX(MAX_XSPEED);
        setSpeedFromY(MIN_YSPEED);
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
    
    public void setIdentifier(char identifier){
        checkParam(identifier >= MIN_IDENTIFIER && identifier <= MAX_IDENTIFIER, "Identificador fuera del rango");
        this.identifier = identifier;
    }
    
    /**
     * Recibir identificador
     */
    public char getIdentifier(){
        return this.identifier;
    }
    
    public void setFuel(int fuel){
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
        if (condition == false) {
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
            setFuel(getFuel() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Método toString que devuelve el valor del identificador, de la gasolina y aplica el método del getHashCode
     * separado por guiones
     */
    public String toString(){
        return getIdentifier() + "-" + getFuel() + "-" + pilot.getHashCode();
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
    
    /**
     * Pedirá la velocidad en el eje X
     */
    public void setSpeedFromX(int xSpeed)
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
    
    /**
     * Pedirá la velocidad en el eje Y
     */
    public void setSpeedFromY(int ySpeed)
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
    public void accelerate(int setSpeedFromX, int setSpeedFromY){
        this.getSpeedFromX();
        this.getSpeedFromY();
    }
}