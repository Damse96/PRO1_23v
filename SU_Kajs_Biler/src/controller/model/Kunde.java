package controller.model;

import java.util.ArrayList;

public class Kunde {
    private String navn;
    private final ArrayList<Lejekontrakt> lejekontrakter = new ArrayList<>();



    public Kunde(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public ArrayList<Lejekontrakt> getLejekontrakter() {
        return new ArrayList<>(lejekontrakter);
    }



    public void removeKunde(Lejekontrakt lejekontrakt) {
        if (lejekontrakter.contains(lejekontrakt)){
            lejekontrakter.remove(lejekontrakt);
            lejekontrakt.setKunde(this);
        }

        
    }

    public void addLejekontrakt(Lejekontrakt lejekontrakt) {
        if (lejekontrakter.contains(lejekontrakt)){
            lejekontrakter.add(lejekontrakt);
            lejekontrakt.setKunde(this);
        }
    }
}
