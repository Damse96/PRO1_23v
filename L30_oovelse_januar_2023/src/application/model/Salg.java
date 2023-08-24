package application.model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;

    private int aftaltSamletPris;

    private final ArrayList<Vare> vares = new ArrayList<>();


    public Salg(String købersNavn, int aftaltSamletPris) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public void setKøbersNavn(String købersNavn) {
        this.købersNavn = købersNavn;
    }

    public void setAftaltSamletPris(int aftaltSamletPris) {
        this.aftaltSamletPris = aftaltSamletPris;
    }

    public ArrayList<Vare> getVares() {
        return vares;
    }

    public void addVare(Vare vare) {
        if (!vares.contains(vare)) {
            vares.add(vare);
        }
    }

    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeVare(Vare vare) {
        if (vares.contains(vare)) {
            vares.remove(vare);
        }
    }
}
