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
        SnakesAndLadderBoard sb = new SnakesAndLadderBoard(headsAndTails, startsAndEnds, playersPositions, players, d);
        
        while(noOfPlayers > 1){ 
            for(int i = 0; i < noOfPlayers; i++){
                System.out.println(sb.setAndGetNextPosition(i));
            }
            
        }
        
        List<String> winners = sb.getWinners();
        System.out.println("*********************************Game is Completed*********************************");
        System.out.println("                                      Winners");
        for(int i = 0; i < winners.size(); i++){
            System.out.println("                               "+winners.get(i)+" Secured Position "+(i+1));
        }
    }
}

//SAMPLE INPUT : 

//Enter number of Snakes : 3
//Enter head 1: 64
//Enter tail 1: 32
//Enter head 2: 84
//Enter tail 2: 64
//Enter head 3: 55
//Enter tail 3: 34
//Enter number of Ladders : 2
//Enter start 1: 32
//Enter end 1: 84
//Enter start 2: 14
//Enter end 2: 55
//Enter number of Players : 5
//Enter Player 1: siva
//Enter Player 2: rishika
//Enter Player 3: raju
//Enter Player 4: ram
//Enter Player 5: ravi
//Enter minimum value of Dice : 1
//Enter maximum value of Dice : 6

//SAMPLE OUTPUT : 

//siva rolled a 4 and moved from 0 to 4
//rishika rolled a 3 and moved from 0 to 3
//raju rolled a 4 and moved from 0 to 4
//ram rolled a 2 and moved from 0 to 2
//ravi rolled a 6 and moved from 0 to 6
//siva rolled a 6 and moved from 4 to 10
//rishika rolled a 1 and moved from 3 to 4
//raju rolled a 2 and moved from 4 to 6
//ram rolled a 3 and moved from 2 to 5
//ravi rolled a 6 and moved from 6 to 12
//siva rolled a 6 and moved from 10 to 16
//rishika rolled a 1 and moved from 4 to 5
//raju rolled a 1 and moved from 6 to 7
//ram rolled a 6 and moved from 5 to 11
//ravi rolled a 2 and moved from 12 to 34
//siva rolled a 4 and moved from 16 to 20
//rishika rolled a 3 and moved from 5 to 8
//raju rolled a 1 and moved from 7 to 8
//ram rolled a 5 and moved from 11 to 16
//ravi rolled a 1 and moved from 34 to 35
//siva rolled a 5 and moved from 20 to 25
//rishika rolled a 1 and moved from 8 to 9
//raju rolled a 3 and moved from 8 to 11
//ram rolled a 6 and moved from 16 to 22
//ravi rolled a 1 and moved from 35 to 36
//siva rolled a 6 and moved from 25 to 31
//rishika rolled a 3 and moved from 9 to 12
//raju rolled a 6 and moved from 11 to 17
//ram rolled a 5 and moved from 22 to 27
//ravi rolled a 4 and moved from 36 to 40
//siva rolled a 4 and moved from 31 to 35
//rishika rolled a 1 and moved from 12 to 13
//raju rolled a 2 and moved from 17 to 19
//ram rolled a 6 and moved from 27 to 33
//ravi rolled a 3 and moved from 40 to 43
//siva rolled a 1 and moved from 35 to 36
//rishika rolled a 4 and moved from 13 to 17
//raju rolled a 4 and moved from 19 to 23
//ram rolled a 4 and moved from 33 to 37
//ravi rolled a 2 and moved from 43 to 45
//siva rolled a 6 and moved from 36 to 42
//rishika rolled a 1 and moved from 17 to 18
//raju rolled a 2 and moved from 23 to 25
//ram rolled a 3 and moved from 37 to 40
//ravi rolled a 4 and moved from 45 to 49
//siva rolled a 3 and moved from 42 to 45
//rishika rolled a 5 and moved from 18 to 23
//raju rolled a 5 and moved from 25 to 30
//ram rolled a 3 and moved from 40 to 43
//ravi rolled a 4 and moved from 49 to 53
//siva rolled a 6 and moved from 45 to 51
//rishika rolled a 1 and moved from 23 to 24
//raju rolled a 1 and moved from 30 to 31
//ram rolled a 1 and moved from 43 to 44
//ravi rolled a 4 and moved from 53 to 57
//siva rolled a 6 and moved from 51 to 57
//rishika rolled a 2 and moved from 24 to 26
//raju rolled a 4 and moved from 31 to 35
//ram rolled a 5 and moved from 44 to 49
//ravi rolled a 5 and moved from 57 to 62
//siva rolled a 5 and moved from 57 to 62
//rishika rolled a 5 and moved from 26 to 31
//raju rolled a 5 and moved from 35 to 40
//ram rolled a 3 and moved from 49 to 52
//ravi rolled a 4 and moved from 62 to 66
//siva rolled a 4 and moved from 62 to 66
//rishika rolled a 1 and moved from 31 to 31
//raju rolled a 5 and moved from 40 to 45
//ram rolled a 3 and moved from 52 to 34
//ravi rolled a 5 and moved from 66 to 71
//siva rolled a 4 and moved from 66 to 70
//rishika rolled a 2 and moved from 31 to 33
//raju rolled a 4 and moved from 45 to 49
//ram rolled a 5 and moved from 34 to 39
//ravi rolled a 2 and moved from 71 to 73
//siva rolled a 5 and moved from 70 to 75
//rishika rolled a 4 and moved from 33 to 37
//raju rolled a 2 and moved from 49 to 51
//ram rolled a 2 and moved from 39 to 41
//ravi rolled a 2 and moved from 73 to 75
//siva rolled a 6 and moved from 75 to 81
//rishika rolled a 6 and moved from 37 to 43
//raju rolled a 3 and moved from 51 to 54
//ram rolled a 1 and moved from 41 to 42
//ravi rolled a 4 and moved from 75 to 79
//siva rolled a 1 and moved from 81 to 82
//rishika rolled a 2 and moved from 43 to 45
//raju rolled a 2 and moved from 54 to 56
//ram rolled a 2 and moved from 42 to 44
//ravi rolled a 1 and moved from 79 to 80
//siva rolled a 1 and moved from 82 to 83
//rishika rolled a 1 and moved from 45 to 46
//raju rolled a 3 and moved from 56 to 59
//ram rolled a 6 and moved from 44 to 50
//ravi rolled a 2 and moved from 80 to 82
//siva rolled a 1 and moved from 83 to 83
//rishika rolled a 3 and moved from 46 to 49
//raju rolled a 2 and moved from 59 to 61
//ram rolled a 3 and moved from 50 to 53
//ravi rolled a 5 and moved from 82 to 87
//siva rolled a 5 and moved from 83 to 88
//rishika rolled a 6 and moved from 49 to 34
//raju rolled a 1 and moved from 61 to 62
//ram rolled a 4 and moved from 53 to 57
//ravi rolled a 3 and moved from 87 to 90
//siva rolled a 3 and moved from 88 to 91
//rishika rolled a 3 and moved from 34 to 37
//raju rolled a 4 and moved from 62 to 66
//ram rolled a 5 and moved from 57 to 62
//ravi rolled a 3 and moved from 90 to 93
//siva rolled a 3 and moved from 91 to 94
//rishika rolled a 1 and moved from 37 to 38
//raju rolled a 4 and moved from 66 to 70
//ram rolled a 3 and moved from 62 to 65
//ravi rolled a 5 and moved from 93 to 98
//siva rolled a 2 and moved from 94 to 96
//rishika rolled a 1 and moved from 38 to 39
//raju rolled a 4 and moved from 70 to 74
//ram rolled a 2 and moved from 65 to 67
//ravi rolled a 4 and moved from 98 to 98
//siva rolled a 4 and moved from 96 to 100
//raju rolled a 2 and moved from 74 to 76
//ram rolled a 2 and moved from 67 to 69
//ravi rolled a 3 and moved from 98 to 98
//rishika rolled a 2 and moved from 39 to 41
//raju rolled a 2 and moved from 76 to 78
//ram rolled a 2 and moved from 69 to 71
//ravi rolled a 1 and moved from 98 to 99
//rishika rolled a 6 and moved from 41 to 47
//raju rolled a 3 and moved from 78 to 81
//ram rolled a 5 and moved from 71 to 76
//ravi rolled a 1 and moved from 99 to 100
//rishika rolled a 6 and moved from 47 to 53
//raju rolled a 3 and moved from 81 to 81
//ram rolled a 6 and moved from 76 to 82
//rishika rolled a 3 and moved from 53 to 56
//raju rolled a 2 and moved from 81 to 83
//ram rolled a 4 and moved from 82 to 86
//rishika rolled a 2 and moved from 56 to 58
//raju rolled a 4 and moved from 83 to 87
//ram rolled a 3 and moved from 86 to 89
//rishika rolled a 6 and moved from 58 to 58
//raju rolled a 2 and moved from 87 to 89
//ram rolled a 1 and moved from 89 to 90
//rishika rolled a 1 and moved from 58 to 59
//raju rolled a 5 and moved from 89 to 94
//ram rolled a 2 and moved from 90 to 92
//rishika rolled a 5 and moved from 59 to 59
//raju rolled a 6 and moved from 94 to 100
//rishika rolled a 2 and moved from 59 to 61
//ram rolled a 1 and moved from 92 to 93
//rishika rolled a 4 and moved from 61 to 65
//ram rolled a 2 and moved from 93 to 95
//rishika rolled a 2 and moved from 65 to 67
//ram rolled a 4 and moved from 95 to 99
//rishika rolled a 4 and moved from 67 to 71
//ram rolled a 1 and moved from 99 to 100
//*********************************Game is Completed*********************************
//                                      Winners
//                               siva Secured Position 1
//                               ravi Secured Position 2
//                               raju Secured Position 3
//                               ram Secured Position 4