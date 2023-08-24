package application.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Festival {
    // attributes
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;

    // // composition --> 0..* Job
    private final ArrayList <Job> jobs = new ArrayList<>();
    private final ArrayList <Frivillig> frivillige = new ArrayList<>();
    private FrivilligForening frivilligForening;
    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    // attribute --> navn (GET)
    public String getNavn() {
        return navn;
    }

    // attribute --> fraDato (GET)
    public LocalDate getFraDato() {
        return fraDato;
    }

    // attribute --> tilDato (GET)
    public LocalDate getTilDato() {
        return tilDato;
    }

    // oneway composition --> 0..* Job (GET)
    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    // oneway composition --> 0..* Job (CREATE)
    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    // METHOD returning the total budgeted job expense
    public int budgetteretJobUdgift() {
        int sum = 0;
        for (Job job : jobs) {
            sum += job.getTimeHonorar() * job.getAntalTimer();
        }
        return sum;
    }

    // METHOD returning the total realized job expense by summing the vagt hours
    public int realiseretJobUdgift() {
        int sum = 0;
        for (Job job : jobs) {
            for (Vagt vagt : job.getVagter()) {
                sum += vagt.getTimer() * job.getTimeHonorar();
            }
        }
        return sum;
    }

    public void addFrivillig(Frivillig frivillig) {
        if (!frivillige.contains(frivillig)) {
            frivillige.add(frivillig);
        }
    }

    public void addFrivilligForening(FrivilligForening frivilligForening) {
        if (!frivillige.contains(frivilligForening)) {
            frivillige.add(frivilligForening);
            this.frivilligForening = frivilligForening;
        }
    }

    public FrivilligForening getFrivilligForening() {
        return frivilligForening;
    }

    // METHOD returning sorted list of all frivillige representing their gifts
    public ArrayList<String> gaverTilFrivillige() {

        // Create a list of strings representing the gifts
        ArrayList<String> gaveliste = new ArrayList<>();

        // For each frivillig, create a string representing the gift
        for (Frivillig frivillig : frivillige) {

            // Create a string representing the gift
            String gavelisteLinje;

            // If the frivillig has a FrivilligForening, the string includes friwillig name, number of persons and foreningsnavn
            if (frivillig instanceof FrivilligForening) {
                FrivilligForening frivilligForening = (FrivilligForening) frivillig;
                gavelisteLinje = frivillig.getNavn() + ", " + frivilligForening.getAntalPersoner() + ", " + frivilligForening.getForeningsnavn();
            }

            // If the frivillig has no FrivilligForening, the string includes friwillig name + 1 (number of persons)
            else {
                gavelisteLinje = frivillig.getNavn() + ", 1";
            }

            // Add the string to the list of strings
            gaveliste.add(gavelisteLinje);
        }

        // Sort the list of strings alphabetically
        Collections.sort(gaveliste);

        // Return the list of strings
        return gaveliste;
    }

    public ArrayList<Frivillig> getFrivillige() {
        return frivillige;
    }

    @Override
    public String toString() {
        return navn;
    }

    public void addJob(Job job) {
        if (!jobs.contains(job)) {
            jobs.add(job);
        }
    }
}
