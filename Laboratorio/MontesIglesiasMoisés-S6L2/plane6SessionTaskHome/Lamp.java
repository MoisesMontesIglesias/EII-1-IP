
/**
 * Write a description of class Lamp here.
 * 
 * @author (Moisés Montes Iglesias) 
 * @version (23-10-2022)
 */
public class Lamp
{
    private boolean lamp;
    public final static boolean LAMP_ON = true;
    public final static boolean LAMP_OFF = false;
    public final static boolean DEFAULT_LAMP = true;
    /**
     * Constructor de una bombilla que pide al usuario saber 
     * si está encendida o apagada.
     */
    public Lamp(boolean lamp){
        this.setLamp(lamp);
    }
    
    /**
     * Constructor de una bombilla por defecto
     */
    public Lamp(){
        this.setLamp(DEFAULT_LAMP);
    }
    
    /**
     * Solicita el valor del estado de la lámpara
     */
    public void setLamp(boolean lamp){
        this.lamp = lamp;
    }
    
    /**
     * Recibe el valor del estado de la lámpara
     */
    public boolean getLamp(){
        return this.lamp;
    }
    
    /**
     * Método que cambiará el estado de la lampara
     * apagado --> encendido
     */
    public void turnOn(){
        if (getLamp()){
            setLamp(LAMP_OFF);
        }
        else{
            setLamp(LAMP_ON);
        }
    }
    
    /**
     * Método que cambiará el estado de la lampara
     * encendido --> apagado
     */
    public void turnOff(){
        if (getLamp()){
            setLamp(LAMP_ON);

        }
        else{
            setLamp(LAMP_OFF);
        }
    }
    
    /**
     * Método que devuelve "ENCENDIDA" si la lámpara tiene el valor 
     * booleano true, o devolverá "APAGADA" si tiene el valor 
     * booleano false
     */
    public String toString(){
        if (getLamp() == DEFAULT_LAMP){
            return "ENCENDIDA";
        }
        else{
            return "APAGADA";
        }
    }
    
    private void checkParam(boolean condition, String msg){//En caso de una edad negativa
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }

}

