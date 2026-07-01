
/**
 * Definición de las ruedas del avión
 * 
 * @author Moisé Montes Iglesias 
 * @version 1.0
 * 18/10/2022
 */
public class Wheel
{
    // Constantes estáticas para la clase
    public static final int THRESHOLD = 85;     // umbral, porcentaje sobre la presión máxima por encima del cual la rueda está operativa
    
    public static final double STANDARD_MAX_PRESSURE = 1000;
    public static final double STANDARD_PRESSURE = 900;
    
    private double pressure;       // presión actual que tiene la rueda, de tipo double
    private double maxPressure;    // presión máxima que soporta la rueda, de tipo double
    /**
     * Constructor para crear rueda con valores standard
     */
    public Wheel()
    {
        setMaxPressure(STANDARD_MAX_PRESSURE);
        setPressure(STANDARD_PRESSURE);
    }
    
     /**
     * Constructor para crear la rueda con las presión que se desee
     * 
     * @param pressión máxima
     * @param presión actual
     */
    public Wheel(double maxPressure, double pressure)
    {
        this();
        setMaxPressure(maxPressure);
        setPressure(pressure);
    }

    /**
     * Método que modifica la presión máxima de la rueda
     * 
     * @param  nuevo valor para la presión máxima (>=0), de tipo double  
     *  
     */
    private void setMaxPressure(double maxPressure)
    {
        checkParam(maxPressure >= 0, "Valor incorrecto de la presión máxima");
        this.maxPressure = maxPressure;
    }
    
    /**
     * Método que modifica la presión actual
     * 
     * @param  nuevo valor para la presión actual entre [0,maxPressure], de tipo double
     *  
     */
    private void setPressure(double pressure)
    {
        checkParam(pressure >= 0 && pressure <= getMaxPressure(), "Valor incorrecto de la presión");
        this.pressure = pressure;
    }
    
    /**
     * Método que devuelve la presión máxima
     * 
     * @return presión máxima que puede soportar la rueda, de tipo double
     */
    public double getMaxPressure()
    {
        return this.maxPressure;
    }
    
    /**
    /**
     * Método que devuelve la presión actual
     * 
     * @return presión actual que puede soportar la rueda, de tipo double
     */
    public double getPressure()
    {
        return this.pressure;
    }
    
    /**
     * Método que comprueba si una rueda está o no operativa
     * Está operativa si su presión actual es mayor o igual que el 85% del la presión máxima
     * 
     * @return true si la rueda está operativa y false si no lo es
     */
    public boolean test()
    {
        if (getPercentage() >= THRESHOLD){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Devuelve el estado de la rueda con el siguiente formato:
     * MaxP: 20700,0 Mb - Pressure: 19300,0 Mb - Percentage: 93,24 - Test: true
     * 
     * @return estado de la rueda con el formato anterior
     */
    public String toString()
    {
        // usaremos  String.format para formatear números decimales
        return "MaxP: " + getMaxPressure() + " Mb - Pressure: " + getPressure() + 
        " Mb - Percentage: " + getPercentage() + " - Test: " + test();
        
        // return String.format("MaxP: %.1f Mb - Pressure: %.1f Mb - Percentage: %.2f - Test: %b",
                //this.getMaxPressure(),
                //this.getPressure(),
                //this.getPressure()/this.getMaxPressure()*100,
                //this.test());
    }
    
    /**
     * Imprime los datos de la rueda en el siguiente formato
     * 
     * Max Pressure....... 34500,0 Mb
     * Current Pressure... 32000,0 Mb (92,75%)
     * Test............... OK (FAIL, si falló el test).
     * 
     */
    public void print()
    {
        //System.out.println("Max Pressure " + getMaxPressure() + " Mb");
        //System.out.println("Current Pressure " + getPressure() + " Mb (" + getPercentage() + ")");
        //System.out.println("Test " + test());
        
        System.out.println(String.format("Max Pressure.......%5.1f Mb", getMaxPressure()));
        System.out.println(String.format("Current Pressure...%5.1f Mb(%.2f%%)", getPressure(), getPercentage()));
        System.out.println(String.format("Test...............%s", test()? "OK" : "FAIL"));
    }
    
    public double getPercentage(){
        return (getPressure()/getMaxPressure())*100;
    }
    
    private String testToString(){
        if (test() == true){
            return "Ok";
        }
        else{
            return "Fail";
        }
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}

