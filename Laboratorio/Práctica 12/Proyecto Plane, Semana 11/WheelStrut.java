import java.util.ArrayList;

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
    
    private Wheel [] wheels;
    private boolean deployed;       // true si el puntal está desplegado
    Wheel w;
    /**
     * Constructor cuyas ruedas tienen la presión del BOEING-737
     */
    public WheelStrut(int  numberOfWheels){
        checkParam(numberOfWheels>0, "El puntal tiene que tener ruedas");
        this.wheels=new Wheel[numberOfWheels];
        for (int i = 0; i<numberOfWheels; i++){
            wheels[i] = (new Wheel(BOEING_737_PRESSURE, BOEING_737_PRESSURE));
        }
        setDeployed(IS_DEPLOYED);
    }
    
    /**
     * Devuelve la rueda i-ésima del puntal
     * @param n Número de rueda a devolver
     * @param la rueda número n
     */
    public Wheel getWheel(int n){
        checkParam(n>=0 && n<numberOfWheels(), "Número de rueda inválido");
        return this.wheels[n];
    }
    
    public int numberOfWheels(){
        return this.wheels.length;
    }
    
    /**
     * Constructor que tendrá una presión determinada en las ruedas
     */
    public WheelStrut(boolean deployed, Wheel RightWheel, Wheel LeftWheel){
        setDeployed(deployed);
    }
          
    /**
     * Modifica el valor del atributo deployed
     * @param deployed, valor verdadero si el puntal está desplegado
     */
    private void setDeployed(boolean deployed)  {
       this.deployed = deployed;
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
        //return this.getWheel(0).test() && this.getWheel(1).test() && this.getWheel(2).test()...;
        for (Wheel w: wheels){
            if(w.test() == false){
                return false;
            }
        }
        return true;
    }
    
    /**
    * @return estado del puntal con el siguiente formato, en tipo String
    * Deployed: true - Test: true [L:true] [R: true]
    */
    public String toString() {
        //return "Deployed: " + isDeployed() + " - " + "Test: " + test();
        String s1 = String.format("Deployed: %b - Test: %b",
                                    this.isDeployed(),
                                    this.test());
        String s2 = "";
        for (int i = 0; i <numberOfWheels(); i++){
            s2 = s2+String.format(" [%d: %b]",
                            i,
                            this.getWheel(i).test());
        }
        return s1+s2;
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
    public void print() {
        Wheel w;
        System.out.println(isDeployed());
        System.out.println("Test..............." + test());
        for (int i = 0; i<numberOfWheels(); i++){
            System.out.println("Wheel Number " +i);
            this.getWheel(i).print(); 
        }
        // System.out.println("LEFT Wheel");
        // System.out.println("Presión máxima......." + leftWheel.getMaxPressure() + " Mb ");
        // System.out.println("Presión actual..." + leftWheel.getPressure() + "Mb" + 
        // " (" + leftWheel.getPercentage() + "%)");
        // System.out.println("Test............." + (leftWheel.test()?"OK":"FAIL"));
        // System.out.println("RIGHT Wheel");
        // System.out.println("Presión máxima......." + rightWheel.getMaxPressure() + " Mb ");
        // System.out.println("Presión actual ........" + rightWheel.getPressure() + " Mb " + 
        // " (" + rightWheel.getPercentage() + "%) ");
        // System.out.println("Test...................." + (rightWheel.test()?"OK":"FAIL"));
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
        this.setDeployed(!IS_DEPLOYED);
    }
    
    private void checkParam(boolean condition, String msg){
        if (!condition) {
            throw new IllegalArgumentException(msg);
        }
    }
    
}

