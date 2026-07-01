import java.util.*;

/**
 * Write a description of class Matrix here.
 * 
 * @author Moisés Montes Iglesias 
 * @version 1
 */
public class Matrix
{
    /**
     * Constante del valor mínimo que se debe dar de número enteros
     */
    public static final int MIN_NUM = 0;
    
    /**
     * Constante del valor máximo que se puede dar de número enteros
     */
    public static final int MAX_NUM = 255;
    
    /**
     * Constante del valor mínimo de la dimensión de la matriz
     */
    public static final int MIN_DIM = 2;
    
    /**
     * Constante del valor máximo de la dimensión de la matriz
     */
    public static final int MAX_DIM = 20;
    
    private int [][] matrix;
    /**
     * Constructor con parámetro dimension que muestra por pantalla una matriz
     * de números aleatorios con una dimensión que se define por un parámetro
     * solicitado
     * 
     * @param dimension, dimension que tiene la matriz
     */
    public Matrix(int dimension)
    {
        checkParam(dimension >= MIN_DIM && dimension <= MAX_DIM, "Invalid dimension for the matrix");
        Random random = new Random();
        matrix = new int[dimension][dimension];
        for(int i = 0; i <matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                matrix[i][j] = random.nextInt(MAX_NUM + 1);
            }
        }
    }
    
    /**
     * Constructor con parámetro array
     * Recibe una copia de la matriz pasada como parámetro
     * 
     * @param int[][]matrix, valores de la matriz
     */
    public Matrix(int [][] matrix){
        checkParam(matrix.length>=2 && matrix.length <= 20, "Invalid dimension for the matrix");
        checkParam(matrix.length == matrix[0].length, "The matrix must be square");
        this.matrix = matrix;
    }
    
    /**
     * Método getMatrix que devuelve una copia de la matriz creada
     */
    public int [][] getMatrix(){
        int [][] matrixCopy = new int [matrix.length][matrix[0].length];
        for (int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        return matrixCopy;
    }

    private void Random(){
        Random randomGenerator = new Random();
        int index1 = randomGenerator.nextInt(MAX_NUM+1);
        int index2 = randomGenerator.nextInt(MAX_NUM+1);
    }
    
    /**
     * Método flattenMatrix, devuelve el contenido de la matriz en un ArrayList
     */
    public ArrayList<Integer> flattenMatrix(){
        int[][] matrix1= getMatrix();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i<matrix1.length; i++){
            for(int j = 0; j<matrix1[0].length; j++){
                lista.add(matrix1[i][j]);
            }
        }
        System.out.print(lista);
        return lista;
    }
    
    /**
     * Método swapReverseByDiagonals, intercambia los elementos de las dos diagonales, invirtiendo
     * sus elementos.
     */
    public void swapReverseByDiagonals(){
        for(int i = 0; i<matrix.length; i++){
            int a = 0;
            a = matrix[matrix.length-1-i][i];
            matrix[matrix.length-1-i][i] = matrix[i][i]; //x30 = x00...
            matrix[i][i] = a; //x00 = x30...
        }
    }
    
    /**
     * Método moveColumn, mueve los elementos de la columna que se pasa como parámetro al final de
     * la matriz, desplazando el resto de columnas a la izquierda.
     * @param column, columna que se desea desplazar al final de la matriz
     */
    public void moveColumn(int column){
        
    }
    
    /**
     * Método print, que muestra por consola el contenido de la matriz
     */
    public void print(){
        System.out.println();
        for (int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length-1; j++){
                int c = matrix[i][j];
                if (c>9 && c<100){
                    System.out.print(c + "  ");
                }
                else if (c>99){
                    System.out.print(c + " ");
                }
                else{
                    System.out.print(c + "   ");
                }
            }
            int d = matrix[i][matrix[0].length-1];
            System.out.println("" + d);
        }
    }
    
    // /**
     // * Método replaceMatrix, recibe un ArrayList<Integer> y reemplaza todos los elementos de la matriz
     // * que pueda, desde la [0,0] avanzando por filas. Devuelve el número de elementos reemplazados en 
     // * la matriz.
     // * En el caso de que el ArrayList sea mayor a la matriz, se reemplazarán todas las posiciones de 
     // * la matriz, aunque sobren elementos del ArrayList
     // * @param ArrayList<Integer>flatMatrix, ArrayList de números que se intercambiará en la matriz
     // */
    // public int replaceMatrix(ArrayList<Integer>flatMatrix){
        
    // }
    
    // /**
     // * Método smoothMatrix,devuelve una matriz obtenida a partir del atributo, reemplazando cada
     // * elemento por la media aritmética de los vecinos(no incluyendo el propio elemento) de la matriz
     // * original
     // */
    // public int[][] smoothMatrix(){
        
    // }
    
   
    
    private void checkParam(boolean condition, String msg){
        if(!condition){
            throw new IllegalArgumentException(msg);
        }
    }
}
