package storage;

import application.Model.Festival;
import application.Model.Frivillig;

import java.util.ArrayList;

public class Storage {
    // lists
    private static ArrayList<Festival> festivaller = new ArrayList<>();
    private static ArrayList<Frivillig> frivillige = new ArrayList<>();

    // -------------------------------- FESTIVAL -----------------------------
    // METHOD returning a list of all Festivals
    public static ArrayList<Festival> getFestivaller() {
        return new ArrayList<>(festivaller);
    }

    // METHOD adding a Festival to the list of Festivals
    public static void addFestival(Festival festival) {
        festivaller.add(festival);
    }

    // -------------------------------- FRIVILLIG -----------------------------
    // METHOD returning a list of all Frivillige
    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    // METHOD adding a Frivillig to the list of Frivillige
    public static void addFrivillig(Frivillig frivillig) {
        frivillige.add(frivillig);
    }

}
