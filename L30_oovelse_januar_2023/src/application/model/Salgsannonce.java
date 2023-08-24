package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {

    private static int antalAnnoncer;

    private int annonceNummer;

    private boolean aktiv;

    private LocalDate udløbsDato;

    private Sælger sælger;

    private final ArrayList<Vare> vares = new ArrayList<>();

    public Salgsannonce(int antalAnnoncer, int annonceNummer, boolean aktiv, LocalDate udløbsDato) {
        this.antalAnnoncer = antalAnnoncer;
        this.annonceNummer = annonceNummer;
        this.aktiv = aktiv;
        this.udløbsDato = udløbsDato;
    }

    public static int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsDato() {
        return udløbsDato;
    }

    public ArrayList<Vare> getVares() {
        return vares;
    }

    public Sælger getSælger() {
        return sælger;
    }

    public void addVare(Vare vare) {
        if (!vares.contains(vare)) {
            vares.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void setSælger(Sælger sælger) {
        if (this.sælger != sælger) {
            Sælger oldSælger = this.sælger;
            if (sælger != null) {
                oldSælger.removeSalgsAnnonce(this);
            }
            this.sælger = sælger;
            if (sælger != null) {
                sælger.addSalgsAnnonce(this);
            }
        }
    }


    public int samletAnnonceUdbud(Vare vare){
        int sum = 0;
        sum += vare.getUdbudsPris();
        return sum;
    }

    @Override
    public String toString() {
        return "Salgsannonce{" +
                "annonceNummer=" + annonceNummer +
                ", aktiv=" + aktiv +
                ", udløbsDato=" + udløbsDato +
                ", sælger=" + sælger +
                ", vares=" + vares +
                '}';
    }
}