package application.controller;

import application.Model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    // ---------------------------------- FESTIVAL ----------------------------------
    // METHOD creating a Festival object and adding it to the Storage list of festivals
    public static Festival opretFestival(String navn, LocalDate fraDato, LocalDate tilDato) {

        Festival festival = new Festival(navn, fraDato, tilDato);

        Storage.addFestival(festival);

        return festival;
    }

    // ---------------------------------- Frivillig ----------------------------------
    // METHOD creating a Frivillig object and adding it to the Storage list of frivillige
    public static Frivillig opretFrivillig(String navn, String mobil, int maksAntalTimer) {

        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);

        Storage.addFrivillig(frivillig);

        return frivillig;
    }

    // ------------------------------- FrivilligForening ----------------------------------
    // METHOD creating a FrivilligForening object and adding it to the Storage list of frivillige
    public static FrivilligForening opretFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsnavn, int antalPersoner) {

        FrivilligForening frivilligForening = new FrivilligForening(navn, mobil, maksAntalTimer, foreningsnavn, antalPersoner);

        Storage.addFrivillig(frivilligForening);

        return frivilligForening;
    }

    // initStorage method for testing purposes
    public static void initStorage() {

        // Create festivals
        Festival festival1 = Controller.opretFestival("Northside", LocalDate.of(2020, 6, 4), LocalDate.of(2020, 6, 6));
        Festival festival2 = Controller.opretFestival("Roskilde", LocalDate.of(2020, 6, 29), LocalDate.of(2020, 7, 6));

        // Create frivillige
        Frivillig frivillig1 = Controller.opretFrivillig("Jane Jensen", "12345677", 20);
        Frivillig frivillig2 = Controller.opretFrivillig("Lone Hansen", "78787878", 25);
        Frivillig frivillig3 = Controller.opretFrivillig("Anders Mikkelsen", "55555555", 10);

        // Create frivilligForening
        FrivilligForening frivilligForening1 = Controller.opretFrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        // Add frivillige to festival1
        festival1.addFrivillig(frivillig1);
        festival1.addFrivillig(frivillig2);
        festival1.addFrivillig(frivillig3);

        // Add frivilligForening to festival1
        festival1.addFrivilligForening(frivilligForening1);

        // Create jobs
        Job job1 = festival1.createJob("T1", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
        Job job2 = festival1.createJob("T2", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
        Job job3 = festival1.createJob("T3", "Rengøring af toilet", LocalDate.of(2020, 6, 4), 100, 5);
        Job job4 = festival1.createJob("T4", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
        Job job5 = festival1.createJob("T5", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
        Job job6 = festival1.createJob("T6", "Rengøring af toilet", LocalDate.of(2020, 6, 5), 100, 5);
        Job job7 = festival1.createJob("T7", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);
        Job job8 = festival1.createJob("T8", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);
        Job job9 = festival1.createJob("T9", "Rengøring af toilet", LocalDate.of(2020, 6, 6), 100, 5);

        // Add jobs to festival1
        festival1.addJob(job1);
        festival1.addJob(job2);
        festival1.addJob(job3);
        festival1.addJob(job4);
        festival1.addJob(job5);
        festival1.addJob(job6);
        festival1.addJob(job7);
        festival1.addJob(job8);
        festival1.addJob(job9);

        // Assign jobs to frivillige with hours
        tagVagt(job1, frivillig1, 4);
        tagVagt(job2, frivillig1, 5);

        // Create list of gifts for festival1
        ArrayList<String> gaveliste = festival1.gaverTilFrivillige();

        // Print out the list of gifts for festival1
        System.out.println("Gaveliste for " + festival1.getNavn() + ":");
        for (String gavelisteLinje : gaveliste) {
            System.out.println(gavelisteLinje);
        }

        System.out.println("Result of findFrivillig: " + findFrivillig(festival1, "Jane Jensen"));
    }

    // METHOD creating a Vagt object and adding it to the Storage list of vagter
    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {

        // Check if the job has enough hours left
        if (job.ikkeBesatteTimer() < timer) {
            throw new IllegalArgumentException("Jobbet har ikke nok timer tilbage");
        }
        // Check if the frivillig has enough hours left
        if (frivillig.ledigeTimer() < timer) {
            throw new IllegalArgumentException("Frivillig har ikke nok timer tilbage");
        }

        // Create the new Vagt
        Vagt vagt = new Vagt(timer, job, frivillig);

        // Add the Vagt to the frivillig
        frivillig.addVagt(vagt);

        // Decrement the job's available hours
        job.decrementTimer(timer);

        return vagt;
    }

    // METHOD finding a frivillig in a festival
    public static boolean findFrivillig(Festival festival, String navn) {

        // Create list of gifts for a festival
        ArrayList<String> gaveliste = festival.gaverTilFrivillige();

        int indeks = -1;
        int left = 0;
        int right = gaveliste.size() - 1;

        while (indeks == -1 && left <= right) {
            int middle = (left + right) / 2;
            String currentLine = gaveliste.get(middle);
            String currentName = currentLine.split(",")[0].trim(); // Split the line and get the name

            int k = currentName.compareTo(navn);

            if (k == 0) {
                indeks = middle;
            } else if (k > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return indeks != -1;
    }
}
