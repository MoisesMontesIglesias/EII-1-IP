
/**
 * Write a description of class Plain here.
 * 
 * @Moisés Montes Iglesias 
 * @04/10/2022
 */
public class Plane
{
    
    Person pilot;
    char identifier;
    int fuel;
    
    /**
     * Constructor con valores por defecto para todos los atributos
     */
    public Plane(){
        setPilot(null);
        setIdentifier('A');
        setFuel(0);
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
        checkParam(identifier >= 'A' && identifier <= 'Z', "Identificador fuera del rango");
        this.identifier = identifier;
    }
    
    /**
     * Recibir identificador
     */
    public char getIdentifier(){
        return this.identifier;
    }
    
    private void setFuel(int fuel){
        checkParam(fuel >= 0 && fuel <= 5000, "Combustible fuera de rango");
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
    
}