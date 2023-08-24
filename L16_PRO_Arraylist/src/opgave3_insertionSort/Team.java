package opgave3_insertionSort;

import java.util.ArrayList;

public class Team {

   private String name;
   private ArrayList<Player> players;


    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Team " +
                 name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public void printPlayers() {
        for (Player p : players) {
            System.out.println(p.toString());
        }
    }

    public double calcAverageAge() {
        double sum = 0;
        for (Player p : players) {
            sum += p.getAge();
        }
        return sum / players.size();
    }

    public int calcTotalScore() {
        int total = 0;
        for (Player p : players) {
            total += p.getScore();
        }
        return total;
    }

    public int calcOldPlayerScore(int ageLimit) {
        int total = 0;
        for (Player p : players) {
            if (p.getAge() >= ageLimit) {
                total += p.getScore();
            }
        }
        return total;
    }

    public int maxScore() {
        int max = Integer.MIN_VALUE;

        for (Player p : players) {
            if (p.getScore() > max) {
                max = p.getScore();
            }
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> bestPlayerNames = new ArrayList<>();

        for (Player p : players) {
            if (p.getScore() == maxScore()) {
                bestPlayerNames.add(p.getName());
            }
        }
        return bestPlayerNames;
    }



}
