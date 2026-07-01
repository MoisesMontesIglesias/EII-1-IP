
/**
 * @author (Moisés Montes Iglesias) 
 * Fecha 02/10/2022
 * @version 1.0
 */
public class Tree
{
    public String typeOfTree;//Tipo de árbol
    public int numberOfFlowers;//Número de flores
    public int numberOfFruits;//Número de frutas
    public String water;
    public String gatherFruit;
    public String harvest;
    public final static int MAX_NUMBER_OF_FLOWERS = 12;//Número máximo de flores
    public final static int MIN_NUMBER_OF_FLOWERS = 0;//Número mínimo de flores
    public final static int MIN_NUMBER_OF_FRUITS = 0;//Número mínimo de frutas
    public final static String DEFAULT_TYPE_OF_TREE = "Manzano";//Nombre base del árbol
    public final static int DEFAULT_NUMBER_OF_FLOWERS = 7;//Número base de flores
    public final static int DEFAULT_NUMBER_OF_FRUITS = 3;//Número base de frutas
    public final static int CONSTANT_NUMBER = 1;//Número constante
    
    /**
     * Tipo de árbol con valores ya predefinidos
     */
    public Tree() {//Valores de un árbol ya predefinido, en este caso, un manzano
        setTypeOfTree(DEFAULT_TYPE_OF_TREE);
        setNumberOfFlowers(DEFAULT_NUMBER_OF_FLOWERS);
        setNumberOfFruits(DEFAULT_NUMBER_OF_FRUITS);
    }
    
    /**
     * Árbol a rellenar datos
     */
    public Tree(String typeOfTree, int numberOfFlowers, int numberOfFruits){//Solicitar valores al usuario
        this.typeOfTree = typeOfTree;
        this.numberOfFlowers = numberOfFlowers;
        this.numberOfFruits = numberOfFruits;
    }
    
    private void setTypeOfTree(String newTypeOfTree){//Le pido al programa que solicite un nombre para el tipo de árbol
        this.typeOfTree = newTypeOfTree;
    }
    
    private String getTypeOfTree() {//Devolver tipo de árbol
        return typeOfTree;
    }
    
    private void checkParam(boolean condition){//Este método lo practicamos en clase y lo utilizo para que en el caso de que el número de valores sea negativo, al utilizar el print salte un error en el programa
        if (condition == false) {
            throw new IllegalArgumentException("La cantidad de flores/frutas no puede ser negativa o mayor de 12");
        }
    }
    
    /**
     * Reglas del número de flores y pedir número
     */
    public void setNumberOfFlowers(int newNumberOfFlowers){//Le pido al programa que pida un valor para las flores y también que me lo pueda devolver
        checkParam (newNumberOfFlowers >= MIN_NUMBER_OF_FLOWERS );
        checkParam (newNumberOfFlowers <= MAX_NUMBER_OF_FLOWERS );
        this.numberOfFlowers = newNumberOfFlowers;
    }
    
    /**
     * Recibir número de flores
     */
    public int getNumberOfFlowers(){
        return numberOfFlowers;
    }
    
    private void setNumberOfFruits(int newNumberOfFruits){//Le pido al programa que pida un valor para las frutas
        checkParam (newNumberOfFruits >= MIN_NUMBER_OF_FRUITS);
        this.numberOfFruits = newNumberOfFruits;
    }
    
    private int getNumberOfFruits(){//Número de frutas
        return numberOfFruits;
    }
    
    /**
     * Despliegue de una ventana emergente con las siguientes afirmaciones:
     */
    public void print(){//Despliegue de una ventana emergente con las siguientes afirmaciones:
        System.out.println("Valores de las propiedades del árbol: " + getTypeOfTree() + "-" + MAX_NUMBER_OF_FLOWERS + "-" + getNumberOfFlowers() + "-"   + getNumberOfFruits());
    }
    
    /**
     * Uso del método if para que mediante guiones me de todos los valores dados al programa en una única frase, y en caso de incumplir alguna regla, devolver una frase explicando el error
     */
    public String toString(){//Preciso del método toString para que mediante guiones me de todos los valores dados al programa en una única frase
        if (getNumberOfFlowers() <= MAX_NUMBER_OF_FLOWERS){
            return getTypeOfTree() + "-" + MAX_NUMBER_OF_FLOWERS + "-" + getNumberOfFlowers() + "-" + getNumberOfFruits();
        } 
        if (getNumberOfFlowers() < MIN_NUMBER_OF_FLOWERS){
            return "Debe fallar porque el mínimo de flores es 0, y por lo tanto está fuera de límites";
        }
        return "Es imposible que tengamos más flores que el valor máximo posible";
    }
    
    /**
     * Uso del método if en el que se busca que devuelva 1 número más ya sea de frutas o flores dependiendo de los valores que tenga, y en caso de incumplir ambas reglas, devolverá una frase señalando que no se realiza ningún cambio
     */
    public String water(){
        if (getNumberOfFlowers() < MAX_NUMBER_OF_FLOWERS){
        return " " + (getNumberOfFlowers() + 1);
        } 
        if (getNumberOfFruits() < MAX_NUMBER_OF_FLOWERS){
        return " " + (getNumberOfFlowers() - 1) + " " + (getNumberOfFruits() + 1);
        }
        return "No se realiza ningún cambio ni en frutas ni en flores";
    }
    
    /**
     * Va a devolver el número de frutas dadas, menos 1
     */
    public String gatherFruit(){
        checkParam (numberOfFruits >= MIN_NUMBER_OF_FRUITS);
        return "Al recoger una fruta de las dadas, obetenemos que el número de frutas restantes es: " + (getNumberOfFruits() - 1);
    }
    
    /**
     * Dice el número de frutas que tenemos, las recoge y convierte el valor de las manzanas en 0
     */
    public int harvest(){
        int a = numberOfFruits;
        numberOfFruits = 0;
        return a;
    }
}
