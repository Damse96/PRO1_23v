package application.model;

import java.util.ArrayList;

public class Frivillig {
    private String navn;

    private String mobil;

    private int maksAntalTimer;

    private final ArrayList<Vagt> vagts = new ArrayList<>();

    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagts() {
        return vagts;
    }

    public void addVagt(Vagt vagt) {
        if (!vagts.contains(vagt)) {
            vagts.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagts.contains(vagt)) {
            vagts.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    public int ledigeTimer(){
        int sum = 0;
        for (Vagt vagt : vagts){
            sum += vagt.getTimer();
        } return maksAntalTimer - sum;
    }
}
