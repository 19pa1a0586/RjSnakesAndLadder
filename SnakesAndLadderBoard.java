package rjsnakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static rjsnakeandladder.RjSnakeAndLadder.noOfPlayers;

public class SnakesAndLadderBoard {
    Map<Integer, Integer> headsAndTails;
    Map<Integer, Integer> startsAndEnds;
    Map<String, Integer> playersPositions;
    List<String> players;
    Dice d;
    List<String> winners = new ArrayList<>();
    
    public SnakesAndLadderBoard(Map headsAndTails, Map startsAndEnds, Map playersPositions, List players, Dice d){
       this. headsAndTails = headsAndTails;
       this.startsAndEnds = startsAndEnds;
       this.playersPositions = playersPositions;
       this.d = d;
       this.players = players;
    }
    
    public String setAndGetNextPosition(int i){
        int diceValue = d.rollADice();
        String playerName = players.get(i);
        int currPosition = playersPositions.get(playerName);
        String res;
        if(currPosition+diceValue <= 100){
            int nextPosition;
            if(headsAndTails.containsKey(currPosition+diceValue)){
                nextPosition = headsAndTails.get(currPosition+diceValue);
            }
            else if(startsAndEnds.containsKey(currPosition+diceValue)){
                nextPosition = startsAndEnds.get(currPosition+diceValue);
            }
            else{
                nextPosition = currPosition+diceValue;
            }
            int prevPosition = nextPosition;
            while(headsAndTails.containsKey(nextPosition) || startsAndEnds.containsKey(nextPosition)){
                if(headsAndTails.containsKey(nextPosition)){
                    nextPosition = headsAndTails.get(nextPosition);
                }
                else if(startsAndEnds.containsKey(nextPosition)){
                    nextPosition = startsAndEnds.get(nextPosition);
                }
                if(prevPosition == nextPosition){
//                    System.out.println("loop");
                    nextPosition = currPosition;
                    break;
                }
            }
            playersPositions.put(playerName, nextPosition);
            res = playerName+" rolled a "+diceValue+" and moved from "+currPosition+" to "+nextPosition;
        }
        else{
            res = playerName+" rolled a "+diceValue+" and moved from "+currPosition+" to "+currPosition;
        }
        if(playersPositions.get(playerName) == 100){
            winners.add(playerName);
            players.remove(playerName);
            noOfPlayers--;
        }
        return res;
    }
    
    public List getWinners(){
        return winners;
    }
}
