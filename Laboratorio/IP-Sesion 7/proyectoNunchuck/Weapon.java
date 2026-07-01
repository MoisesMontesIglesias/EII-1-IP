
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon
{
    private String name;
    private int ammunition;
    /**
     * Constructor con parámetros por defecto
     */
    public Weapon()
    {
        setName("Pistola");
        setAmmunition(100);
    }
    
    /**
     * Constructor que necesita que le den el nombre y munición del arma
     */
    public Weapon(String name, int ammunition)
    {
        setName(name);
        setAmmunition(ammunition);
    }
    
    private void setName(String name){
        checkParam(name!=null && name!= "", "El nombre no puede ser null");
        this.name = name;
    }
    
    /**
     * Muestra el nombre recibido
     */
    public String getName(){
        return this.name;
    }
    
    private void setAmmunition(int ammunition){
        this.ammunition = ammunition;
    }
    
    /**
     * Muestra la munición que se tiene
     */
    public int getAmmunition(){
        return this.ammunition;
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    public String trim(){
        if(name != null){
            return getName().trim();
        } else {
            return "null o cadena vacía";
        }
    }
    
    /**
     * Si tiene munición, reduce en 1 la cantidad y devuelve BANG, si no
     * tiene munición, no devuelve nada
     */
    public String shoot(){
        if (getAmmunition() > 0){
            setAmmunition(getAmmunition() - 1);
            return "BANG";
        }
        else{
            return "";
        }
    }
    
    /**
     * Devuelve el nombre del arma y la munición que tiene
     */
    public String toString(){
        return getName() + " tiene de munición " + getAmmunition() + " balas";
    }
}

