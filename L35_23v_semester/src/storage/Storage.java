package storage;

import application.Model.Bane;
import application.Model.Kategori;
import application.Model.Spiller;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Spiller> spillers = new ArrayList<>();
    private static ArrayList<Bane> baner = new ArrayList<>();

    private static ArrayList<Kategori> kategoris = new ArrayList<>();


    // -------------------------------- -----------------------------

    public static ArrayList<Spiller> getSpiller() {
        return new ArrayList<>(spillers);
    }

    public static void addSpiller(Spiller spiller) {
        spillers.add(spiller);
    }

    // --------------------------------  -----------------------------

    public static ArrayList<Bane> getBane() {
        return new ArrayList<>(baner);
    }

    public static void addBane(Bane bane) {
        baner.add(bane);
    }
    // --------------------------------  -----------------------------
    public static ArrayList<Kategori> getKategori() {
        return new ArrayList<>(kategoris);
    }

    public static void addKategori(Kategori kategori) {
        kategoris.add(kategori);
    }
    // --------------------------------  -----------------------------

}
