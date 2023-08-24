package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;

    private String beskrivelse;

    private LocalDate dato;

    private int timeHonorar;

    private int antalTimer;

    private final ArrayList<Vagt> vagter = new ArrayList<>();


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

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
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

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public Vagt createVagt(int timer){
        Vagt vagt = new Vagt(timer, this);
        vagter.add(vagt);
        return vagt;
    }

    public void removeVagt(Vagt vagt){
        if (vagter.contains(vagt)){
            vagter.remove(vagt);
        }
    }
}
