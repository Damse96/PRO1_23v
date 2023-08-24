package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String sted;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double prisPrDag;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();

    public Konference(String navn, String sted, LocalDate startDato, LocalDate slutDato, double prisPrDag) {
        this.navn = navn;
        this.sted = sted;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.prisPrDag = prisPrDag;
    }

    public Udflugt createUdflugt(String navn, String beskrivelse, LocalDate dato, double pris) {
        Udflugt udflugt = new Udflugt(navn, beskrivelse, dato, pris);
        udflugter.add(udflugt);
        return udflugt;
    }
    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }
    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
        }
    }
    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }
    public void removeHotel(Hotel hotel) {
        if (hoteller.contains(hotel)) {
            hoteller.remove(hotel);
        }
    }
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setKonference(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setKonference(null);
        }
    }
    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public double getPrisPrDag() {
        return prisPrDag;
    }

    @Override
    public String toString() {
        return navn + '\'' +
                ", Sted: " + sted + '\'' +
                ", startdato: " + startDato +
                ", slutdato: " + slutDato;
    }
}
