package rjsnakeandladder;

import java.util.HashMap;
import java.util.Map;

public class Ladders {
    private int noOfLadders;
    private Map<Integer, Integer> startsAndEnds = new HashMap<Integer, Integer>();
    
    public Ladders(int noOfLadders){
        this.noOfLadders = noOfLadders;
    }
    
    public void addStartAndEnd(int start, int end){
        startsAndEnds.put(start, end);
    }
    
    public Map<Integer, Integer> getStartsAndEnds(){
        return startsAndEnds;
    }
    
    public int getNoOfLadders(){
        return this.noOfLadders;
    }
}
