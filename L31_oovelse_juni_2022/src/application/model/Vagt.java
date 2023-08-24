package application.model;

import java.lang.module.ModuleDescriptor;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vagt {
    private String navn;

    private LocalDateTime tidFra;

    private LocalDateTime tidTil;

    private final ArrayList<Antal> antals = new ArrayList<>();

    private final ArrayList<Medarbejder> medarbejders = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public ArrayList<Antal> getAntals() {
        return antals;
    }

    public ArrayList<Medarbejder> getMedarbejders() {
        return medarbejders;
    }

    public Antal createAntal(int antal) {
        Antal antaller = new Antal(antal);
        antals.add(antaller);
        return antaller;
    }

    public void removeAnatal(Antal antal) {
        if (antals.contains(antal)) {
            antals.remove(antal);
        }
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejders.contains(medarbejder)) {
            medarbejders.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    /**
     * Removes the person from this group and the grop from the person,
     * if they are connected.
     */
    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejders.contains(medarbejder)) {
            medarbejders.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }
}
