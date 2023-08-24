package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Kunde createKunde(String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunder(kunde);
        return kunde;
    }

    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForstillinger(forestilling);
        return forestilling;
    }

    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
        return plads;
    }


    public static ArrayList<Forestilling> getForestillinger() {
        return Storage.getForestillinger();
    }

    public static ArrayList<Kunde> getKunder() {
        return Storage.getKunder();
    }

    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling = null;
        boolean erOptaget = false;

        if (dato.isAfter(forestilling.getStartDate()) && dato.isBefore(forestilling.getSlutDate())){
        for (int i = 0; i < pladser.size(); i++) {
            if (forestilling.erPladsLedig(pladser.get(i).getRække(), pladser.get(i).getNr(), dato)) {
                erOptaget = true;
            }
        }}
        if (!erOptaget) {
            forestilling.createBestilling(dato);
            for (int i = 0; i < pladser.size(); i++) {
                bestilling.addPlads(pladser.get(i));
            }
            bestilling.setKunde(kunde);


        }
        return bestilling;
    }
}
