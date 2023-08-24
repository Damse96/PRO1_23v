package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private String navn;

    private LocalDate fraDato;

    private LocalDate tilDato;

    private final ArrayList<Job> jobs = new ArrayList<>();

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift(){
        int sum = 0;
        for(Job job : jobs){
            sum += job.getTimeHonorar() * job.getAntalTimer();
        } return sum;
    }

    public int realiseretJobUdgift() {
        int sumAfTimer = 0;
        for (Job job : jobs) {
            for (Vagt vagt : job.getVagts()) {
                sumAfTimer+= job.getTimeHonorar() * job.getAntalTimer();
            }

        }return sumAfTimer;
    }
}
