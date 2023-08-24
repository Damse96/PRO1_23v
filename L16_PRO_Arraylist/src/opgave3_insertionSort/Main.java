package opgave3_insertionSort;


public class Main {

    public static void main(String[] args) {
        Team t1 = new Team("A");
        Player p1 = new Player("Esben", 40);
        Player p2 = new Player("Kasper", 40);
        Player p3 = new Player("Troels", 32);
        Player p4 = new Player("Tully", 36);
        Player p5 = new Player("Jakob", 24);
        Player p6 = new Player("Bent", 47);
        Player p7 = new Player("Bo", 20);
        Player p8 = new Player("Hans", 37);
        Player p9 = new Player("Alexander", 29);
        Player p10 = new Player("Dommi", 28);

        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);
        t1.addPlayer(p4);
        t1.addPlayer(p5);
        t1.addPlayer(p6);
        t1.addPlayer(p7);
        t1.addPlayer(p8);
        t1.addPlayer(p9);
        t1.addPlayer(p10);

        System.out.println(t1.toString());

        t1.printPlayers();
        System.out.println("\nOld players score: " + t1.calcOldPlayerScore(37) + "\n");

        System.out.println("Max score: " + t1.maxScore() + "\n");

        System.out.println("Average age is: " + t1.calcAverageAge() + "\n");

        System.out.println("Name of best player(s): " + t1.bestPlayerNames() + "\n");

        System.out.println(t1.toString() + "'s total score is: " + t1.calcTotalScore());



    }
}
