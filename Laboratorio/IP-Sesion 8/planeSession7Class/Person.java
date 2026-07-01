import java.util.Random;

/**
 * @author Moisés Montes Iglesias
 * Fecha 20/9/2022
 * @version 1.0
 * Clase impartida el martes 20/09/2022 en L-04. Grupo IP.L.2
 */

public class Person
{
    private String name; // Nombre de la persona
    private String surname; // Apellidos de la persona
    private int age; // Edad de la persona en años   
    
    /** 
     * Género de la persona
     */
    public boolean gender; // Género de la persona
    
    /** 
     * Género masculino
     */
    public final static boolean GENDER_MALE = true;//Género hombre
    
    /** 
     * Género femenino
     */
    public final static boolean GENDER_FEMALE = false;//Género mujer
    
    /** 
     * Mínimo de edad posible de una persona
     */
    public final static int MIN_AGE = 0;//Mínimo de edad de una persona
    
    /** 
     * Máximo de edad de una persona
     */
    public final static int MAX_AGE = 120;//Máximo de edad de una persona
    
    /** 
     * Edad para entrar en el intervalo de adulto
     */
    public final static int ADULTHOOD_AGE = 18;//Edad para entrar en el intervalo de adulto
    
    /** 
     * Edad en la que se pasa de adulto a jubilado
     */
    public final static int RETIREMENT_AGE = 65;//Edad en la que se pasa de adulto a jubilado
    
    /** 
     * Nombre de ejemplo
     */
    public final static String DEFAULT_NAME = "Fernando";
    
    /** 
     * Apellido de ejemplo
     */
    public final static String DEFAULT_SURNAME = "Alonso";
    
    /** 
     * Edad de ejemplo
     */
    public final static int DEFAULT_AGE = 40;
    
    /** 
     * Género de ejemplo
     */
    public final static boolean DEFAULT_GENDER = GENDER_MALE;
    
    
    /**
     * Crea una persona con valores por defecto de sus atributos (Carlos Sainz, de 27 años y hombre)
     */
    public Person() {
        //Random r = new Random();
        //this.setAge(r.nextInt(MAX_AGE));
        this.setName(DEFAULT_NAME);
        this.setSurname(DEFAULT_SURNAME);
        this.setAge(MAX_AGE);
        this.setGender(DEFAULT_GENDER);
    }
    
    /**
     * Crea una persona con valores por defecto de sus atributos (Carlos Sainz, de 27 años y hombre)
     */
    public Person(int age) {
        this();
        this.setAge(age);
    }
    
    /**
     * Crea una persona con valores por defecto de la edad que te la pide.
     * @param name Nombre de la persona
     * @param surname Apellido de la persona
     * @param age Edad de la persona en años
     * @param gender Género de la persona
     */
    public Person(String name, String surname, int age, boolean gender){
        this();
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
        this.setGender(gender);  
    }
    
    /**
     * Pedir nombre de la persona
     */
    public void setName(String name){
        checkParam(name!=null, "El nombre no puede ser null");
        this.name = name;
    }
    
    /**
     * Nombre de la persona
     */
    public String getName() {//Devuelve nombre
        return this.name;
    }

    private void setSurname(String surname){//Pide apellidos
        checkParam(surname!=null, "El apellido no puede ser null");
        this.surname = surname;
    }
    
    /**
     * Apellidos de la persona
     */
    public String getSurname() {//Devuelve apellidos
        return this.surname; 
    }
    
    private void checkParam(boolean condition, String msg){//En caso de una edad negativa
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /** 
     * Prohíbe que la edad sea menor que 0
     */
    private void setAge(int age){//Prohíbe que la edad sea menor que 0
        checkParam(age >= MIN_AGE && age < MAX_AGE, "Valor incorrecto de la edad");
        // checkParam(age >= MIN_AGE);
        // checkParam(age < MAX_AGE);
        this.age = age;
    }
    
    /**
     * Obtención de la edad de la persona en años.
     * @return Edad de la persona en años
     */
    public int getAge(){
        return this.age;
    }
    
    private void setGender(boolean gender){//Pide género
        this.gender = gender;
    }
    
    public boolean getGender(){//Devuelve género
        return this.gender;
    }
    
    /**
     * Mostrar en pantalla emergente la siguiente frase:
     */
    public void print() {//Enseñará utilizando la función print la edad que tiene y la del año siguiente en una ventana emergente
        System.out.println("Mi edad es "+ getAge() + " pero el año que viene tendre " + (getAge() + 1) + " años.");
    }
    
    /**
     * Mostrar nombre, apellidos, edad y género separado por guiones
     */
    public String toString(){//Enseñará el nombre, apellidos, edad y género separado por guiones
        // if (getGender() == true) {
            // return getName() + "-" + getSurname() + "-" + getAge() + "-masculino";
        // }
        // else {
            // return getName() + "-" + getSurname() + "-" + getAge() + "-femenino";
        // }
        // if (getGender() == true) {
            // return getName() + "-" + getSurname() + "-" + getAge() + "-masculino";
        // if (getGender() == false) {
            // return getName() + "-" + getSurname() + "-" + getAge() + "-femenino";
        // }
        // return "No sé";
        // }
        // String tmp;
        
        // tmp = getName() + "-" + getSurname() + "-" + getAge() + "-";
        // if (getGender()==GENDER_MALE) {
            // tmp=tmp+"masculino";
        // }
        // else {
            // tmp=tmp + "-femenino";
        // }
        // return tmp.toUpperCase();
    
        return getName().toUpperCase() + "-" + getSurname().toUpperCase() +"-"+ getAge() +"-"+ (getGender()?"masculino":"femenino");
    }
    
    /**
     * Mostrará al usuario su nombre, la edad que tiene y los años que le faltan para el siguiente rango de edad o el tiempo que lleva jubilado
     */
    public String CriticalAge (){//Mostrará al usuario su nombre, la edad que tiene y los años que le faltan para el siguiente rango de edad o el tiempo que lleva jubilado
        if (getAge() < ADULTHOOD_AGE) {//Este código se mostrará a la persona que haya rellenado los datos al crear el objeto y tenga menos de 18 años
        return getName() + " tienes " + getAge() + " año/s, y te faltan " + (ADULTHOOD_AGE - getAge() + " año/s para cumplir los 18 años.");
        }
        if (getAge() > RETIREMENT_AGE) {//Este código se mostrará a la persona que haya rellenado los datos al crear el objeto y tenga más de 65, e indicará también cuantos años lleva jubilado/a
        return getName() + " tienes " + getAge() + " año/s, y llevas " + (getAge() - RETIREMENT_AGE) + " año/s jubilado.";
        }//Este código se mostrará a la persona que haya rellenado los datos al crear el objeto y tenga entre 18 y 65 años
        return getName() + " tienes " + getAge() + " año/s, y te faltan " + (RETIREMENT_AGE - getAge() + " año/s para cumplir los 65 años.");   
    }
    
    // /**
     // * Mostrará edad, nombre (en mayúsculas), número de letras del nombre, apellido (en mayúsculas), número de letras del apellido.
     // */
    // public String getHashCode() {  
        // if (getAge() < ADULTHOOD_AGE) {
        // return getAge() + "-" + getName().toUpperCase().charAt(1) + getName().toUpperCase().charAt(2) + "-" +
        // getSurname().toUpperCase().charAt(1) + getSurname().toUpperCase().charAt(2) 
        // + getSurname().toUpperCase().charAt(3) + getSurname().toUpperCase().charAt(4) + "-" + "CHILD";
        // }
        // if (getAge() > RETIREMENT_AGE) { 
        // return getAge() + "-" + getName().toUpperCase().charAt(1) + getName().toUpperCase().charAt(2) + "-" + 
        // getSurname().toUpperCase().charAt(1) + getSurname().toUpperCase().charAt(2) 
        // + getSurname().toUpperCase().charAt(3) + getSurname().toUpperCase().charAt(4) + "-" + "RETIRED";
        // }
        // return getAge() + "-" + getName().toUpperCase().charAt(1) + getName().toUpperCase().charAt(2) + "-" + 
        // getSurname().toUpperCase().charAt(1) + getSurname().toUpperCase().charAt(2) + getSurname().toUpperCase().charAt(3) + 
        // getSurname().toUpperCase().charAt(4) + "-" + "ADULT";
    // }   
    
    private String getSubstring1(){
        if (getName().length()<2){
            return getName();
        }
        else {
            return getName().substring(0,2).toUpperCase();
        }
    }
    
    private String getSubstring2(){
        if (getSurname().length()<4){
            return getSurname();
        }
        else {
            return getSurname().substring(0,4).toUpperCase();
        }
    }
    
    /**
     * Utilización del HashCode
     */
    public String getHashCode(){
        if (getAge() < ADULTHOOD_AGE) {
            return getAge() + "-" + getSubstring1() + "-" + getSubstring2() + "-" + "CHILD";
        }
        if (getAge() < ADULTHOOD_AGE) {
            return getAge() + "-" + getSubstring1() + "-" + getSubstring2() + "-" + "RETIRED";
        }       
        return getAge() + "-" + getSubstring1() + "-" + getSubstring2() + "-" + "ADULT";
        }
}