package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private String beskrivelse;
    private LocalDate dato;
    private double pris;
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

Udflugt(String navn, String beskrivelse, LocalDate dato, double pris) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.pris = pris;
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.addUdflugt(this);
        }
    }

    public void removeLedsager(Ledsager ledsager) {
        if (ledsagere.contains(ledsager)) {
            ledsagere.remove(ledsager);
            ledsager.removeUdflugt(this);
        }
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public double getPris() {
        return pris;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    @ Override
    public String toString() {
        return navn + " " +
                " " + dato + " " +
                pris + " " + beskrivelse;
    }
}
