import java.util.Set;

/**
 * @author Moisés Montes Iglesias
 * Fecha 20/9/2022
 * @version 1.0
 * Clase impartida el martes 20/09/2022 en L-04. Grupo IP.L.2
 */

public class Person
{
    public static final boolean GENDER_MALE = true;
    public static final boolean GENDER_FEMALE = false;
    private String name; // Nombre de la persona
    private String surname; // Apellidos de la persona
    private int age; // Edad de la persona en años
    public boolean gender; // Género de la persona
    
    public final static boolean Male = true;
    public final static boolean Female = false;
    
    public final static int MIN_AGE = 0;
    public final static int MAX_AGE = 120;
    
    /**
     * Crea una persona con valores por defecto de sus atributos (Carlos Sainz, de 27 años y hombre)
     */
    public Person() {
        setSurname("Carlos");
        setName("Sainz");
        setAge(23);
        setGender(Male);
    }
    
    /**
     * Crea una persona con valores por defecto de la edad que te la pide.
     * @param age Edad de la persona en años
     */
    public Person(int age) {
        this();
        setAge(age);
        // setGender(true);
        // setSurname("Alonso");
        // setName("Fernando");
    }
    
    public Person(String name, String surname, int age, boolean gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = Male;
    }
    
    private void setName(String newName){
        this.name=newName;  
    }
    
    public String getName() {
        return name;
    }

    private void setSurname(String newSurname){
        this.surname = newSurname;
    }
    
    public String getSurname() {
        return surname; 
    }
    
    private void checkParam(boolean condition){
        if (condition == false) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }
    
    private void setAge(int newAge){
        checkParam(newAge>=0);
        age = newAge;
    }
    
    /**
     * Obtención de la edad de la persona en años.
     * @return Edad de la persona en años
     */
    public int getAge(){
        return age;
    }
    
    private void setGender(boolean gender){
        this.gender = gender;
    }
    
    private boolean getGender(){
        return gender;
    }
    
    public void print() {
        System.out.println("Mi edad es "+ getAge() + " pero el año que viene tendre " + (getAge() + 1) + " años.");
    }
    
    public String toString(){
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
        // return tmp;
    
        return getName() + "-" + getSurname() +"-"+ getAge() +"-"+ (getGender()?"masculino":"femenino");
    }
}