package storage;

import application.model.Festival;
import application.model.Frivillig;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Festival> festivals = new ArrayList<>();

    private static ArrayList<Frivillig> frivillige = new ArrayList<>();

    // -------------------------------------------------------------------------

    public static ArrayList<Festival> getFestivals() {
        return new ArrayList<>(festivals);
    }

    public static void addFestival(Festival festival) {
        festivals.add(festival);
    }

    public static void removeFestival(Festival festival) {
        festivals.remove(festival);
    }

    // -------------------------------------------------------------------------

    public static ArrayList<Frivillig> getFrivillige() {
        return new ArrayList<>(frivillige);
    }

    public static void addFrivillig(Frivillig frivillig) {
        frivillige.add(frivillig);
    }

    public static void removeFrivillig(Frivillig frivillig) {
        frivillige.remove(frivillig);
    }

}
