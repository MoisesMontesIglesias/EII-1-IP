
/**
 * Clase para describir el puntal de un avión.
 * El puntal es parte del tren de aterrizaje y está compuesto por un soporte y dos ruedas. Puede estar desplegado o no.
 */

public class WheelStrut{
    /**
     * Valor para indicar que el puntal está desplegado
     */
    public static final boolean IS_DEPLOYED = true;
    /**
     * Presión por defecto del BOING-727, en Milibares
     */
    public static final double BOEING_737_PRESSURE = 1739; // en Mb
    
    private Wheel leftWheel;
    private Wheel rightWheel;
    private boolean deployed;       // true si el puntal está desplegado
    Wheel w;
    /**
     * Constructor cuyas ruedas tienen la presión del BOEING-737
     */
    public WheelStrut(){
        setRightWheel(new Wheel(BOEING_737_PRESSURE, BOEING_737_PRESSURE));
        setLeftWheel(new Wheel(BOEING_737_PRESSURE, BOEING_737_PRESSURE));
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Constructor cuyas ruedas tienen la presión del BOEING-737
     */
    public WheelStrut(Wheel RightWheel, Wheel LeftWheel){
        setRightWheel(rightWheel);
        setLeftWheel(leftWheel);
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Establece la rueda izquierda del puntal
     * @param wheel Rueda a establecer
     */
    private void setLeftWheel(Wheel wheel) {
        checkParam(wheel!=null, "La rueda tiene que existir");
        this.leftWheel = wheel;
    }
    
    /**
     * Establece la rueda dereca del puntal
     * @param wheel Rueda a establecer
     */
    private void setRightWheel(Wheel wheel) {
        checkParam(wheel!=null, "La rueda tiene que existir");
        this.rightWheel = wheel;
    }
          
    /**
     * Modifica el valor del atributo deployed
     * @param deployed, valor verdadero si el puntal está desplegado
     */
    private void setDeployed(boolean deployed)  {
       this.deployed = deployed;
    }
    
    /**
     * Devuelve la rueda izquierda del puntal
     * @return rueda izda del puntal
     */
    public Wheel getLeftWheel(){
        return this.leftWheel;
    }
    
    /**
     * Devuelve la rueda derecha del puntal
     * @return rueda decha del puntal
     */
    public Wheel getRightWheel(){
        return this.rightWheel;
    }
    
    /**
     * Devuelve el valor del atributo deployed
     * @return true o false si está o no desplegado el puntal
     */
    public boolean isDeployed(){ 
        return this.deployed;
    }
    
    /**
     * Método que devuelve true si ambas ruedas del puntan tienen suficiente presión
     * @return true si presión de las ruedas adecuada
     * 
     */
    public boolean test(){
        return this.getLeftWheel().test() && this.getRightWheel().test();
     }
     
    /**
    * @return estado del puntal con el siguiente formato, en tipo String
    * Deployed: true - Test: true [L:true] [R: true]
    */
    public String toString() {
        return "Deployed: " + isDeployed() + " - " + "Test: " + test();
    }
     
    /**
      * Método print que imprime los datos del puntal con el siguiente formato
      * Valor de deployed
      * Valor de test
      * resultado de ejecutar print sobre cada rueda
      * Ejemplo
      * RETRACTED (o DEPLOYED)
      * Test............... FAIL (o OK)
      * LEFT Wheel
      * Presión máxima....... 34500 Mb.
      * Presión actual... 32000 Mb (92.75%)
      * Test.............  OK 
      * RIGHT Wheel
      * Presión máxima....... 34500 Mb.
      * Presión actual ........ 5205 Mb (15.08%)
      * Test....................FAIL
      */
    public void print(boolean condition) {
        System.out.println(isDeployed());
        System.out.println(test());
        System.out.println(getLeftWheel());
        System.out.println(w.getMaxPressure());
        System.out.println(w.getPressure());
        System.out.println(test()== true);
        System.out.println(getRightWheel());
        System.out.println(w.getMaxPressure());
        System.out.println(w.getPressure());
        System.out.println(test()== false);
    }
            
    /**
     * Despliega el puntal
     */
    public void deploy(){
        this.setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Repliega el puntal
     */
    public void retract(){
        this.setDeployed(! IS_DEPLOYED);
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}

