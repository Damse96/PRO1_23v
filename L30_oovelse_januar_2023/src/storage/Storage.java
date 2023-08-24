package storage;


import application.model.Salg;
import application.model.Salgsannonce;
import application.model.Sælger;
import application.model.Vare;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Sælger> sælgers = new ArrayList<>();

    private static ArrayList<Salg> salgs = new ArrayList<>();

    private static ArrayList<Vare> vares = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Sælger> getSælgers() {
        return new ArrayList<>(sælgers);
    }

    public static void addSælger(Sælger sælger) {
        sælgers.add(sælger);
    }


    // -------------------------------------------------------------------------

    public static ArrayList<Salg> getSalgs() {
        return new ArrayList<>(salgs);
    }

    public static void addSalg(Salg salg) {
        salgs.add(salg);
    }


    // -------------------------------------------------------------------------

    public static ArrayList<Vare> getVares() {
        return new ArrayList<>(vares);
    }

    public static void addVare(Vare vare) {
        vares.add(vare);
    }



}
