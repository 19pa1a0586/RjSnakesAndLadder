package rjsnakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {
    private int noOfPlayers;
    private Map<String, Integer> playersNames = new HashMap<String, Integer>();
    private List<String> players = new ArrayList<>(noOfPlayers);
    
    public Players(int noOfPlayers){
        this.noOfPlayers = noOfPlayers;
    }
    
    public void addPlayer(String player){
        playersNames.put(player, 0);
        players.add(player);
    }
    
    public Map<String, Integer> getPlayersNames(){
        return playersNames;
    }
    
    public List<String> getPlayers(){
        return players;
    }
    
    public int getNoOfPlayers(){
        return this.noOfPlayers;
    }
}
