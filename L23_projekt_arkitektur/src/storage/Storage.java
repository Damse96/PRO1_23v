
package storage;

import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();

    private static ArrayList<Kunde> kunder = new ArrayList<>();

    private static ArrayList<Plads> pladser = new ArrayList<>();


    public static ArrayList<Forestilling> getForestillinger() {
        return forestillinger;
    }

    public static void addForstillinger(Forestilling forestilling) {
        forestillinger.add(forestilling);
    }

    public static void removeForstillinger(Forestilling forestilling) {
        forestillinger.remove(forestilling);
    }

    //-------------------------------------------------------------------------

    public static ArrayList<Kunde> getKunder() {
        return kunder;
    }

    public static void addKunder(Kunde kunde) {
        kunder.add(kunde);
    }

    public static void removeKunde(Kunde kunde) {
        kunder.remove(kunde);
    }

    //-------------------------------------------------------------------------


    public static ArrayList<Plads> getPladser() {
        return pladser;
    }
    public static void addPlads(Plads plads) {
        pladser.add(plads);
    }

    public static void removePlads(Plads plads) {
        pladser.remove(plads);
    }

    //-------------------------------------------------------------------------

}
