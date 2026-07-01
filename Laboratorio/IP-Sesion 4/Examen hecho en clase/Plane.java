
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
     * El género masculino devolverá el booleano verdadero
     */
    public final static boolean GENDER_MALE = true;
    
    /**
     * El género femenino devolverá el booleano falso
     */
    public final static boolean GENDER_FEMALE = false;
    
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
        setPilot(pilot);
        setIdentifier(identifier);
        setFuel(fuel);
    }
    
    /**
     * Recibir nombre del piloto, el cual si cumple las condiciones, guardará el nombre dado,
     * y si no lo hace, devolverá un error indicando que ese piloto de avión no cumple los 
     * requisitos.
     */
    public void setPilot(Person pilot){
        if (pilot == null){
            this.pilot = pilot;   
        }
        if (pilot.canBePilot()){
            this.pilot = pilot;
        }
        else{
            throw new IllegalArgumentException(pilot.getName()
            + " no puede ser piloto de este avión");
        }
    }
    
    /**
     * Recibir nombre de la persona
     */
    public Person getPilot(){
        return this.pilot;
    }
    
    /**
     * Recibir identificador, el cual debe encontrarse entre la A y la Z, sino devolverá un error
     */
    public void setIdentifier(char identifier){
        checkParam(identifier >= 'A' && identifier <= 'Z', "Identificador fuera del rango");
        this.identifier = identifier;
    }
    
    /**
     * Devolver identificador
     */
    public char getIdentifier(){
        return this.identifier;
    }
    
    /**
     * Recibir valor de fasolina
     */
    public void setFuel(int fuel){
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