package opgave3_insertionSort;

import java.util.Random;

public class Player {
    private String name;
    private int score;
    private int age;
    Random random = new Random();


    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        score = random.nextInt(30) + 1;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", score = " + score +
                '}';
    }

    public int getScore() {
        return score;
    }

//    public void setScore() {
//        Random random = new Random();
//        this.score = random.nextInt(30) + 1;
//    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
