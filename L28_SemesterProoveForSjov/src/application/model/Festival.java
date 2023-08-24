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

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift(Job job){
        int sum = 0;
        sum = job.getTimeHonorar() * job.getAntalTimer();
        return sum;
    }

    public int realiseretJobUdgift(){
        return 0;
    }
}
