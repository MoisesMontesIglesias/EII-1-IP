import java.util.*;

/**
 * Write a description of class Team here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Team
{
    private ArrayList<Player> team;

    /**
     * Constructor for objects of class Team
     */
    public Team()
    {
        team = new ArrayList<Player>();
    }
    
    protected ArrayList<Player> getTeam(){
        ArrayList<Player> tmp = new ArrayList<Player>();
        for (Player p : team) {
              tmp.add(p);
          }
        return tmp;
    }
    
    /**
     * Añade un jugador a la colección
     * @param player, nombre y número del jugador
     */
    public void add(Player player){
        checkParam(player!=null, "Jugador no válido: null");
        team.add(player);
    }
    
    /**
     * Añade un jugador a la colección
     * @param index, posición del jugador
     * @param player, nombre y número del jugador
     */
    public void add(int index, Player player){
        checkParam(index >= 0 && index <= team.size(),"Posición ilegal");
        checkParam(player != null, "Jugador no válido: null");
        team.add(index, player);
    }
    
    /**
     * Devuelve el jugador que tenga el número dado como parámetro o null
     * si no hay jugador
     * @param número del jugador que se desea mostrar
     */
    public Player seekPlayer(int number){
        for (Player p : team){
            if (p.getNumber() == number){
                return p;
            }
        }
        return null;
    }
    
    /**
     * EJEMPLO DEL PROFE
     */
    
    // /**
     // * Elimina de la colección al jugador cuyo número se ha dado
     // * @param number, número del jugador que se desea eliminar
     // */
    // public void removePlayer0(int number){
        // checkParam(number >= 0 && number < team.size(), "Ese número no consta de jugador");
        // int i = 0;
        // for (Player p : team){
            // if(p.getNumber() == number){
                // team.remove(i);
                // return;
            // }
            // i++;
        // }
        // return; 
    // }
    /**
     * EJEMPLO DEL PROFE, q no es buena idea
     */
    // public void removePlayer(int number){
        // int pos = 0;
        // for(Player p: team){
            // if(p.getNumber() == number){
                // team.remove(pos);
            // }
            // pos++;
        // }
    // }
    
    /**
     * EJEMPLO DEL PROFE, mal también
     */
    // public void removePlayer(int number){
        // Player p;
        // for(int pos = 0; pos<team.size(); pos++){
            // p = team.get(pos);
            // if ( p.getNumber()==number){
                // team.remove(pos);
            // }
        // }
    // }
    /**
     * Elimina de la colección al jugador cuyo número se ha dado
     * @param number, número del jugador que se desea eliminar
     */
    public void removePlayer(int number){
        Player p;
        for(int pos = 0; pos<team.size(); pos++){
            p = team.get(pos);
            if(p.getNumber() == number){
                team.remove(pos);
                pos--;
            }
        }
    }
    
    /**
     * Elimina de la colección al jugador cuyo número se ha dado
     * @param number, número del jugador que se desea eliminar
     */
    public void removePlayerElegant(int number){
        Player p;
        int pos = 0;
        while(pos<team.size()){
            p = team.get(pos);
            if(p.getNumber() == number){
                team.remove(pos);
            } else{
                pos++;
            }
        }
    }
    
    /**
     * EJEMPLO DEL PROFE, otra forma correcta de hacerlo
     */
    // /**
     // * Elimina de la colección al jugador cuyo número se ha dado
     // * @param number, número del jugador que se desea eliminar
     // */
    // public void removePlayer4(int number){
        // Player p;
        // for(int pos = team.size()-1; pos>=0;pos--){
            // p = team.get(pos);
            // if(p.getNumber() == number){
                // team.remove(pos);
            // }
        // }
    // }
    
    /**
     * Muestra los jugadores que hay
     */
    public void showPlayers(){
        for(Player player : team) {
            System.out.println(player);
        }
    }
    
    /**
     * devuelve ArrayList con los jugadores con numero impar
     * @return ArrayList
     */
    public ArrayList<Player> trainPlayers()
    {
        ArrayList<Player> train = new ArrayList<Player>();
        for (Player p : team){
            if(p.getNumber()%2 == 1){
                train.add(p);
            }
        }
        return train;
        // for(int i = 0; i < team.size();i++){
            // if(team.get(i).getNumber() %2 != 0){
                // ArrayList<Player> trainPlayers = new ArrayList<Player>();
                // System.out.println(team.get(i).getName()+" "+team.get(i).getNumber());
            // }
        // }
    }
    
    private void checkParam(boolean condition, String msg){
        if (condition == false) {
            throw new IllegalArgumentException(msg);
        }
    }
}
