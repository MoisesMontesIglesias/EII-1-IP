
/**
 * Write a description of class Concert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Concert
{
    

    /**
     * Constructor for objects of class Concert
     */
    public Concert()
    {
        
    }

    /**
     * Esta mal porque no se comprueban objetos primitivos (if)
     */
    public Concert seekConcert(String concertName){
        checkParam(concertName!=null, "Debe existir");
        for(Concert c: concerts){
            if(concertName==c.getName()){
                return c;
            }
        }
        return null;
    }
    
    /**
     * Corrección del anterior
     */
    public Concert seekConcert(String concertName){
        checkParam(concertName!=null, "Debe existir");
        for(Concert c: concerts){
            if(concertName.equals(c.getName())){
                concertName.compareTo(concerts.get(i).getName());
                concertName.compareToIgnoreCase(concerts.get(i).getName());
            }
        }
        return null;
    }
    
    public void addConcert(String ConcertName, double price, Date date){
        for(int i = 0; i<concerts.size(); i++){
            if(date.equals(concerts.get(i).getDate())){
                return;
            }
        }
        concerts.add(new Concert(ConcertName,price,date));
    }
    
    public void removeConcerts(int year){
        for(int i = 0; i<concerts.size(); i++){
            if(year==concerts.get(i).getDate().getYear()){
                concerts.remove(i);
            }
        }
    }
    
    public void removeConcerts2(int year){
        Iterator<Concert> it = concerts.iterator();
        while(i.hasNext()){
            if(year==it.next().getDate().getYear()){
                it.remove();
            }
    }
    } 
}  
