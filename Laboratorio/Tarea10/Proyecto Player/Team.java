
/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    private Player [] players;
    private int index;
    

    /**
     * Constructor for objects of class Team
     */
    public Team(int numberOfPlayers)
    {
        checkParam(numberOfPlayers>0, "El número de jugadores debe ser, de al menos, 1");
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i<numberOfPlayers; i++){
            players[i] = (new Player());
        }
    }
    
    /**
     * Devuelve el jugador i-ésimo del team
     * @param n Número de personajes a devolver
     * @param el personaje número n
     */
    public Player getPlayer(int n){
        checkParam(n>=0 && n<numberOfPlayers(), "Número de jugadores inválido");
        return this.players[n];
    }
    
    public int numberOfPlayers(){
        return this.players.length;
    }
    
    private void setIndex(int index){
        checkParam(index>=0 && index<=3, "La pisición debe encontrarse entre 0 y 3");
        this.index = index;
    }
    
    private int getIndex(){
        return this.index;
    }
    
    public void add(Player player){
        
    }
    
    public void add(int index, Player player){
        
    }
    
    public String seekPlayer(Player number){
        return "";
    }
    
    public void removePlayer(Player number){
        
    }
    
    public void showPlayers(){
        
    }
    
    public void trainPlayers(){
        
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}
