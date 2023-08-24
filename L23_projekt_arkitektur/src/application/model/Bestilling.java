package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Bestilling {

    private LocalDate dato;
    private Kunde kunde;
    private ArrayList<Plads> pladser = new ArrayList<>();
    private Forestilling forestilling;

    public Bestilling(LocalDate dato, Forestilling forestilling){
        this.dato = dato;
        this.forestilling = forestilling;
    }

    public Kunde getKunde(){
        return kunde;
    }

    public Forestilling getForestilling(){
        return forestilling;
    }

    public void setForestilling(Forestilling forestilling){
        this.forestilling = forestilling;
    }

    public void addPlads(Plads plads){
        if(!pladser.contains(plads)){
            pladser.add(plads);
        }
    }

    public void removePlads(Plads plads){
        if(pladser.contains(plads)){
            pladser.remove(plads);
        }
    }

    public void setKunde(Kunde kunde){
        if(this.kunde != kunde){
            Kunde oldKunde = this.kunde;
            if(oldKunde != null){
                oldKunde.removeBestilling(this);
            }
            this.kunde = kunde;
            if(kunde != null){
                kunde.addBestilling(this);
            }
        }
    }

    public int samletPris() {
        int samletPris = 0;
        for (Plads plads : pladser) {
            samletPris += plads.getPris();
        }
        return samletPris;
    }

    public LocalDate getDato(){
        return dato;
    }

    public ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }
}
