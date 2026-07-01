/**
 * Tren de aterrizaje con palanca y 3 puntales
 * dos a izquierda y derecha y uno en el morro
 * 
 * @author 
 * @version 
 */
public class LandingGear
{
    public static final boolean LEVER_UP = true;
    public static final boolean LEVER_DOWN = false;
    
    public static final String OK = "OK";
    public static final String FAIL = "FAIL";
    
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    
    public static final String ON = "ON";
    public static final String OFF = "OFF";
    public static final String PRESS = "PRESS";
    
    private boolean lever;           // palanca del tren de aterrizaje
    private WheelStrut left;         // puntal izquierdo
    private WheelStrut right;        // puntal derecho
    private WheelStrut nose;         // puntal del morro
    
    
    /**
     * Constructor for objects of class LandingGear
     * Palanca posición baja y los tres puntales desplegados
     */
    public LandingGear()
    {
        setLever(LEVER_DOWN);
        setLeft(new WheelStrut());
        setRight(new WheelStrut());
        setNose(new WheelStrut());
        //Esto no es muy necesario pero esta bien igualmente
        left.deploy();
        right.deploy();
        nose.deploy();
    }
    
    /**
     * Constructor con tres parámetros
     * 
     * @param puntal izquierdo
     * @param puntal derecho
     * @param puntal del morro
     * Palanca en posición baja y los tres puntales desplegados
     * 
     */
    public LandingGear(WheelStrut left, WheelStrut right, WheelStrut nose)
    {
        this();
        setLever(LandingGear.LEVER_DOWN);
        setLeft(left);
        setRight(right);
        setNose(nose);
        //En estos casos es necesario
        left.deploy();
        right.deploy();
        nose.deploy();
    }

    /**
     * Modifica el valor del atributo lever
     * 
     * @param  newLever, nuevo valor para la palanca
     * 
     */
    private void setLever(boolean newLever)
    {
        this.lever = newLever;
    }
    
    /**
     * Modifica el valor del atributo left
     * 
     * @param  newLeft, nuevo valor para el puntal izquierdo
     * 
     */
    private void setLeft(WheelStrut newLeft)
    {
        checkParam(newLeft!=null, "Esperaba puntal izquierdo en lugar de null");
        this.left = newLeft;
    }
    
    /**
     * Modifica el valor del atributo right
     * 
     * @param  newRight, nuevo valor para el puntal derecho
     * 
     */
    private void setRight(WheelStrut newRight)
    {
        checkParam(newRight!=null, "Esperaba puntal derecho en lugar de null");
        this.right = newRight;
    }
    
    private void setNose(WheelStrut newNose)
    {
        checkParam(newNose != null, "Esperaba puntal morro en lugar de null");
        nose = newNose;
    }
    
    /**
     * @return valor de la palanca
     */
    public boolean getLever() {
        return this.lever;
    }
    
    /**
     * @return valor del puntal izquierdo
     */
    public WheelStrut getLeft() {
        return this.left;
    }
    
    /**
     * @return valor del puntal derecho
     */
    public WheelStrut getRight() {
        return this.right;
    }
    
    /**
     * @return valor del puntal izquierdo
     */
    public WheelStrut getNose() {
        return nose;
    }
    
    /**
     * Mueve la palanca
     * Si la mueve hacia arriba implica subier el tren de aterrizaje, es decir
     * los puntales se repliegan
     * Si la mueve hacia abajo los puntales se despliegan
     */
    public void moveLever (boolean action) {
        setLever(action);
        if(lever == LEVER_UP){
            getLeft().retract();
            getRight().retract();
            getNose().retract();
        } else{
            getLeft().deploy();
            getRight().deploy();
            getNose().deploy();
        }
    }
    
    /**
     * Validación de parámetro
     * @param condición
     * @param mensaje
     */
    private void checkParam(boolean condition, String cause) {
        if (! condition) {
            throw new IllegalArgumentException(cause);
        }
    }
    
    /**
     * Método test que devuelve true si todos los puntales están despegados
     * y devuelve false si están sin desplegar
     */
    public boolean test(){
        if( left.test()==true && right.test()==true && nose.test()==true){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Método print que imprime por pantalla los siguientes datos:
     * Posición de la palanca.
     * Resultado de ejecutar el test sobre el tren de aterrizaje.
     * FAIL si el método test() del puntal devuelve false; OK en caso contrario
     * ON si el puntal está desplegado; OFF en otro caso (para cada puntal).
     * Las etiquetas a usar serán declaradas como constantes.
     * Con un aspecto final como el que sigue:
     * Lever.............. DOWN (o UP)
     * Test............... FAIL
     *       ON
     * OFF        ON
     */
    public void print(){
        System.out.println("Lever.............." + getLever());
        System.out.println("Test..............." + changeTest());
        System.out.println(changeLever());
        System.out.println("            " + changeNose());
        System.out.println(changeLeft() + "             " + changeRight());
    }
    
    private String changeTest(){
        if (test()==true){
            return "OK"; 
        }else{
            return "FAIL";
        }
    }
    
    private String changeLever(){
        if(getLever()==LEVER_UP){
            return "UP";
        }else{
            return "DOWN";
        }
    } 
    
    private String changeLeft(){
        if (left.test() == true){
            return "ON";
        }else{
            return "OFF";
        }
    }
    
    private String changeRight(){
        if (right.test() == true){
            return "ON";
        }else{
            return "OFF";
        }
    }
    
    private String changeNose(){
        if (nose.test() == true){
            return "ON";
        }else{
            return "OFF";
        }
    }
    
    /**
     * 
     */
    public String toString(){
        String result = String.format("Lever: %s    Status: %s      Nose: %s        Left: %s        Right: %s",
                                      leverToString(),
                                      testToString(),
                                      wheelStrutTestToString2(nose),
                                      wheelStrutTestToString2(left),
                                      wheelStrutTestToString2(right));
        return result;
    }
    
    private String leverToString()   
    {
        if(lever == LEVER_UP) {
            return UP;
        } else {
            return DOWN;
        }
    }
    
    private String testToString()   
    {
        if(test()) {
            return OK;
        } else {
            return FAIL;
        }
    }
    
    
    private String wheelStrutTestToString(WheelStrut wheelStrut)
    {
        if (wheelStrut.test()) {
            return ON;
        } else {
            return OFF;
        }
    }
    
   
    private String wheelStrutTestToString2(WheelStrut wheelStrut)
    {
        if(wheelStrut.getRightWheel().test() && wheelStrut.getLeftWheel().test()) {
            if (wheelStrut.isDeployed()) {
                return ON;
            } else {
                return OFF;
            }
        } else {
            return PRESS;
        }
    }
}  