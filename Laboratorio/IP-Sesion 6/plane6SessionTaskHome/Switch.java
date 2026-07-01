
/**
 * Write a description of class Switch here.
 * 
 * @author (Moisés Montes Iglesias) 
 * @version (23-10-2022)
 */
public class Switch 
{
    private boolean switchPanel;
    public static final boolean SP_ON = true;
    public static final boolean SP_OFF = false;
    public static final boolean DEFAULT_SWITCH_PANEL = true;
    
    /**
     * Constructor de un interruptor dando valor true or false
     */
    public Switch(boolean switchPanel){
        this.setSwitchPanel(switchPanel);
    }
    
    /**
     * Constructor de un interruptor por defecto
     */
    public Switch(){
        this.setSwitchPanel(DEFAULT_SWITCH_PANEL);
    }
    
    /**
     * Solicita el valor del estado del interruptor
     */
    public void setSwitchPanel(boolean switchPanel){
        this.switchPanel = switchPanel;
    }
    
    /**
     * Recibe el valor del estado del interruptor
     */
    public boolean getSwitchPanel(){
        return this.switchPanel;
    }
    
    /**
     * Método que cambiará el estado del interruptor
     * apagado --> encendido / encendido --> apagado
     */
    public void press(){
        if (getSwitchPanel()){
            setSwitchPanel(SP_OFF);
        }
        else{
            setSwitchPanel(SP_ON);
        }
    }
    
    /**
     * Método que devuelve "ON" si la lámpara tiene el valor 
     * booleano true, o devolverá "OFF" si tiene el valor 
     * booleano false
     */
    public String toString(){
        if (getSwitchPanel() == DEFAULT_SWITCH_PANEL){
            return "ON";
        }
        else{
            return "OFF";
        }
    }
    
    private void checkParam(boolean condition, String msg){//En caso de una edad negativa
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }

}
