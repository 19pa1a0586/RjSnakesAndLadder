package rjsnakeandladder;

import java.util.HashMap;
import java.util.Map;

public class Snakes {
    private int noOfSnakes;
    private Map<Integer, Integer> headsAndTails = new HashMap<Integer, Integer>();
    
    public Snakes(int noOfSnakes){
        this.noOfSnakes = noOfSnakes;
    }
    
    public void addHeadAndTail(int head, int tail){
        headsAndTails.put(head, tail);
    }
    
    public Map<Integer, Integer> getHeadsAndTails(){
        return headsAndTails;
    }
    
    public int getNoOfSnakes(){
        return this.noOfSnakes;
    }
}
