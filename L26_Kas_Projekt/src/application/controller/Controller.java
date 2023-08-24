package application.controller;

import application.model.*;
import storage.Storage;
import application.model.Konference;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato, String sted, double prisPrDag) {
        Konference konference = new Konference(navn, sted, startDato, slutDato, prisPrDag);
        Storage.addKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    // -------------------------------------------------------------------------

    public static Tilmelding createTilmelding() {
        Tilmelding tilmelding = new Tilmelding();
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }
    public static Tilmelding createTilmelding(boolean foredragsholder, LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, Konference konference, boolean dobbeltværelse, Hotel hotel) {
        Tilmelding tilmelding = new Tilmelding(foredragsholder, ankomstDato, afrejseDato, deltager, konference, dobbeltværelse, hotel);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldinger();
    }

    public static double getSamletPris(Tilmelding tilmelding) {
        return tilmelding.getSamletPris();
    }

    // -------------------------------------------------------------------------

    public static Deltager createDeltager(String navn, String adresse, String land, String telefonNr, String firmaNavn, String firmaTlf) {
        Deltager deltager = new Deltager(navn, adresse, land, telefonNr, firmaNavn, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }


    // -------------------------------------------------------------------------

    public static Hotel createHotel(String navn, String adresse, double prisDobbeltVærelse, double prisEnkeltVærelse) {
        Hotel hotel = new Hotel(navn, adresse, prisDobbeltVærelse, prisEnkeltVærelse);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    // -------------------------------------------------------------------------

    public static Tillæg createTillæg(Hotel hotel, String navn, double pris) {
        Tillæg tillæg = hotel.createTillæg(navn, pris);
        Storage.addTillæg(tillæg);
        return tillæg;
    }

    public static ArrayList<Tillæg> getTillæg() {
        return Storage.getTillæg();
    }

    // -------------------------------------------------------------------------

    public static Ledsager createLedsager(Deltager deltager, String navn) {
        Ledsager ledsager = deltager.createLedsager(navn, deltager);
        Storage.addLedsager(ledsager);
        return ledsager;
    }

    public static ArrayList<Ledsager> getLedsagere() {
        return Storage.getLedsagere();
    }

    // -------------------------------------------------------------------------

    public static Udflugt createUdflugt(Konference konference, String navn, LocalDate dato, double pris, String beskrivelse) {
        Udflugt udflugt = konference.createUdflugt(navn,beskrivelse, dato, pris);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return Storage.getUdflugter();
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> hotelOversigt() {
        return Storage.getHoteller();
    }

    public static ArrayList<Konference> konferenceOversigt() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Udflugt> udflugtOversigt() {
        return Storage.getUdflugter();
    }
}
