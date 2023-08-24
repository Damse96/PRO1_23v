package application.Model;

import java.util.ArrayList;

public class Frivillig {
    // attributes
    private String navn;
    private String mobil;
    private int maksAntalTimer;

    // double association --> 0..* Vagt
    private final ArrayList <Vagt> vagter = new ArrayList<>();

    // constructor for Frivillig
    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    // attribute --> navn (GET)
    public String getNavn() {
        return navn;
    }

    // attribute --> mobil (GET)
    public String getMobil() {
        return mobil;
    }

    // attribute --> maksAntalTimer (GET)
    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    // double association --> 0..* Vagt (GET)
    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    // double association --> 0..* Vagt (ADD)
    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    // double association --> 0..* Vagt (REMOVE)
    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    // METHOD returns the number of hours available for a frivillig
    public int ledigeTimer() {
        int sum = 0;
        for (Vagt vagt : vagter) {
            sum += vagt.getTimer();
        }
        return maksAntalTimer - sum;
    }

    @Override
    public String toString() {
        return navn + ", " + mobil + ", " + maksAntalTimer;
    }
}
