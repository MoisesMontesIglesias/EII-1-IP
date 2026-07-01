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
    private Wheel basePressure;
    
    /**
     * Constructor for objects of class LandingGear
     * Palanca posición baja y los tres puntales desplegados
     */
    public LandingGear()
    {
        setLever(LEVER_DOWN);
        setLeft(new WheelStrut(4));
        setRight(new WheelStrut(4));
        setNose(new WheelStrut(2));
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

    private void setLever(boolean newLever){
        this.lever = newLever;
    }
    
    /**
     * 
     */
    public boolean getLever(){
        return this.lever;
    }
    
    private void setLeft(WheelStrut newLeft){
        checkParam(newLeft!=null,"El puntal izquierdo debe existir");
        this.left = newLeft;
    }
    
    /**
     * 
    */
    public WheelStrut getLeft(){
        return this.left;
    }
    
    private void setRight(WheelStrut newRight){
        checkParam(newRight!=null,"El puntal izquierdo debe existir");
        this.right = newRight;
    }
    
    /**
     * 
    */
    public WheelStrut getRight(){
        return this.right;
    }
    
    private void setNose(WheelStrut newNose){
        checkParam(newNose!=null,"El puntal izquierdo debe existir");
        this.nose = newNose;
    }
    
    /**
     * 
    */
    public WheelStrut getNose(){
        return this.nose;
    }
    
    /**
     * 
     */
    public void moveLever(boolean lever){
        setLever(lever);
        if (getLever() == LEVER_UP){
            left.retract();
            right.retract();
            nose.retract();
        } else{
            left.deploy();
            right.deploy();
            nose.deploy();
        }
    }
    
    /**
     * 
     */
    public boolean test(){
        if (getLeft().test() == true && getRight().test() == true && getNose().test() == true){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * 
     */
    public void print(){
        System.out.println("Lever.............. " + getLever());
        System.out.println("Test............... " + changeTest());
        System.out.println(changeLever());
        System.out.println("      " + changeNose());
        System.out.println(changeLeft() + "        " + changeRight());
    }
    
    private String changeTest(){
        if (test() == true){
            return "OK";
        } else{
            return "FAIL";
        }
    }
    
    private String changeLever(){
        if (getLever() == true){
            return "ON";
        } else{
            return "OFF";
        }
    }
    
    private String changeLeft(){
        if (left.test() == true){
            return "ON";
        } else{
            return "OFF";
        }
    }
    
    private String changeRight(){
        if (right.test() == true){
            return "ON";
        } else{
            return "OFF";
        }
    }
    
    private String changeNose(){
        if (nose.test() == true){
            return "ON";
        } else{
            return "OFF";
        }
    }
    
    public String toString(){
        // String result = String.format("Lever: %s    Status: %s    Nose: %s    Left:%s    Right: %s",
                                      // leverToString(),
                                      // testToString(),
                                      // wheelStrutTestToString2(nose),
                                      // wheelStrutTestToString2(left),
                                      // wheelStrutTestToString2(right));
        return "Lever: " + leverToString() + "    Status: " + testToString() + 
        "    Nose: " + WSTest(nose) + "    Left: " + WSToString(left) + 
        "    Right: " + WSToString(right);
    }
    
    private String leverToString(){
        if (getLever() == true){
            return UP;
        } else{
            return DOWN;
        }
    }
    
    private String testToString(){
        if (test() == true){
            return OK;
        } else {
            return FAIL;
        }
    }
    
    private String WSTest(WheelStrut wheelStrut){
        if (wheelStrut.test() == true){
            return ON;
        } else{
            return OFF;
        }
    }
    
    private String WSToString(WheelStrut wheelStrut){
        if (wheelStrut.getWheel(0).test() && wheelStrut.getWheel(1).test()){
            if (wheelStrut.isDeployed()){
                return ON;
            } else{
                return OFF;
            }
        } else{
            return PRESS;
        }
    }
    
    private void checkParam(boolean condition, String msg){
        if (!condition){
            throw new IllegalArgumentException(msg);
        }
    }
}