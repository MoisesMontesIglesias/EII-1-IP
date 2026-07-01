
/**
 * Write a description of class Figure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figure
{
    private String name;
    private int xPos;
    private int yPos;
    private char movement;
    
    /**
     * Constante para borde inferior en el eje X
     */
    public final static int X_LOWER_EDGE = 0;
    
    /**
     * Constante para borde inferior en el eje Y
     */
    public final static int Y_LOWER_EDGE = 0;
        
    /**
     * Constante para borde superior en el eje X
     */
    public final static int X_UPPER_EDGE = 640;
        
    /**
     * Constante para borde superior en el eje Y
     */
    public final static int Y_UPPER_EDGE = 320;
    
    /**
     * Constante para el movimiento hacia la izquierda
     */
    public final static char LEFT = 'L';
        
    /**
     * Constante para el movimiento hacia la derecha
     */
    public final static char RIGHT = 'R';
        
    /**
     * Constante para el movimiento hacia arriba
     */
    public final static char UP = 'U';
    /**
     * Constante para el movimiento hacia abajo
     */
    public final static char DOWN = 'D';
    
    /**
     * Constante que representa la distancia en píxeles
     */
    public final static int STEP = 10;
    
    /**
     * Monstruo
     */
    public Figure(){
        setName("Monstruo");
        setXPos(X_LOWER_EDGE);
        setYPos(Y_LOWER_EDGE);
    }
    
    /**
     * Constructor solicitando todos los parámetros
     */
    public Figure(String name, int xPos, int yPos){
        setName(name);
        setXPos(xPos);
        setYPos(yPos);
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    /**
     * Muestra el nombre recibidp
     */
    public String getName(){
        return this.name;
    }
    
    private void setXPos(int xPos){
        checkParam(xPos >= X_LOWER_EDGE && xPos <= X_UPPER_EDGE, 
        "Posición fuera de pantalla");
        this.xPos = xPos;
    }
    
    /**
     * Muestra la posición en el eje X
     */
    public int getXPos(){
        return this.xPos;
    }
    
    private void setYPos(int yPos){
        checkParam(yPos >= Y_LOWER_EDGE && yPos <= Y_UPPER_EDGE, 
        "Posición fuera de pantalla");
        this.yPos = yPos;
    }
    
    /**
     * Muestra la posición en el eje Y
     */
    public int getYPos(){
        return this.yPos;
    }
    
    private void setMovement(char movement){
        this.movement = movement;
    }
    
    /**
     * 
     */
    public char getMovement(){
        return movement;
    }
    // /**
     // * Método move con un parámetro que indica la dirección del movimiento
     // * del personaje
     // */
    // public String move(int STEP)
    // {
        // if (STEP >= Y_LOWER_EDGE && STEP<=Y_UPPER_EDGE){
            // if (xPos == LEFT){
                // setXPos(getXPos()-STEP);
            // }
            // else{
                // setXPos(getXPos()+STEP);
            // }
            // if (yPos == UP){
                // setYPos(getYPos()+STEP);
            // }
            // else{
                // setYPos(getYPos()-STEP);
            // }
            // return "(" + xPos + "," + yPos + ")";
        // }
        // else{
            // return "(" + xPos + "," + yPos + ")";
        // }
    // }
    
    /**
     * Método move con un parámetro que indica la dirección
     * del movimiento del personaje
    */
    public void move(){
        if (getXPos() + STEP<= X_UPPER_EDGE && getYPos()+STEP <= Y_UPPER_EDGE){
            if (getXPos() == 'L'){
                setXPos(getXPos() - STEP);
            }
            else{
                setXPos(getXPos() + STEP);
            }
            if (getYPos() == 'U'){
                setYPos(getYPos() + STEP);
            }
            else{
                setYPos(getYPos() - STEP);
            }
        }
        else{
            setXPos(getXPos());
            setYPos(getYPos());
        }
    }
    
    /**
     * Devuelve el nombre del personaje, su posición en el eje X y en el eje Y
     */
    public String toString(){
        return getName() + " se encuentra en " + getXPos() + " , " + getYPos();
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}