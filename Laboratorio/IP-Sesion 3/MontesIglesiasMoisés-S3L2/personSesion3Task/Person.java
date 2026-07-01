import java.util.Set;

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
    private int CriticalAge; //Edad de la persona en años
    private String HashCode;
    private String length;
    
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
        this.setSurname("Sainz");
        this.setName("Carlos");
        this.setAge(27);
        this.setGender(Person.GENDER_MALE);
    }
        
    /**
     * Crea una persona con valores por defecto de la edad que te la pide.
     * @param age Edad de la persona en años
     */
    public Person(String name, String surname, int age, boolean gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = GENDER_MALE;
    }
    
    private void setName(String name){//Pide el nombre
        this.name = name;  
    }
    
    /**
     * Nombre de la persona
     */
    public String getName() {//Devuelve nombre
        return this.name;
    }

    private void setSurname(String surname){//Pide apellidos
        this.surname = surname;
    }
    
    /**
     * Apellidos de la persona
     */
    public String getSurname() {//Devuelve apellidos
        return this.surname; 
    }
    
    private void checkParam(boolean condition){//En caso de una edad negativa
        if (condition == false) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }
    
    /** 
     * Prohíbe que la edad sea menor que 0
     */
    public void setAge(int age){//Prohíbe que la edad sea menor que 0
        if (age == -1) age = age/0;
        checkParam(age >= MIN_AGE && age < MAX_AGE);
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
    
    private boolean getGender(){//Devuelve género
        return this.gender;
    }
    
    /**
     * Mostrar en pantalla emergente la siguiente frase:
     */public void print() {//Enseñará utilizando la función print la edad que tiene y la del año siguiente en una ventana emergente
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
    
    /**
     * Mostrará edad, nombre (en mayúsculas), número de letras del nombre, apellido (en mayúsculas), número de letras del apellido.
     */
    public String getHashCode (){   
        return getAge() + "-" + getName().toUpperCase() + "-" + getName().length() + "-" + getSurname().toUpperCase() + "-" + getSurname().length();
    }
}