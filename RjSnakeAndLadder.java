package rjsnakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RjSnakeAndLadder {

    static int noOfPlayers;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of Snakes : ");
        int noOfSnakes = in.nextInt();
        Snakes s = new Snakes(noOfSnakes);
        for(int i = 0; i < noOfSnakes; i++){
            System.out.print("Enter head "+(i+1)+": ");
            int head = in.nextInt();
            System.out.print("Enter tail "+(i+1)+": ");
            int tail = in.nextInt();
            s.addHeadAndTail(head, tail);
        }
        
        System.out.print("Enter number of Ladders : ");
        int noOfLadders = in.nextInt();
        Ladders l = new Ladders(noOfLadders);
        for(int i = 0; i < noOfLadders; i++){
            System.out.print("Enter start "+(i+1)+": ");
            int start = in.nextInt();
            System.out.print("Enter end "+(i+1)+": ");
            int end = in.nextInt();
            l.addStartAndEnd(start, end);
        }
        
        System.out.print("Enter number of Players : ");
        noOfPlayers = in.nextInt();
        in.nextLine();
        Players p = new Players(noOfPlayers);
        for(int i = 0; i < noOfPlayers; i++){
            System.out.print("Enter Player "+(i+1)+": ");
            String player = in.nextLine();
            p.addPlayer(player);
        }
        
        System.out.print("Enter minimum value of Dice : ");
        int minVal = in.nextInt();
        System.out.print("Enter maximum value of Dice : ");
        int maxVal = in.nextInt();
        Dice d = new Dice(minVal, maxVal);
        
        Map<Integer, Integer> headsAndTails = s.getHeadsAndTails();
        Map<Integer, Integer> startsAndEnds = l.getStartsAndEnds();
        Map<String, Integer> playersPositions = p.getPlayersNames();
        List<String> players = p.getPlayers();
        List<String> winners = new ArrayList<>();
        
        while(noOfPlayers > 1){
            for(int i = 0; i < noOfPlayers; i++){
                int diceValue = d.rollADice();
                int currPosition = playersPositions.get(players.get(i));
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
                    System.out.println(players.get(i)+" rolled a "+diceValue+" and moved from "+currPosition+" to "+nextPosition);
                    playersPositions.put(players.get(i), nextPosition);
                }
                else{
                    System.out.println(players.get(i)+" rolled a "+diceValue+" and moved from "+currPosition+" to "+currPosition);
                }
                if(playersPositions.get(players.get(i)) == 100){
                    winners.add(players.get(i));
                    players.remove(players.get(i));
                    noOfPlayers--;
                }
            }
        }
        
        for(int i = 0; i < winners.size(); i++){
            System.out.println(winners.get(i)+" Secured position "+(i+1));
        }
    }
}