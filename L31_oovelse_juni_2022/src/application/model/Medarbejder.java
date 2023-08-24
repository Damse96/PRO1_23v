package application.model;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {

    private String navn;

    private int antalTimerPrDag;

    private LocalTime typiskMødetid;

    private final ArrayList<Vagt> vagts = new ArrayList<>();

    private final ArrayList<Funktion> funktions = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Vagt> getVagts() {
        return vagts;
    }

    public void addVagt(Vagt vagt) {
        if (!vagts.contains(vagt)) {
            vagts.add(vagt);
            vagt.addMedarbejder(this);
        }
    }

    /**
     * Removes the group from this person and the person from the group,
     * if they are connected
     */
    public void removeVagt(Vagt vagt) {
        if (vagts.contains(vagt)) {
            vagts.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }
}
