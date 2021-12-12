package rjsnakeandladder;

public class Dice {
    private int minVal;
    private int maxVal;
    
    public Dice(int minVal, int maxVal){
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
    
    public int rollADice(){
        return (int)Math.floor(Math.random()*(maxVal-minVal+1)+minVal);
    }
}
