package storage;

import application.controller.Controller;
import application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static ArrayList<Tillæg> tillæg = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public static void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public static void removeLedsager(Ledsager ledsager) {
        ledsagere.remove(ledsager);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public static void addTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public static void removeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public static void addTillæg(Tillæg tillæg) {
        Storage.tillæg.add(tillæg);
    }

    public static void removeTillæg(Tillæg tillæg) {
        Storage.tillæg.remove(tillæg);
    }

//    ---------------------------------------------------------------------------
public static void initStorage() {
    Konference havOgHimmel = Controller.createKonference("Hav og Himmel",  LocalDate.of(2023, 5, 18), LocalDate.of(2023, 5, 20),"Odense Universitet", 1500 );
    Deltager d1 = Controller.createDeltager("Finn Madsen", "Lortevej 123", "Danmark", "12341234", "Finn inc.", "12121212");
    Deltager d2 = Controller.createDeltager("Niels Petersen", "Lortevej 123", "Danmark", "12341234", "Finn inc.", "12121212");
    Deltager d3 = Controller.createDeltager("Peter Sommer" ,"Lortevej 123", "Danmark", "12341234", "Finn inc.", "12121212");
    Deltager d4 = Controller.createDeltager("Lone Jensen", "Lortevej 123", "Danmark", "12341234", "Finn inc.", "12121212");
    Ledsager l1 = Controller.createLedsager(d3, "Mie Sommer");
    Ledsager l2 = Controller.createLedsager(d4, "Jan Madsen");


    Hotel h1 = Controller.createHotel("Den Hvide Svane ","Svanevej 40", 1250, 1050);
    Hotel h2 = Controller.createHotel("Hotel Phønix", "Phønixvej 40", 800, 700);
    Hotel h3 = Controller.createHotel("Pension Tusindfryd", "Frydvej 40", 600, 500);
    Tillæg a1 = Controller.createTillæg(h1, "WIFI", 50);
    Tillæg a2 = Controller.createTillæg(h2, "Bad", 200);
    Tillæg a3 = Controller.createTillæg(h2, "WIFI", 75);
    Tillæg a4 = Controller.createTillæg(h3, "Morgenmad", 100);
    Udflugt u1 = Controller.createUdflugt(havOgHimmel,"By rundtur", LocalDate.of(2023, 5, 18),125, "Odense" );
    Udflugt u2 = Controller.createUdflugt(havOgHimmel, "Egeskov", LocalDate.of(2023, 5,19), 75, "Egeskovslot flot tur hehe");
    Udflugt u3 = Controller.createUdflugt(havOgHimmel, "Trapholdt museum", LocalDate.of(2023,5,20), 200, "Kolding");





    Tilmelding t1 = Controller.createTilmelding(false, LocalDate.of(2023, 5, 18), LocalDate.of(2023,5,20), d1, havOgHimmel, false, null);
    Tilmelding t2 = Controller.createTilmelding(false, LocalDate.of(2023, 5, 18), LocalDate.of(2023,5,20), d2, havOgHimmel, false, h1);
    Tilmelding t3 = Controller.createTilmelding(false, LocalDate.of(2023,5,18), LocalDate.of(2023, 5,20),d3, havOgHimmel, true, h1);

    t3.addTillæg(a1);


    l1.addUdflugt(u3);
    l1.addUdflugt(u2);

    Tilmelding t4 = Controller.createTilmelding(true, LocalDate.of(2023,5,18), LocalDate.of(2023, 5,20), d4, havOgHimmel, true, h1);
    l2.addUdflugt(u2);
    l2.addUdflugt(u1);
    t4.addTillæg(a1);
    havOgHimmel.addHotel(h1);
    havOgHimmel.addHotel(h2);
    havOgHimmel.addHotel(h3);

}
}
