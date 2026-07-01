import java.util.Set;

/**
 * Añadir "boolean" y "surname" usando "get" y "set". Además, añadí el "this."
 * y el "public Person" que descubrí en información por internet.
 * 
 * Autor Moisés Montes Iglesias
 * Fecha 13/9/2022
 * Clase impartida el martes 13/09/2022 en L-04. Grupo IP.L.2
 */
public class Person
{
    
    private String name;
    private String surname;
    private int age;
    
    public boolean gender;
    public final boolean Male = true;
    public final boolean Female = false;
    
    public Person(String name, String surname, int age, boolean gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = true;
    }
    
    public void setName(String newName){
        this.name=newName;  
    }
    
    public String getName() {
        return name;
    }

    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    
    public String surname() {
        return surname; 
    }
    
    public void setAge(int newAge){
        this.age=newAge;  
    }
    
    public int getAge(){
        return age;
    }
    
    public void setGender(boolean gender){
        this.gender = gender;
    }
    
}