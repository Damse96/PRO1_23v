package application.controller;

import application.model.Festival;
import application.model.Frivillig;
import application.model.FrivilligForening;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }
    public static ArrayList<Festival> getFestival() {
        return Storage.getFestivals();
    }

    // -------------------------------------------------------------------------

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }
    public static ArrayList<Frivillig> getFrivillig() {
        return Storage.getFrivillige();
    }



    // -------------------------------------------------------------------------

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        FrivilligForening frivilligForening = new FrivilligForening(navn,  mobil, maksAntalTimer,  foreningsNavn, antalPersoner);
        return frivilligForening;
    }

    public static void main(String[] args) {

    }

}
