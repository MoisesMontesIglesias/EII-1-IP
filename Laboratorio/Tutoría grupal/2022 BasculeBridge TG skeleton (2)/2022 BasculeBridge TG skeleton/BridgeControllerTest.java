

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BridgControlerTest.
 *
 * @author  mp-profes
 * @version 1-11-2022
 */
public class BridgeControllerTest
{
    /*
     * Constructor sin parámetros
     * Asigna puente a posición baja, palanca a posición baja
     * y embrague sin presión
     */
    @Test
    public void constructorWithoutParams(){
        
        
        // RELLENAR !!
    }
    
    /*
     * Constructor con parámetro lever 
     * 
     * casos
     * 1- Ĺever en posición inferior
     * 2- Lever en posición media
     * 3- Lever en posición superior
     * 
     * 4- Lever menor que inferior
     * 5- Lever mayor que superior
     * 
     */
    /**
     * Constructor con parámetro lever 
     * 
     * casos
     * 1- Ĺever en posición inferior
     */
    @Test
    public void ConstructorWithLeverDownPosition(){
        BridgeController bc = new BridgeController(BridgeController.LEVER_DOWN);
        
        assertEquals(! BridgeController.PRESSED, bc.getClutch());
        assertEquals(BridgeController.LEVER_DOWN, bc.getLever());
        assertNotNull(bc.getBridge());
        assertEquals(BasculeBridge.MIN_SLOPE, bc.getBridge().getSlope());    
    }
    
    /**
     * Constructor con parámetro lever 
     * 
     * casos
     * 2- Lever en posición media
    */
    @Test
    public void ConstructorWithLeverMiddlePosition(){
          // RELLENAR !!!!
    }
    
    /**
     * Constructor con parámetro lever 
     * 
     * casos
     * 3- Lever en posición superior
    */
    @Test
    public void ConstructorWithLeverUpPosition(){
        BridgeController bc = new BridgeController(BridgeController.LEVER_UP);
        
        assertEquals(! BridgeController.PRESSED, bc.getClutch());
        assertEquals(BridgeController.LEVER_UP, bc.getLever());
        assertNotNull(bc.getBridge());
        assertEquals(BasculeBridge.MAX_SLOPE,
                      bc.getBridge().getSlope());    
    }
    
    /**
     * Constructor con parámetro lever 
     * 
     * casos
     * 4- Lever menor que inferior
     * 
    */
    @Test
    public void ConstructorWithLeverLessDownPosition(){
        // RELLENAR !!
    }
    
    /**
     * Constructor con parámetro lever 
     * 
     * casos
     * 5- Lever por encima de superior
     * 
    */
    @Test
    public void ConstructorWithLeverMoreUpPosition(){
        try{
            BridgeController bc = new BridgeController(BridgeController.LEVER_UP + 1 );
        } catch (IllegalArgumentException e) {
            assertEquals("palanca fuera de rango", e.getMessage());
        } 
    }
    
    /*
     * Pruebas de changeClutch
     * Cambia de presionado a no presionado o viceversa
     * casos
     * 1- está inicialmente presionado
     * 2- está inicialmente no presionado
     */
    
    /**
     * Pruebas de changeClutch
     * Cambia de presionado a no presionado o viceversa
     * casos
     * 1- está inicialmente presionado
     * 
     */
    @Test
    public void changeClutchWhenPressed(){
        //Preparamos el caso
        BridgeController bc = new BridgeController(BridgeController.LEVER_UP );
        bc.changeClutch();
        
        bc.changeClutch();
        assertEquals(!BridgeController.PRESSED, bc.getClutch());
    }
    
    /**
     * Pruebas de changeClutch
     * Cambia de presionado a no presionado o viceversa
     * casos
     * 2- está inicialmente no presionado
     * 
     */
    @Test
    public void changeClutchWhenNOTPressed(){
        BridgeController bc = new BridgeController(BridgeController.LEVER_UP );
        
        bc.changeClutch();
        assertEquals(BridgeController.PRESSED, bc.getClutch());
    }
        
    /*
     * Pruebas de changeLever
     * 1- enbrague pressed, palanca en 0 cambia a 1
     * 2- embrague pressed, palanca en 0 cambia a 2
     * 3- embrague pressed, palanca en 1 cambia a 2
     * 
     * 4- embrague pressed palanca en 1 baja a 0
     * 5- embrague pressed, palanca en 2 cambia a 1
     * 6- embrague pressed, palanca en 2 cambia a 0
     * 
     * 7- enbrague no pressed
     * 8- embrague pressed cambia a -1
     * 9- embrague pressed cambia a 3
     */    
    
    /**
     * Pruebas de changeLever
     * 1- enbrague pressed, palanca en 0 cambia a 1
     * 
     */    
    @Test
    public void changeLeverPressedFrom0To1(){
        BridgeController bc = new BridgeController();
        bc.changeClutch();
        
        bc.changeLever(BridgeController.LEVER_MIDDLE);
        
        assertEquals(BridgeController.LEVER_MIDDLE, bc.getLever());
        assertEquals(BridgeController.LEVER_MIDDLE * BridgeController.INTERVAL,
                     bc.getBridge().getSlope());
    }
    
    /**
     * Pruebas de changeLever
     * 2- enbrague pressed, palanca en 0 cambia a  2
     * 
     */    
    @Test
    public void changeLeverPressedFrom0To2(){
        BridgeController bc = new BridgeController();
        bc.changeClutch();
        
        bc.changeLever(BridgeController.LEVER_UP);
        
        assertEquals(BridgeController.LEVER_UP, bc.getLever());
        assertEquals(BridgeController.LEVER_UP * BridgeController.INTERVAL,
                     bc.getBridge().getSlope());
    }
    
    /**
     * Pruebas de changeLever
     * 3- enbrague pressed, palanca en 1 cambia a  2
     * 
     */    
    @Test
    public void changeLeverPressedFrom1To2(){
        // RELLENAR !!
    }
    
    /**
     * Pruebas de changeLever
     * 4- embrague pressed palanca en 1 baja a 0
     * 
     */    
    @Test
    public void changeLeverPressedFrom1To0(){
        BridgeController bc = new BridgeController();
        bc.changeClutch();
        bc.changeLever(BridgeController.LEVER_MIDDLE);
        
        bc.changeLever(BridgeController.LEVER_DOWN);
        
        assertEquals(BridgeController.LEVER_DOWN, bc.getLever());
        assertEquals(BridgeController.LEVER_DOWN * BridgeController.INTERVAL,
                     bc.getBridge().getSlope());
    }
    
    /**
     * Pruebas de changeLever
     * 6- embrague NO pressed palanca en 0 NO CAMBIA
     * 
     */    
    @Test
    public void changeLeverPressedFrom2To0(){
        BridgeController bc = new BridgeController();
        
        bc.changeLever(BridgeController.LEVER_UP);
        
       
        
        assertEquals(BridgeController.LEVER_DOWN, bc.getLever());
        assertEquals(BridgeController.LEVER_DOWN* BridgeController.INTERVAL,
                     bc.getBridge().getSlope());
    }
    
     /**
     * Pruebas de changeLever
     * 7- embrague  pressed palanca A -1
     * 
     */    
    @Test
    public void changeLeverPressedFrom0ToNegative(){
        BridgeController bc = new BridgeController();
        bc.changeClutch();
        
        bc.changeLever(BridgeController.LEVER_DOWN - 1);
        
             
        assertEquals(BridgeController.LEVER_DOWN, bc.getLever());
        assertEquals(BridgeController.LEVER_DOWN* BridgeController.INTERVAL,
                     bc.getBridge().getSlope());
    }
        
        
    
}
