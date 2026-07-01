
/**
 * Write a description of class ControlPanel here.
 * 
 * @author (Moisés Montes Iglesias) 
 * @version (23-10-2022)
 */
public class ControlPanel
{
    Switch s;
    Lamp l;
    /**
     * Constructor de un Panel de Control por defecto
     */
    public ControlPanel()
    {
        s = new Switch();
        l = new Lamp();
    }
    
    /**
     * Método, que mediante consola, muestra el estado completo del sistema
     */
    public void print(){
        System.out.println("=========== Estado del PANEL ===========");
        System.out.println("Interruptor: " +  s.toString());
        System.out.println("Bombilla: " +  l.toString());
    }
    
    /**
     * Método press que cambie la posición del interruptor
     * y encienda o apague la bombilla según su posición
     */
    public void press(){
        s.press();
        if (s.getSwitchPanel() == true){
            l.turnOff();
        }
        else{
            l.turnOn();
        }
    }
    
    private void checkParam(boolean condition, String msg){//En caso de una edad negativa
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}
