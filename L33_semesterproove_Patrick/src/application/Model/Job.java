package application.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    // attributes
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;

    // // composition --> 0..* Vagt
    private final ArrayList <Vagt> vagter = new ArrayList<>();

    // constructor for Job
    public Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    // attribute --> kode (GET)
    public String getKode() {
        return kode;
    }

    // attribute --> beskrivelse (GET)
    public String getBeskrivelse() {
        return beskrivelse;
    }

    // attribute --> dato (GET)
    public LocalDate getDato() {
        return dato;
    }

    // attribute --> timeHonorar (GET)
    public int getTimeHonorar() {
        return timeHonorar;
    }

    // attribute --> antalTimer (GET)
    public int getAntalTimer() {
        return antalTimer;
    }

    // double composition --> 0..* Vagt (GET)
    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    // double composition --> 0..* Vagt (CREATE)
    public Vagt createVagt(int timer, Frivillig frivillig) {
        Vagt vagt = new Vagt(timer, this, frivillig);
        vagter.add(vagt);
        return vagt;
    }

    // double composition --> 0..* Vagt (REMOVE)
    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
        }
    }

    // METHOD returns the number of hours not yet assigned to the job
    public int ikkeBesatteTimer() {
        int sum = 0;
        for (Vagt vagt : vagter) {
            sum += vagt.getTimer();
        }
        return antalTimer - sum;
    }

    @Override
    public String toString() {
        return kode + ", " + beskrivelse + ", " + antalTimer;
    }

    public String getTitel() {
        return kode;
    }

    public Frivillig[] getFrivillige() {
        ArrayList<Frivillig> frivillige = new ArrayList<>();
        for (Vagt vagt : vagter) {
            frivillige.add(vagt.getFrivillig());
        }
        return frivillige.toArray(new Frivillig[0]);
    }

    public void decrementTimer(int hours) {
        antalTimer -= hours;
    }
}
