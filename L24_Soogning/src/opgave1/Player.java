package opgave1;

public class Player {
    private String navn;

    private int height;

    private int weight;

    private int scoredGoals;

    public Player(String navn, int height, int weight, int scoredGoals) {
        this.navn = navn;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Override
    public String toString() {
        return "Player{" +
                "navn='" + navn + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", scoredGoals=" + scoredGoals +
                '}';
    }
}
