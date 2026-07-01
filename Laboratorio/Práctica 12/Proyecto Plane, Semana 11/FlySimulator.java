import java.util.*;

/**
 * Write a description of class FlySimulator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlySimulator
{
    private ArrayList<Plane> planes;
    private char[][]map;
    /**
     * Constructor for objects of class FlySimulator
     */
    public FlySimulator()
    {
        planes = new ArrayList<Plane>();
        map = new char[Plane.MAX_X+1][Plane.MAX_Y+1];    
    }
    
    /**
     * Añade un avión al simulador. El avión debe existir; si no, se genera una excepción
     * Si el identificador ya existe o hay otro avión en la misma posición, no se añade
     * @param p avión a añadir
     * @param true si se ha podido añadir el avión; falso si no
     */
    public boolean addPlane(Plane plane){
        checkParam(plane!=null, "El avión tiene que existir, zoquete");
        for(Plane p: planes){
            if(p.getIdentifier() == plane.getIdentifier())
                return false;
            if(p.getPositionFromX() == plane.getPositionFromX() && 
            p.getPositionFromY() == plane.getPositionFromY())
                return false;
        }
        planes.add(plane);
        return true;
    }
    
    /**
     * Crea un simulador con aviones
     * @param planesNumber Número de aviones que tendrá el simulador
     */
    public FlySimulator(int planesNumber){
        this();
        for(int i = 0; i<planesNumber; i++){
            while(addPlane(new Plane((char) ('A' + i))) == false);
        }
    }
    
    private void fillWithDots(){
        for(int x = 0; x<map.length; x++){
            for(int y = 0; y<map.length; y++){
                map[x][y] = '.';
            }
        }
    }
    
    public void print(){
        for(int x = 0; x<map.length; x++){
            for(int y = 0; y<map.length; y++){
                System.out.print(map[x][y]+" ");
            }
            System.out.println();
        }
    }
    
    /**
     * Simula el comportamiento de los aviones 
     */
    public void simulate(){
        fillWithDots();
        for(Plane p: planes){
            p.fly();
            if(map[p.getPositionFromX()][p.getPositionFromY()]!= '.'){
                map[p.getPositionFromX()][p.getPositionFromY()] = '%';
            }else{
            map[p.getPositionFromX()][p.getPositionFromY()] = p.getIdentifier();
            }
        }
        Iterator<Plane> it = Planes.iterator();
        while(it.hasNext()){
            Plane p = it.next();
            if(map[p.getPositionFromX()][p.getPositionFromY()] == '%'){
                System.out.println("Colisión detectada. Avión: " + p.toString());
                it.remove();
            }
        }
        print();
    }
    
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}

