package opgave1;

import java.util.ArrayList;
import java.util.SortedMap;

public class Test {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        Player p1 = new Player("Mikkel",190,92,5);
        Player p2 = new Player("Anders",196,116,10);
        Player p3 = new Player("Thor",180,74,15);
        Player p4 = new Player("Rasmus",189,82,20);
        Player p5 = new Player("Emil",180,96,25);
        Player p6 = new Player("Steffen",190,100,30);

        players.add(p6);
        players.add(p5);
        players.add(p4);
        players.add(p3);
        players.add(p2);
        players.add(p1);

        System.out.println(players);
        System.out.println(findPlayerLinear(players, 14));
        System.out.println(findPlayerBinary(players,25));






    }

    public static Player findPlayerLinear(ArrayList<Player> players, int score){
        Player player = null;
        int i = 0;
        while (player == null && i < players.size()){
            int k = players.get(i).getScoredGoals();
            if (k == score){
                player = players.get(i);
            } else {
                i++;
            }
        } return player;
    }

    public static Player findPlayerBinary(ArrayList<Player> players, int score){
        Player player = null;
        int left = 0;
        int right = players.size()-1;
        while (player == null && left <= right){
            int middle = (left + right)/2;
            Player p = players.get(middle);
            if (p.getScoredGoals() == score){
                player = p;
            } else if (p.getScoredGoals() < score){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } return player;
    }
}
