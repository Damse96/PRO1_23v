package application.model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adresse;
    private double dobbeltværelsePris;
    private double enkeltværelsePris;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Hotel(String navn, String adresse, double dobbeltværelsePris, double enkeltværelsePris) {
        this.navn = navn;
        this.adresse = adresse;
        this.dobbeltværelsePris = dobbeltværelsePris;
        this.enkeltværelsePris = enkeltværelsePris;
    }
    public Tillæg createTillæg(String navn, double pris) {
        Tillæg tillæg = new Tillæg(navn, pris);
        this.tillæg.add(tillæg);
        return tillæg;
    }
    public void removeTillæg(Tillæg tillæg) {
        if (this.tillæg.contains(tillæg)) {
            this.tillæg.remove(tillæg);
        }
    }
    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public double getDobbeltværelsePris() {
        return dobbeltværelsePris;
    }

    public double getEnkeltværelsePris() {
        return enkeltværelsePris;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }

    @Override
    public String toString(){
        return navn + ", Kr. " + dobbeltværelsePris + "/" + enkeltværelsePris;
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }
}
