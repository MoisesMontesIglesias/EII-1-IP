
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int number;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String name, int number)
    {
        setName(name);
        setNumber(number);
    }
    
    private void setName(String name){
        checkParam(name!= null, "El nombre de la persona debe existir");
        this.name = name;
    }
    
    /**
     * Recibir el nombre del jugador
     */
    public String getName(){
        return this.name;
    }
    
    private void setNumber(int number){
        checkParam(number>0, "El jugador debe tener número y ser >=1");
        this.number = number;
    }
    
    /**
     * Recibir el número del jugador
     */
    public int getNumber(){
        return this.number;
    }
    
    /**
     * Devolverá el nombre del jugador y su respectivo número
     */
    public String toString(){
        return getName() + " - " + getNumber();    
    }
    
    private void checkParam(boolean condition, String msg){
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }
}
