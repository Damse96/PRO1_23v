package application.controller;

import application.Model.Bane;
import application.Model.Kategori;
import application.Model.Spiller;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class Controller {

    //alle skal oprettes bortset fra booking

    public static Spiller opretSpiller(String navn, String uddannelse) {

        Spiller spiller = new Spiller(navn, uddannelse);

        Storage.addSpiller(spiller);

        return spiller;
    }

    public static Bane opretBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid) {

        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid);

        Storage.addBane(bane);

        return bane;
    }


    public static Kategori opretKategori(String navn, int prisKrSingle, int prisKrDouble) {

        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);

        Storage.addKategori(kategori);

        return kategori;
    }

}