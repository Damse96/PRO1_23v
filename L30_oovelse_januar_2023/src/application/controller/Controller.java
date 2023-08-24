package application.controller;


import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Sælger createSælger(String navn, int studiekortNummer, String mobil){
        Sælger sælger = new Sælger(navn,studiekortNummer,mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static ArrayList<Sælger> getSælger() {
        return Storage.getSælgers();
    }

    // -------------------------------------------------------------------------

    public static Vare createVare(Varekategori kategori, String navn, int udbudsPris, boolean solgt){
        Vare vare = new Vare(kategori,navn,udbudsPris,solgt);
        Storage.addVare(vare);
        return vare;
    }

    public static ArrayList<Vare> getVare() {
        return Storage.getVares();
    }

    // -------------------------------------------------------------------------

    public static Salg createSalg(String købersNavn, int aftaltSamletPris){
        Salg salg = new Salg(købersNavn,aftaltSamletPris);
        Storage.addSalg(salg);
        return salg;
    }

    public static ArrayList<Salg> getSalg() {
        return Storage.getSalgs();
    }

    // -------------------------------------------------------------------------





}