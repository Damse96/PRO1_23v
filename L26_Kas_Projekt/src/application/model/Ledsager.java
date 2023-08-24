package application.model;

import java.util.ArrayList;

public class Ledsager {
    private String navn;
    private Deltager deltager;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Ledsager(String navn, Deltager deltager) {
        this.navn = navn;
        this.deltager = deltager;
    }
    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addLedsager(this);
        }
    }
    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeLedsager(this);
        }
    }
    public Deltager getDeltager() {
        return deltager;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }
    public double udflugtPris() {
        double udflugtPris = 0;
        for (Udflugt u : udflugter) {
            udflugtPris += u.getPris();
        }
        return udflugtPris;
    }

    @Override
    public String toString() {
        return "Ledsager{" +
                "navn='" + navn + '\'' +
                ", deltager=" + deltager +
                '}';
    }
}
