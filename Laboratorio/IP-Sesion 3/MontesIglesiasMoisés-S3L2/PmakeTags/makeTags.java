
/**
 * Write a description of class makeTags here.
 * 
 * @author (Moisés Montes Iglesias) 
 * @version (02/10/2022)
 */
public class makeTags
{
    private int x;
    public String name;
    private void setName(String name){//Pide el nombre
        this.name = name;  
    }
    
    /**
     * Nombre de la persona
     */
    public String getName() {//Devuelve nombre
        return this.name;
    }
    
    /**
     * Constructor for objects of class makeTags
     */
    public makeTags()
    {
        // initialise instance variables
        x = 0;
    }
    public String makeTags(String tag, String word) {
        return "<"+tag+">"+word+"</"+tag+">";
    }
}
