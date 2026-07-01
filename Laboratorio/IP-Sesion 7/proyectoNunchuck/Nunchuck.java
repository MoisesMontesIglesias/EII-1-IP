
/**
 * Write a description of class Nunchuck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nunchuck
{
    Figure f;
    Weapon w;

    /**
     * Constructor con parámetros predefinidos
     */
    public Nunchuck()
    {
        f.setName("Monstruo");
        f.setXPos(0);
        f.setYPos(0);
        w.setName("Pistola");
        w.setAmmunition(100);
    }
    
    /**
     * Constructor sin parámetros
     */
    public Nunchuck()
    {
        f.setName(Figure.name);
        f.setXPos(Figure.xPos);
        f.setYPos(Figure.yPos);
        w.setName(Weapon.name);
        w.setAmmunition(Weapon.ammunition);
    }
}
