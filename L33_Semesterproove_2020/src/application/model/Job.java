package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;

    private String beskrivelse;

    private LocalDate dato;

    private int timeHonorar;

    private int antalTimer;

    private final ArrayList<Vagt> vagts = new ArrayList<>();

    public Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public ArrayList<Vagt> getVagts() {
        return vagts;
    }

    public Vagt createVagt(int timer, Job job) {
        Vagt vagt = new Vagt(timer, this);
        vagts.add(vagt);
        return vagt;
    }

    public void removeVagt(Vagt vagt) {
        if (vagts.contains(vagt)) {
            vagts.remove(vagt);
        }
    }

    public int ikkeBesatteTimer(){
        int sum = 0;
        for (Vagt vagt : vagts){
            sum += vagt.getTimer();
        } return antalTimer - sum;
    }
}


