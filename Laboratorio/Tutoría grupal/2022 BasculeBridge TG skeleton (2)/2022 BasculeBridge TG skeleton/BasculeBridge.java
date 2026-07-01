
/**
 * Tutoría grupal I. Esquelto
 * Control de un puente levadizo a través de un controlador. 
 * La clase BasculeBridge representa un puente levadizo que puede moverse en un ángulo entre MIN_SLOPE y MAX_SLOPE a través
 * de las operaciones raiseBridge y dropBridge
 * 
 * @author ip-profes
 * @version 2022
 */
public class BasculeBridge
{
 
  /**
    * Inclinación mínima del puente
    */
   public static final int MIN_SLOPE = 0;
   /**
    * Inclinación máxima del puente
   */
   public static final int MAX_SLOPE = 60;
   
   /**
    * Inclinación por defecto del puente
   */
   public static final int DEFAULT_SLOPE = MIN_SLOPE;
   
   
   private int slope;        // inclinación del puente

   
     /**
     * Constructor por defecto
     */
    public BasculeBridge() {
        setSlope(DEFAULT_SLOPE);
    }
   
     /**
     * Constructor con un parámetro
     * @param angle valor entero para almacenar el ángulo [0º y 60º]
     */
    public BasculeBridge(int angle) {
        this();
        setSlope(angle);
    }
    
    /**
     * Modifica la inclinación del puente
     * 
     * @param newSlope valor entero, nuevo ángulo de inclinación
     * @throws IllegalArgumentException "Inclinación no válida" Si la inclinación no está en el rango válido
     */
    private void setSlope(int newSlope) {
        checkParam(newSlope>=MIN_SLOPE && newSlope<=MAX_SLOPE,"Inclinación no válida");
        slope = newSlope;
    }
    
    /**
     * @return valor entero correspondiente al atributo ángulo  
     */
    public int getSlope() {
        return slope;
    }
    
    /**
     *  Incrementa la posición en un valor igual al parámetro de entrada
     *  @param  increment valor entero positivo correspondiente al incremento de ángulo a realizar en la inclinación del puente  
     */
    public void raiseBridge(int increment) {
         checkParam(increment > 0, "Incremento debe ser positivo");
            setSlope(getSlope() + increment);
    }
    
    
     /**
     *  Decrementa la posición en un valor igual al parámetro de entrada
     *  @param decrement valor entero positivo correspondiente al decremento de ángulo que se realizará en la inclinación del puente 
     */
    public void dropBridge(int decrement) {
          checkParam (decrement > 0, "Decremento debe ser positivo");
                setSlope(getSlope() - decrement);
    }
    
    private void checkParam(boolean condition, String msg) {
        if (!condition)
          throw new IllegalArgumentException(msg);
    }
    
}
