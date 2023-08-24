package application.model;

import java.util.ArrayList;

public class Frivillig {
    private String navn;

    private String mobil;

    private int maksAntalTimer;

    private final ArrayList<Vagt> vagter = new ArrayList<>();

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

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    public int ledigeTimer(){
        return 0;
    }
}
