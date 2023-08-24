package controller.model;

import java.util.ArrayList;

public class Bil {
    private int regNr;

    private final ArrayList<Prisgruppe> prisgrupper = new ArrayList<>();

    private final ArrayList<Lejekontrakt> lejekontrakter = new ArrayList<>();


    public Bil(int regNr, Prisgruppe prisgruppe) {
        this.regNr = regNr;
        prisgruppe.add(this);
    }

    public int getRegNr() {
        return regNr;
    }

    public void setRegNr(int regNr) {
        this.regNr = regNr;
    }

    public ArrayList<Prisgruppe> getPrisgruppes() {
        return prisgrupper;
    }

    public ArrayList<Lejekontrakt> getLejekontrakter() {
        return lejekontrakter;
    }

    public void addLejekontrakt(Lejekontrakt lejekontrakt) {
        lejekontrakter.add(lejekontrakt);
        lejekontrakt.setBil(this);
    }

    public void removeLejekontrakt(Lejekontrakt lejekontrakt){
        lejekontrakter.remove(lejekontrakt);
        lejekontrakt.setBil(this);
    }

    public void removeBil(Lejekontrakt lejekontrakt) {
    }
}
