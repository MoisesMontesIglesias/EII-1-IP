
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public void m1()
    {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 = new String("HELLO");
        //UTILIZAR EQUALS, COMPARETO, O COMPARETOIGNORE CASE, EL S1 == S2/S3, SERÁ PENALIZADO
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.compareTo(s2) == 0);//true
        System.out.println(s1.compareTo(s3) == 0);//true
        System.out.println(s1.compareToIgnoreCase(s2) == 0);
        System.out.println(s1.compareToIgnoreCase(s3) == 0);
    }
}
